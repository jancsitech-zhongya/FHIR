---
layout: post
title: Bring your own Persistence Layer
description: Learn how to build and test a persistence layer for the IBM FHIR Server
permalink: /BringYourOwnPersistence/
---

## Overview
The IBM FHIR Server is a modular Java implementation of the HL7 FHIR specification with a focus on performance and configurability. The IBM FHIR Server ships with a JDBC persistence layer that works with IBM Db2, PostgreSQL and Apache Derby. With this modular design, it's possible to add support for other relational databases and/or plug in any other persistence layer.

This document outlines the interfaces that need to be implemented and the behaviors required for the related methods to work with the IBM FHIR Server.

### Interfaces
Persistence layer interfaces are defined in the `fhir-persistence` module.

* [FHIRPersistence](https://github.com/LinuxForHealth/FHIR/blob/main/fhir-persistence/src/main/java/com/ibm/fhir/persistence/FHIRPersistence.java) defines the contract between the REST layer and the persistence layer.
* [FHIRPersistenceFactory](https://github.com/LinuxForHealth/FHIR/blob/main/fhir-persistence/src/main/java/com/ibm/fhir/persistence/FHIRPersistenceFactory.java) is the interface for providing instances of FHIRPersistence to the server.

### Configuration
Which persistence layer is used by the server is determined by the `/fhirServer/persistence/factoryClassname` property in `fhir-server-config.json`. There is more detail on the configuration in the [IBM FHIR Server's User Guide](https://linuxforhealth.github.io/FHIR/guides/FHIRServerUsersGuide#33-persistence-layer-configuration)

When the default `com.ibm.fhir.persistence.jdbc.FHIRPersistenceJDBCFactory` is used, the returned FHIRPersistenceJDBCImpl instance will look up a corresponding datasource, by JNDI name, using the combination of the tenant id and datastore id from the request context. Specifically, the connection strategy will use the `fhirServer/persistence/<datasourceId>/jndiName` property in the tenant config, or -- if the property is omitted --it will construct the name via the following pattern:

``` md
jdbc/fhir_<tenantId>_<datasourceId>[_ro]
```

Note, the `_ro` postfix means the datasource is 'Read Only'.

## Adding support for another relational database
Adding a new relational database type is not for the faint of heart, but the IBM FHIR Server team is here to help!
To add support for an alternative relational database, there are multiple modules to consider:

1. `fhir-database-utils`
2. `fhir-persistence-schema`
3. `fhir-persistence-jdbc`

The `fhir-database-utils` module provides generic utilities for defining a PhysicalDataModel and applying it to a target database via the IDatabaseAdapter and IVersionHistoryService interfaces. Check out the `com.ibm.fhir.database.utils.db2`, `com.ibm.fhir.database.utils.postgres` and `com.ibm.fhir.database.utils.derby` packages to understand how you might extend the framework with support for a new database type.

The `fhir-persistence-schema` module is used to programmatically construct DDL statements and execute them against a target database. This module uses the generic utilities in `fhir-database-utils` to deploy both an admin schema (used for tenant provisioning and schema versioning) and an application schema for the FHIR data.

Presently, the `fhir-persistence-schema` and `fhir-persistence-jdbc` modules work with Postgres, Derby and Db2 databases, but it should be possible to either:

1. Print the DDL and manually tweak it for your desired database; or
2. Add configuration to control which IDatabaseAdapter and IDatabaseTranslator are used.

Note, the Db2 implementation uses stored procedures, the Postgres implementation uses Functions, and the Derby implementation is JDBC.

Finally, the `fhir-persistence-jdbc` module provides the default implementation of the `FHIRPersistence` interface.

The module makes heavy use of Data Access Objects (DAO) and Data Transfer Objects (DTO) to abstract the details of the database. Most of the code is common across database types, but there is a branch in `ResourceDAOImpl.insert` which corresponds to the differences between the IBM Db2/Postgres flavors and Apache Derby (pure JDBC) flavor of implementation.

## Building your own persistence layer
Most FHIR projects are interoperability projects--the data already exists in some datastore.

Due to performance considerations and the complexities of the FHIR API (especially search), we generally recommend converting that data to FHIR and storing the binary representation in the IBM FHIR Server's database. However, in some cases, it might be better to configure the IBM FHIR Server to work directly with an existing datastore or APIs.

If you are using Maven, add the following dependencies to your persistence layer module (replacing the version variables with your desired version):

``` xml
<dependency>
    <groupId>com.ibm.fhir</groupId>
    <artifactId>fhir-persistence</artifactId>
    <version>${fhir.persistence.version}</version>
</dependency>
<dependency>
    <groupId>com.ibm.fhir</groupId>
    <artifactId>fhir-persistence</artifactId>
    <version>${fhir.persistence.version}</version>
    <type>test-jar</type>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>com.ibm.fhir</groupId>
    <artifactId>fhir-examples</artifactId>
    <version>${fhir.examples.version}</version>
    <scope>test</scope>
</dependency>
```

You might also want to set up `fhir-persistence-jdbc` to use an example.

### Implementing the FHIRPersistence Interface
As described [above](#interfaces), implementing your own persistence layer boils down to configuring the server to use your own FHIRPersistenceFactory and returning your own implementation of FHIRPersistence. The REST layer processes HTTP requests and distills them into one or more calls to this instance. Parameters are passed via a combination of the passed FHIRPersistenceContext and the ThreadLocal FHIRRequestContext.

Although the HL7 FHIR specification [doesn't strictly require all servers to support versioning](https://hl7.org/fhir/R4B/http.html#versions), the IBM FHIR Server is built to be version-aware. This means that all FHIRPersistence implementations should implement the `vread` and `history` interactions.
Similarly, the IBM FHIR Server was written for read/write datastores and so `create` and `update` should be supported as well.
If you have a use case for a read-only or non-version-aware server, please contact us and consider contributing the necessary modifications to the server to make this supported.

The IBM FHIR Server does support persistence implementations which do not support `delete` or transactions (e.g. for transaction bundles), so please implement `FHIRPersistence.isTransactional()` and `isDeleteSupported()` accordingly.

#### Create
Create requests include a FHIRPersistenceContext and an already-validated instance of the resource to create. FHIRPersistence implementations are responsible for adding the `Resource.id`, `Resource.meta.lastUpdate`, and `Resource.meta.versionId` elements to the resource before storing it. Implementations must return a SingleResourceResult with the result of the interaction.

If `SingleResourceResult.success` is set to true, the `SingleResourceResult.resource` should be a copy of the saved resource (with the added fields included).

If `SingleResourceResult.success` is set to false, the `SingleResourceResult.outcome` should be an OperationOutcome with a list of one or more issues that prevented the success of the operation.

Note that a `generateResourceId` implementation is required to generate server-assigned resource ids. For performance reasons, recommend the use of `TimestampPrefixedUUID`.

#### Read
Read requests include a FHIRPersistenceContext, a Class object for the resource type being read, and the logical id of the resource to read.
Implementations should check the FHIRSearchContext of the FHIRPersistenceContext to determine whether the caller would like the full resource back, the resource text or data, or just a summary (see `FHIRSearchContext.getSummaryParameter()`).

For successful requests, `SingleResourceResult.success` must be set to true and `SingleResourceResult.resource` must include a [potentially filtered] resource of the type passed in the request.

For unsuccessful requests, the implementation should return an appropriate Exception:
* FHIRPersistenceResourceNotFoundException if the resource with this id could not be found for the passed resource type
* FHIRPersistenceResourceDeletedException if the latest version of this resource is marked as deleted

For all other errors, the implementation should return a `SingleResourceResult` with a success status of false and a non-null outcome with one or more issues to indicate the failure.

Note: we plan to deprecate these exceptions and use only `SingleResourceResult` as part of https://github.com/LinuxForHealth/FHIR/issues/194.

#### Version read
Version read requests work just like read requests except that the caller passes a version identifier and the persistence implementation must return that specific version of the resource.

#### Update
Update requests include a FHIRPersistenceContext, a resource logical id, and an updated version of the resource to save. FHIRPersistence implementations must set the `Resource.meta.lastUpdate` and `Resource.meta.versionId` elements before storing it. Typically, implementations set the version of the updated resource based on the previous version of the resource which can be found in the FHIRPersistenceEvent (`FHIRPersistenceEvent.getPrevFhirResource()`) of the FHIRPersistenceContext.

Note: at the REST layer, an update request will first invoke read and then invoke update. Similarly, PATCH requests are converted to normal updates before reaching the persistence layer's update implementation.

FHIRPersistence implementations SHOULD use the value of the [`fhirServer/persistence/common/updateCreateEnabled`](https://linuxforhealth.github.io/FHIR/guides/FHIRServerUsersGuide#45-updatecreate-feature) property to determine whether they should allow an update to a resource that doesn't exist yet.

#### Delete
Delete requests include a FHIRPersistenceContext, a Class object for the resource type being deleted, and the logical id of the resource to delete.
FHIRPersistence implementations are expected to be version-aware and therefore must perform a "soft" delete, handling the delete like an update by setting the `Resource.meta.lastUpdate` and `Resource.meta.versionId` elements along with some marker flag to indicate that this resource has been deleted at this version.

For implementations that do not implement delete, FHIRPersistence includes a default implementation which throws a FHIRPersistenceNotSupportedException.

#### History
The IBM FHIR Server currently only supports history at the resource instance level. History requests include a FHIRPersistenceContext with an embedded FHIRHistoryContext, a Class object for the resource type being requested, and the logical id of the resource for which to show the history. Implementations should also check the FHIRSearchContext of the FHIRPersistenceContext to determine whether the caller would like the full resources back, the resource text or data, or just a summary (see `FHIRSearchContext.getSummaryParameter()`).

FHIRHistoryContext extends FHIRPagingContext and provides the requested page size and page number to return.
Similarly, FHIRPersistence implementations should check and honor the the `since` attribute (when valued).

In addition to setting the MultiResourceResult success indicator and the resource version instances for the requested page, FHIRPersistence implementations must set the total number of versions for the requested resource (`FHIRPagingContext.setTotalCount(int)`) and a map of deleted resource versions (`FHIRHistoryContext.setDeletedResources()`) for the REST layer to properly construct the response bundle and accurately reflect which versions are deletes (rather than updates).

The FHIRPersistence also supports whole system `_history`. If supported, `isChangesSupported` must return true, and `changes` must be implemented to return a list of ResourceChangeLogRecord DTOs.

#### Search
The [FHIR Search specification](https://hl7.org/fhir/R4B/search.html) is sprawling and difficult to implement in its entirety. At the persistence layer, search requests will include a FHIRPersistenceContext with an embedded FHIRSearchContext and a Class object to indicate the resource type(s) to search on.
A Class of `com.ibm.fhir.model.type.Resource` is passed for searches performed at the "whole-system" level.

The query parameters passed in the HTTP request are parsed at the REST layer and passed to the persistence layer in the form of a FHIRSearchContext.
The FHIRSearchContext separates "return" parameters (like `_include`, `_revinclude`, `_sort`, etc.) from search parameters and makes them available through dedicated getters.
Each search parameter is parsed into a QueryParameter and a QueryParameterValue. [Compartment](https://hl7.org/fhir/R4B/compartmentdefinition.html) searches are converted into [chained parameters](https://hl7.org/fhir/R4B/search.html#chaining), which are represented through nested QueryParameter objects within the outermost QueryParameter.
Check `com.ibm.fhir.search.util.SearchUtil.parseQueryParameters()` for more information.

FHIRSearchContext extends FHIRPagingContext and provides the requested page size and page number to return.
FHIRPersistence implementations are responsible for setting the total number of search results (`FHIRPagingContext.setTotalCount(int)`) for the given query.

On success, set `MultiResourceResult.success` to true and set `MultiResourceResult.resource` to the list of resources [or resource summaries] for the requested page.

On failure, set `MultiResourceResult.success` to false and set `MultiResourceResult.outcome` to an OperationOutcome with one or more issues which indicate the failure.

#### Extended Operations

The IBM FHIR Server supports [extended operations](https://hl7.org/fhir/R4B/operations.html). The IBM FHIR Server has some operations which use custom persistence interactions:

| Operation Name | Interfaces to implement |
|----------------|-------------------------|
| `$healthcheck` | `getHealth` must be implemented to indicate if the persistence layer is in a healthy state and can access the data store |
| `$erase`  | `erase` must be implemented so that ResourceEraseRecord is returned for each Erase operation.  If not implemented it throws an exception|
| `$export` | `fetchResourcePayloads` must be implemented so that the ResourcePayload is returned as a BinaryStream |
| `$reindex`| `isReindexSupported` must be true and, if true, `reindex` must be implemented so that users can apply the latest search configuration to a resource after it is already ingested|

## Testing your persistence layer
In addition to defining the interfaces, the `fhir-persistence` module includes a set of tests that you can extend to test your implementation.

Most of the tests defined in this module relate to search, but they also exercise the create, update, and delete interactions in the process.
The tests in the `com.ibm.fhir.persistence.search.test` package are organized by search parameter type and they utilize tenant-specific search parameter definitions from the `fhir-persistence/src/test/resources/config` directory and search for fields on the generated example resources at `fhir-examples/src/main/resources/json/ibm/basic`. The `fhir-examples` module is available on Maven Central [link](https://repo1.maven.org/maven2/com/ibm/fhir/fhir-examples/).

For an example of how to extend these tests, see the `com.ibm.fhir.persistence.jdbc.search.test` package under `fhir-persistence-jdbc/src/test/java`.

Finally, the IBM FHIR Server contains a number of end-to-end (e2e) integration tests under the [`fhir-server-test`](https://github.com/LinuxForHealth/FHIR/tree/main/fhir-server-test) module. These tests can be executed against a running server that is configured with your persistence layer to provide further confidence in your implementation.
