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
package de.verit.klaros.migration.testrail.container.common;

import java.io.Serializable;
import java.util.List;

/**
 * interface for dynamic attributes.
 */
public interface IDynamicAttributeContainer extends Serializable {

    /**
     * Gets the name.
     *
     * @return the name
     */
    String getName();

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    void setName(String name);

    /**
     * Gets the value.
     *
     * @return the value
     */
    String getValue();

    /**
     * Sets the value.
     *
     * @param value the new value
     */
    void setValue(String value);

    /**
     * Gets the list of values.
     *
     * @return the list of values
     */
    List<String> getValues();

    /**
     * Sets the values.
     *
     * @param values the values
     */
    void setValues(List<String> values);
}
