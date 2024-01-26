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

import java.util.ArrayDeque;
import java.util.Deque;

public class CategoryBuilder {

    private CategoryTree categoryTree;
    private Deque<CategoryNode> categoryStack;

    public CategoryBuilder() {

        categoryTree = null;
        categoryStack = new ArrayDeque<>();
    }

    /**
     * Gets the category tree.
     *
     * @return the category tree
     */
    public CategoryTree getCategoryTree() {

        return categoryTree;
    }

    /**
     * Gets the current category.
     *
     * @return the category
     */
    public CategoryNode getCategory() {

        return categoryStack.peek();
    }

    /**
     * Push category.
     *
     * @param name the name
     * @param description the description
     */
    public void pushNewCategory(final String name, final String description) {

        if (categoryTree == null) {
            categoryTree = new CategoryTree("Categories");
            final CategoryNode root = new CategoryNode("All", null);
            categoryTree.setRoot(root);
            categoryStack.push(root);
        }

        CategoryNode newNode = new CategoryNode(name, description);

        boolean present = false;
        final CategoryNode currentCategory = getCategory();
        for (CategoryNode childCategory : currentCategory.getChildren()) {
            if (name.equals(childCategory.getName())) {
                present = true;
                break;
            }
        }
        if (!present) {
            currentCategory.getChildren().add(newNode);
        }
        categoryStack.push(newNode);
    }

    public void popCategory(final String name) {

        if (!name.equals(categoryStack.getLast().getName())) {
            categoryStack.pop();
        } else {
            throw new IllegalArgumentException("Category" + name + " not found");
        }
    }
}
