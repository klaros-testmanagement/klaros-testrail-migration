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

import java.util.ArrayList;
import java.util.List;

import de.verit.klaros.migration.testrail.container.common.IDynamicAttributeContainer;

/**
 * A wrapper for a dynamic attribute.
 */
public class DynamicAttributeContainer implements IDynamicAttributeContainer {

    private static final long serialVersionUID = 2937302752068005458L;

    private String name;
    private String value;

    private List<String> values;

    /**
     * Create a new DynamicAttributeContainer.
     */
    public DynamicAttributeContainer() {

        super();
    }

    /**
     * Create a DynamicAttributeContainer.
     *
     * @param name the name
     * @param value the value
     */
    public DynamicAttributeContainer(final String name, final String value) {

        super();

        this.name = name;
        this.value = value;
        values = new ArrayList<>();
    }

    /**
     * Create a DynamicAttributeContainer.
     *
     * @param name the name
     * @param values the values
     */
    public DynamicAttributeContainer(final String name, final List<String> values) {

        super();

        this.name = name;
        value = "";
        this.values = values;
    }

    @Override
    public String getName() {

        return name;
    }

    @Override
    public void setName(final String name) {

        this.name = name;
    }

    @Override
    public String getValue() {

        return value;
    }

    @Override
    public void setValue(final String value) {

        this.value = value;
    }

    @Override
    public String toString() {

        final StringBuilder result = new StringBuilder();
        result.append("Attribute: ").append(name);
        result.append("\nValue: ").append(value);
        result.append("\nValues: ").append(values).append('\n');

        return result.toString();
    }

    @Override
    public List<String> getValues() {

        return values;
    }

    @Override
    public void setValues(final List<String> values) {

        this.values = values;
    }
}
