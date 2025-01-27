/*
 * (C) Copyright IBM Corp. 2021
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package com.ibm.fhir.schema.control;

import java.util.logging.Logger;

import com.ibm.fhir.database.utils.api.ISchemaAdapter;
import com.ibm.fhir.database.utils.model.DataModelVisitorBase;
import com.ibm.fhir.database.utils.model.ForeignKeyConstraint;
import com.ibm.fhir.database.utils.model.Table;

/**
 * Visitor adapter used to add all the foreign key constraints
 * associated with tables in the schema.
 *
 * Expects any transaction handling to be performed outside this class.
 */
public class AddForeignKey extends DataModelVisitorBase {
    private static final Logger logger = Logger.getLogger(DropForeignKey.class.getName());

    // The database adapter used to issue changes to the database
    private final ISchemaAdapter adapter;
    private final String tenantColumnName;
    /**
     * Public constructor
     * @param adapter
     */
    public AddForeignKey(ISchemaAdapter adapter, String tenantColumnName) {
        this.adapter = adapter;
        this.tenantColumnName = tenantColumnName;
    }

    @Override
    public void visited(Table fromChildTable, ForeignKeyConstraint fk) {
        // Enable (add) the FK constraint
        logger.info(String.format("Adding foreign key: %s.%s[%s]", fromChildTable.getSchemaName(), fromChildTable.getObjectName(), fk.getConstraintName()));
        fk.apply(fromChildTable.getSchemaName(), fromChildTable.getObjectName(), this.tenantColumnName, adapter, fromChildTable.getDistributionType());
    }
}