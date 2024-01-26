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
 * A category tree. It contains a string name for the category tree name and a single root node.
 */
public class CategoryTree implements Serializable {

    private static final long serialVersionUID = 8389766484891189250L;

    private String name;
    private CategoryNode root;

    /**
     * Instantiates a new category tree.
     *
     * @param name the name string
     */
    public CategoryTree(String name) {

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
     * @return Returns the root category.
     */
    public CategoryNode getRoot() {

        return root;
    }

    /**
     * @param parent The root to set.
     */
    public void setRoot(final CategoryNode root) {

        this.root = root;
    }
}
