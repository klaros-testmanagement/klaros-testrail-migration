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

/**
 * A wrapper for a test case step.
 */
public class TestStepContainer implements Serializable {

    private static final long serialVersionUID = 1205668093741316974L;

    private String description;
    private String precondition;
    private String postcondition;
    private String expectedResult;

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {

        return description;
    }

    /**
     * Sets the description.
     *
     * @param description the new description
     */
    public void setDescription(final String description) {

        this.description = description;
    }

    /**
     * Gets the precondition.
     *
     * @return the precondition
     */
    public String getPrecondition() {

        return precondition;
    }

    /**
     * Sets the precondition.
     *
     * @param precondition the new precondition
     */
    public void setPrecondition(final String precondition) {

        this.precondition = precondition;
    }

    /**
     * Gets the postcondition.
     *
     * @return the postcondition
     */
    public String getPostcondition() {

        return postcondition;
    }

    /**
     * Sets the postcondition.
     *
     * @param postcondition the new postcondition
     */
    public void setPostcondition(final String postcondition) {

        this.postcondition = postcondition;
    }

    /**
     * Gets the expected result.
     *
     * @return the expected result
     */
    public String getExpectedResult() {

        return expectedResult;
    }

    /**
     * Sets the expected result.
     *
     * @param expectedResult the new expected result
     */
    public void setExpectedResult(final String expectedResult) {

        this.expectedResult = expectedResult;
    }

    @Override
    public String toString() {

        final StringBuilder result = new StringBuilder();
        result.append("Description: ").append(description);
        result.append("\nPrecondition: ").append(precondition);
        result.append("\nPostcondition: ").append(postcondition);
        result.append("\nExpected Result: ").append(expectedResult).append('\n');

        return result.toString();
    }
}
