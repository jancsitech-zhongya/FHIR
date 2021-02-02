/*
 * (C) Copyright IBM Corp. 2021
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.fhir.persistence.payload;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPOutputStream;

import com.ibm.fhir.model.format.Format;
import com.ibm.fhir.model.parser.FHIRParser;
import com.ibm.fhir.model.parser.exception.FHIRParserException;
import com.ibm.fhir.model.resource.Resource;

/**
 * Collection of helper methods related to the persistence of FHIR resource payload data
 */
public class PayloadPersistenceHelper {
    /**
     * Compress the payload
     * @param payload
     * @return the compressed bytes
     * @throws IOException
     */
    public static byte[] compressPayload(String payload) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        GZIPOutputStream os = new GZIPOutputStream(bos);
        os.write(payload.getBytes(StandardCharsets.UTF_8));

        // compressed bytes are written to the ByteArrayOutputStream, so that's
        // where we need to collect them
        return bos.toByteArray();
    }

    /**
     * Parse the Resource from the (uncompressed) stream
     * @param <T>
     * @param is the JSON stream in UTF_8
     * @return
     * @throws FHIRParserException
     */
    public static <T extends Resource> T parse(InputStream is) throws FHIRParserException {
        return FHIRParser.parser(Format.JSON).parse(new InputStreamReader(is, StandardCharsets.UTF_8));
    }
}
