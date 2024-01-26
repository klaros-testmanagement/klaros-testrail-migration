/*
 * Copyright 2023 verit Informationssysteme GmbH, Europaallee 10,
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
package de.verit.klaros.migration.testrail.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.Case;

/**
 * Work in progress.
 */
public class TestRailClient {

    private String url;
    private String username;
    private String password;
    private TestRail testRail;

    /**
     * Instantiates a new test rail client.
     *
     * @param url the test rail instance url
     */
    public TestRailClient(final String url, final String username, final String password,
            final String project) {

        this.url = url;
        this.username = username;
        this.password = password;

        testRail = TestRail.builder(url, username, password).applicationName(project).build();
    }

    /**
     * Gets the test case attachment ids for the given test case id.
     *
     * @param testCaseId the test case id
     * @return the test case attachment ids
     */
    public Collection<String> getTestCaseAttachmentIds(final String testCaseId) {

        List<String> result = new ArrayList<>();
        Case testCase = testRail.cases().get(0, null).execute();
        return result;
    }
}
