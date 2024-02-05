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

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Iterator;

import de.verit.klaros.migration.testrail.ProjectContext;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Node;
import nu.xom.ParsingException;

/**
 * The parser for ApTest XML files.
 */
public final class TestCaseParser {

    /** No instances. */
    private TestCaseParser() {

    }

    /**
     * Parses the input stream containing a serialized ApTest XML file and add the parsed result to the
     * context.
     *
     * @param projectContext the project context
     * @param in the input stream
     * @throws ParsingException The generic superclass for all thechecked exceptions thrown in XOM.
     * @throws IOException Signals that an I/O exception of some sort has occurred.
     */
    public static void parse(final ProjectContext projectContext, final InputStream in)
        throws ParsingException, IOException {

        final Builder parser = new Builder();
        final Document doc = parser.build(in);
        final CategoryBuilder categoryBuilder = new CategoryBuilder();

        if (!"suite".equals(doc.getRootElement().getLocalName())) {
            throw new ParsingException("Not a valid TestRail export file");
        }

        parseSectionContainers(doc.getRootElement(), projectContext, categoryBuilder);

        projectContext.getTestCaseContainer().setCategoryTree(categoryBuilder.getCategoryTree());
    }

    /**
     * Parses the sections containers.
     *
     * @param node the node to parse
     * @param projectContext the project context
     * @param categoryBuilder the category builder
     */
    private static void parseSectionContainers(final Node node, final ProjectContext projectContext,
        final CategoryBuilder categoryBuilder) {

        final Iterator<Node> sectionsNodesIterator = node.query("sections").iterator();
        if (sectionsNodesIterator.hasNext()) {
            final Node next = sectionsNodesIterator.next();
            parseSections(next, projectContext, categoryBuilder);
        }
    }

    /**
     * Parses the section information of the given node and adds the information to the category builder.
     *
     * @param parent the parent
     * @param projectContext the project context
     * @param categoryBuilder the category builder
     */
    private static void parseSections(final Node parent, final ProjectContext projectContext,
        final CategoryBuilder categoryBuilder) {

        final Iterator<Node> sectionsIterator = parent.query("section").iterator();
        while (sectionsIterator.hasNext()) {
            final Node section = sectionsIterator.next();
            final String nodeName = getNodeElementText(section, "name");
            categoryBuilder.pushNewCategory(nodeName);

            parseTestCases(section, projectContext, categoryBuilder);
            parseSectionContainers(section, projectContext, categoryBuilder);

            categoryBuilder.popCategory(nodeName);
        }
    }

    /**
     * Parse the test cases of the givent node and add te result to the project context.
     *
     * @param parent the parent docment node
     * @param projectContext the project context
     * @param categoryBuilder the category builder
     */
    private static void parseTestCases(final Node parent, final ProjectContext projectContext,
        final CategoryBuilder categoryBuilder) {

        for (final Node testCaseNode : parent.query("cases/case")) {

            final TestCaseContainer testCase = new TestCaseContainer();

            final String externalId = testCaseNode.query("id").iterator().next().getValue();

            testCase.setExternalId(externalId);
            testCase.setShortname(getNodeElementText(testCaseNode, "title"));
            testCase.setPriority(mapToPriority(getNodeElementText(testCaseNode, "priority")));
            testCase.setAreatopic(mapToAreatopic(getNodeElementText(testCaseNode, "type")));
            testCase.setCategory(categoryBuilder.getCategoryChain());

            testCase.setPrecondition(getNodeElementText(testCaseNode, "custom/preconds"));

            for (final Node testStepNode : testCaseNode.query("custom/steps_separated/step")) {

                final TestStepContainer testCaseStep = new TestStepContainer();

                testCaseStep.setExpectedResult(getNodeElementText(testStepNode, "expected"));
                testCaseStep.setDescription(getNodeElementText(testStepNode, "content"));
                testCase.addTestCaseStep(testCaseStep);
            }

            projectContext.getTestCaseContainer().getTestCases().add(testCase);
        }
    }

    /**
     * Map the TestRail field to a Klaros test area.
     *
     * @param input the input
     * @return the Klaros test area
     */
    private static String mapToAreatopic(final String input) {

        final String result;
        switch (input) {
            case "Functionality" :
                result = "FUNCTIONAL";
                break;
            case "Performance" :
                result = "NON_FUNCTIONAL";
                break;
            case "Regression" :
                result = "REGRESSION";
                break;
            case "Low" :
                result = "STRUCTURAL";
                break;
            default :
                result = "EMPTY";
                break;
        }
        return result;
    }

    /**
     * Map the TestRail field to a Klaros priority.
     *
     * @param input the input
     * @return the Klaros priority
     */
    private static String mapToPriority(final String input) {

        final String result;
        switch (input) {
            case "High" :
                result = "HIGH";
                break;
            case "Medium" :
                result = "MEDIUM";
                break;
            case "Low" :
                result = "LOW";
                break;
            default :
                result = "EMPTY";
                break;
        }
        return result;
    }

    /**
     * Gets the node element text.
     *
     * @param node the node
     * @param element the element
     * @return the node element text
     * @throws URISyntaxException
     */
    private static String getNodeElementText(final Node node, String element) {

        final Iterator<Node> iterator = node.query(element).iterator();

        if (iterator.hasNext()) {

            return iterator.next().getValue();
        } else {
            return null;
        }
    }
}
