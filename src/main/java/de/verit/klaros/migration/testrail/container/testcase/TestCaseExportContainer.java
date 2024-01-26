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
package de.verit.klaros.migration.testrail.container.testcase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * The test case import container class.
 */
@XmlRootElement(name = "container")
public class TestCaseExportContainer implements Serializable {

    public static final String NAMESPACE_URI = "http://klaros-testmanagement.com/export-testcases-1.0";
    private static final long serialVersionUID = 6554189711419716199L;

    private List<TestCaseContainer> testCases;
    private CategoryTree categoryTree;

    private String testsuite;

    /**
     * Instantiates a new test case import container.
     */
    public TestCaseExportContainer() {

        testCases = new ArrayList<>();
    }

    /**
     * Gets the test cases.
     *
     * @return the test cases
     */
    @XmlElement(name = "testcase")
    @XmlElementWrapper(name = "testcases", required = false)
    public List<TestCaseContainer> getTestCases() {

        return testCases;
    }

    /**
     * Sets the test cases.
     *
     * @param testCases the new test cases
     */
    public void setTestCases(final List<TestCaseContainer> testCases) {

        this.testCases = testCases;
    }

    /**
     * Gets the testsuite.
     *
     * @return the testsuite
     */
    @XmlElement(name = "testsuite")
    public String getTestsuite() {

        return testsuite;
    }

    /**
     * Sets the testsuite.
     *
     * @param testsuite the new testsuite
     */
    public void setTestsuite(final String testsuite) {

        this.testsuite = testsuite;
    }

    /**
     * @return Returns the categoryTree.
     */
    public CategoryTree getCategoryTree() {

        return categoryTree;
    }


    /**
     * @param categoryTree The categoryTree to set.
     */
    public void setCategoryTree(CategoryTree categoryTree) {

        this.categoryTree = categoryTree;
    }
}
