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

/**
 * A node of a category tree. It contains a string value for the category name.
 */
public class CategoryNode implements Serializable {

    private static final long serialVersionUID = -953602324130842052L;

    private String name;
    private List<CategoryNode> children;

    /**
     * Instantiates a new category node.
     */
    public CategoryNode() {

        children = new ArrayList<>();
    }

    /**
     * Instantiates a new category node.
     *
     * @param name the category name
     */
    public CategoryNode(final String name) {

        children = new ArrayList<>();
        this.name = name;
    }


    /**
     * @return Returns the name.
     */
    public String getName() {

        return name;
    }

    /**
     * @param name The name to set.
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * @return Returns the child categories.
     */
    @XmlElement(name = "category")
    public List<CategoryNode> getChildren() {

        return children;
    }

    /**
     * @param children The children to set.
     */
    public void setChildren(List<CategoryNode> children) {

        this.children = children;
    }
}
