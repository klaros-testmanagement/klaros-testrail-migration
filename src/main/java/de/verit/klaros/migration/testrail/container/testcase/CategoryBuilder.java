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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CategoryBuilder {

    public static final Pattern NODE_PATTERN = Pattern.compile("^\\d+_([^/]+)/.*");
    public static final Pattern PREFIX_NAME_PATTERN = Pattern.compile("^\\d+_(.*)");
    public static final Pattern POSTFIX_NAME_PATTERN = Pattern.compile("(.*)_\\\\d+");

    private CategoryTree categoryTree;
    private Deque<CategoryNode> categoryStack;

    public CategoryBuilder() {

        categoryTree = null;
        categoryStack = new ArrayDeque<>();
    }

    /**
     * Gets the category nodes.
     *
     * @param input the input
     * @return the category nodes
     */
    public CategoryNode getCategoryChain() {

        Object[] nodes = categoryStack.toArray();
        CategoryNode result =  new CategoryNode(((CategoryNode) nodes[nodes.length - 1]).getName());
        CategoryNode activeNode =  result;
        for (int i = nodes.length - 1; i >= 0; i--) {
            final CategoryNode currentNode = (CategoryNode) nodes[i];
            activeNode.setName(currentNode.getName());
            if (i > 0) {
                CategoryNode nextNode = new CategoryNode();
                activeNode.getChildren().add(nextNode);
                activeNode = nextNode;
            }
        }
        return result;
    }

    /**
     * Gets the object name.
     *
     * @param input the input
     * @return the object name
     */
    public String getObjectName(final String input) {

        String name = input.substring(input.lastIndexOf('/') + 1);
        final String result;
        final Matcher prefixMatcher = PREFIX_NAME_PATTERN.matcher(name);
        if (prefixMatcher.matches()) {
            result = prefixMatcher.group(1);
        } else {
            final Matcher postfixMatcher = POSTFIX_NAME_PATTERN.matcher(name);
            if (prefixMatcher.matches()) {
                result = postfixMatcher.group(1);
            } else {
                result = name;
            }
        }
        return result.replace('_', ' ');
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
    public void pushNewCategory(final String name) {

        if (categoryTree == null) {
            categoryTree = new CategoryTree("Categories");
            final CategoryNode root = new CategoryNode("All");
            categoryTree.setRoot(root);
            categoryStack.push(root);
        }

        CategoryNode newNode = new CategoryNode(name);

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
