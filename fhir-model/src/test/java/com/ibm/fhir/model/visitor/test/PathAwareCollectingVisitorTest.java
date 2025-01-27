/*
 * (C) Copyright IBM Corp. 2022
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.fhir.model.visitor.test;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.testng.annotations.Test;

import com.ibm.fhir.model.resource.Patient;
import com.ibm.fhir.model.resource.ValueSet;
import com.ibm.fhir.model.resource.ValueSet.Expansion;
import com.ibm.fhir.model.type.DateTime;
import com.ibm.fhir.model.type.Extension;
import com.ibm.fhir.model.type.HumanName;
import com.ibm.fhir.model.type.Meta;
import com.ibm.fhir.model.type.Narrative;
import com.ibm.fhir.model.type.Xhtml;
import com.ibm.fhir.model.type.code.NarrativeStatus;
import com.ibm.fhir.model.type.code.PublicationStatus;
import com.ibm.fhir.model.visitor.PathAwareCollectingVisitor;

public class PathAwareCollectingVisitorTest {
    @Test
    public void testPrimitiveSetterEquivalence() {
        Patient p1 = Patient.builder()
                .text(Narrative.builder()
                        .status(NarrativeStatus.ADDITIONAL)
                        .div(Xhtml.of(Xhtml.DIV_OPEN + "<div>this<br/>is<br/>a test</div>" + Xhtml.DIV_CLOSE))
                        .build())
                .meta(Meta.builder()
                    .lastUpdated(ZonedDateTime.of(2021, 8, 19, 00, 59, 59, 0, ZoneOffset.of("-05:00"))) // Instant
                    .build())
                .extension(Extension.builder()
                    .url("test")
                    .value("string")
                    .build())
                .contained(ValueSet.builder()
                    .status(PublicationStatus.DRAFT)
                    .expansion(Expansion.builder()
                        .timestamp(DateTime.of("2021-08-19T00:59:59-05:00"))
                        .total(0)                                                                       // Integer
                        .build())
                    .build())
                .active(false)                                                                          // Boolean
                .birthDate(LocalDate.of(1984, 9, 4))                                                    // Date
                .multipleBirth(1)
                .name(HumanName.builder()
                    .given("Lee")                                                                       // String
                    .build())
                .build();

        PathAwareCollectingVisitor<Extension> extCollector = new PathAwareCollectingVisitor<Extension>(Extension.class);
        p1.accept(extCollector);
        System.out.println(extCollector.getResult());
    }
}
