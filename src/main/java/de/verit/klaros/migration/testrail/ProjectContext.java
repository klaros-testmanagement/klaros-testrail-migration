/*
 * Copyright 2022 verit Informationssysteme GmbH, Europaallee 10,
 * 67657 Kaiserslautern, Germany, http://www.verit.de.
 *
 * All rights reserved.
 *
 * This product or document is protected by copyright and distributed
 * under licenses restricting its use, copying, distribution, and
 * decompilation. No part of this product or documentation may be
 * reproduced in any form by any means without prior written authorization
 * of verit Informationssysteme GmbH and its licensors, if any.
 */
package de.verit.klaros.migration.testrail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import de.verit.klaros.migration.testrail.container.testcase.TestCaseExportContainer;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

/**
 * The project context.
 */
public class ProjectContext {

    private final TestCaseExportContainer testCaseContainer;

    /**
     * Instantiates a new project context.
     *
     * @param projectId the project id
     */
    public ProjectContext() {

        testCaseContainer = new TestCaseExportContainer();
    }

    /**
     * @return Returns the test case export container.
     */
    public TestCaseExportContainer getTestCaseContainer() {

        return testCaseContainer;
    }

    /**
     * Marshal the test cases container to an XML Stream.
     *
     * @return the input stream
     * @throws JAXBException the JAXB exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public InputStream exportTestCases() throws JAXBException, IOException {

        final ByteArrayOutputStream stream = new ByteArrayOutputStream();
        final OutputStreamWriter outputStreamWriter = new OutputStreamWriter(stream, Charset.forName(
            StandardCharsets.UTF_8.name()));

        final JAXBContext jc = JAXBContext.newInstance(testCaseContainer.getClass());

        final Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.FALSE);
        m.setProperty(Marshaller.JAXB_ENCODING, StandardCharsets.UTF_8.name());
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(testCaseContainer, stream);
        outputStreamWriter.close();
        stream.close();
        return new ByteArrayInputStream(stream.toByteArray());
    }
}
