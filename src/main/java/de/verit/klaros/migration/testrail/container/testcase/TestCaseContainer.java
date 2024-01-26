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

import de.verit.klaros.migration.testrail.container.common.IDynamicAttributeContainer;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;


/**
 * POJO class to map test cases to.
 */
public class TestCaseContainer implements Serializable {

    private static final long serialVersionUID = -4903949586514992925L;

    private String externalId;
    private String revision;
    private String shortname;
    private String description;
    private String precondition;
    private String postcondition;
    private String expectedResult;
    private String depends;
    private String note;
    private String areatopic;
    private String method;
    private String variety;
    private String execution;
    private String priority;
    private String state;
    private String team;
    private String level;
    private String docbase;
    private String dependency;
    private String evaluation;
    private String traceability;
    private String estimatedDuration;

    private List<DynamicAttributeContainer> attributes;
    private List<TestStepContainer> steps;
    private List<AttachmentContainer> attachments;
    private CategoryNode category;

    /**
     * Instantiates a new container.
     */
    public TestCaseContainer() {

        super();

        steps = new ArrayList<>();
        attributes = new ArrayList<>();
        attachments = new ArrayList<>();
    }

    /**
     * Add a test case step container.
     *
     * @param container the test case step container
     */
    public void addTestCaseStep(final TestStepContainer container) {

        steps.add(container);
    }

    /**
     * Gets the steps.
     *
     * @return Returns the test case step containers.
     */
    @XmlElement(name = "step")
    @XmlElementWrapper(name = "steps", required = false)
    public final List<TestStepContainer> getSteps() {

        return steps;
    }

    /**
     * Sets the steps.
     *
     * @param containers The step containers to set.
     */
    public void setSteps(final List<TestStepContainer> containers) {

        steps = containers;
    }

    /**
     * Gets the revision.
     *
     * @return the revision
     */
    public String getRevision() {

        return revision;
    }

    /**
     * Sets the revision.
     *
     * @param revision the new revision
     */
    public void setRevision(final String revision) {

        this.revision = revision;
    }

    /**
     * Gets the expected result.
     *
     * @return Returns the expectedResult.
     */
    public String getExpectedResult() {

        return expectedResult;
    }

    /**
     * Sets the expected result.
     *
     * @param expectedResult The expectedResult to set.
     */
    public void setExpectedResult(final String expectedResult) {

        this.expectedResult = expectedResult;
    }

    /**
     * Gets the shortname.
     *
     * @return Returns the shortname.
     */
    public String getShortname() {

        return shortname;
    }

    /**
     * Sets the shortname.
     *
     * @param shortname The shortname to set.
     */
    public void setShortname(final String shortname) {

        this.shortname = shortname;
    }

    /**
     * Gets the team.
     *
     * @return Returns the team.
     */
    public String getTeam() {

        return team;
    }

    /**
     * Sets the team.
     *
     * @param team The team to set.
     */
    public void setTeam(final String team) {

        this.team = team;
    }

    /**
     * Gets the depends.
     *
     * @return Returns the depends.
     */
    public String getDepends() {

        return depends;
    }

    /**
     * Sets the depends.
     *
     * @param depends The depends to set.
     */
    public void setDepends(final String depends) {

        this.depends = depends;
    }

    /**
     * Gets the note.
     *
     * @return Returns the note.
     */
    public String getNote() {

        return note;
    }

    /**
     * Sets the note.
     *
     * @param note The note to set.
     */
    public void setNote(final String note) {

        this.note = note;
    }

    /**
     * Gets the evaluation.
     *
     * @return Returns the evaluation.
     */
    public String getEvaluation() {

        return evaluation;
    }

    /**
     * Sets the evaluation.
     *
     * @param evalutation The evaluation to set.
     */
    public void setEvaluation(final String evalutation) {

        evaluation = evalutation;
    }

    /**
     * Gets the description.
     *
     * @return Returns the description.
     */
    public String getDescription() {

        return description;
    }

    /**
     * Sets the description.
     *
     * @param description The description to set.
     */
    public void setDescription(final String description) {

        this.description = description;
    }

    /**
     * Gets the precondition.
     *
     * @return Returns the precondition.
     */
    public String getPrecondition() {

        return precondition;
    }

    /**
     * Sets the precondition.
     *
     * @param precondition The precondition to set.
     */
    public void setPrecondition(final String precondition) {

        this.precondition = precondition;
    }

    /**
     * Gets the postcondition.
     *
     * @return Returns the postcondition.
     */
    public String getPostcondition() {

        return postcondition;
    }

    /**
     * Sets the postcondition.
     *
     * @param postcondition The postcondition to set.
     */
    public void setPostcondition(final String postcondition) {

        this.postcondition = postcondition;
    }

    /**
     * Gets the traceability.
     *
     * @return Returns the traceability.
     */
    public String getTraceability() {

        return traceability;
    }

    /**
     * Sets the traceability.
     *
     * @param traceability The traceability to set.
     */
    public void setTraceability(final String traceability) {

        this.traceability = traceability;
    }

    /**
     * Gets the estimated duration.
     *
     * @return the estimated duration
     */
    public String getEstimatedDuration() {

        return estimatedDuration;
    }

    /**
     * Sets the estimated duration.
     *
     * @param estimatedDuration the new estimated duration
     */
    public void setEstimatedDuration(final String estimatedDuration) {

        this.estimatedDuration = estimatedDuration;
    }

    /**
     * Gets the areatopic.
     *
     * @return the areatopic
     */
    public String getAreatopic() {

        return areatopic;
    }

    /**
     * Sets the areatopic.
     *
     * @param areatopic the new areatopic
     */
    public void setAreatopic(final String areatopic) {

        this.areatopic = areatopic;
    }

    /**
     * Gets the method.
     *
     * @return the method
     */
    public String getMethod() {

        return method;
    }

    /**
     * Sets the method.
     *
     * @param method the new method
     */
    public void setMethod(final String method) {

        this.method = method;
    }

    /**
     * Gets the variety.
     *
     * @return the variety
     */
    public String getVariety() {

        return variety;
    }

    /**
     * Sets the variety.
     *
     * @param variety the new variety
     */
    public void setVariety(final String variety) {

        this.variety = variety;
    }

    /**
     * Gets the execution.
     *
     * @return the execution
     */
    public String getExecution() {

        return execution;
    }

    /**
     * Sets the execution.
     *
     * @param execution the new execution
     */
    public void setExecution(final String execution) {

        this.execution = execution;
    }

    /**
     * Gets the priority.
     *
     * @return the priority
     */
    public String getPriority() {

        return priority;
    }

    /**
     * Sets the priority.
     *
     * @param priority the new priority
     */
    public void setPriority(final String priority) {

        this.priority = priority;
    }

    /**
     * Gets the state.
     *
     * @return the state
     */
    public String getState() {

        return state;
    }

    /**
     * Sets the state.
     *
     * @param state the new state
     */
    public void setState(final String state) {

        this.state = state;
    }

    /**
     * Gets the level.
     *
     * @return the level
     */
    public String getLevel() {

        return level;
    }

    /**
     * Sets the level.
     *
     * @param level the new level
     */
    public void setLevel(final String level) {

        this.level = level;
    }

    /**
     * Gets the docbase.
     *
     * @return the docbase
     */
    public String getDocbase() {

        return docbase;
    }

    /**
     * Sets the docbase.
     *
     * @param docbase the new docbase
     */
    public void setDocbase(final String docbase) {

        this.docbase = docbase;
    }

    /**
     * Gets the dependency.
     *
     * @return the dependency
     */
    public String getDependency() {

        return dependency;
    }

    /**
     * Sets the dependency.
     *
     * @param dependency the new dependency
     */
    public void setDependency(final String dependency) {

        this.dependency = dependency;
    }

    @Override
    public String toString() {

        final StringBuilder result = new StringBuilder();
        result.append("Name: ").append(getShortname());
        result.append("\nRevision: ").append(getRevision());
        result.append("\nDescription: ").append(getDescription());
        result.append("\nPrecondition: ").append(getPrecondition());
        result.append("\nPostcondition: ").append(getPostcondition());
        result.append("\nExpected Result: ").append(getExpectedResult());
        result.append("\nNote: ").append(getNote());
        result.append("\nTraceability: ").append(getTraceability()).append('\n');
        for (final TestStepContainer step : steps) {
            result.append("Step:").append(step).append('\n');
        }
        for (final IDynamicAttributeContainer attribute : getAttributes()) {
            result.append(attribute).append('\n');
        }

        return result.toString();
    }
    /**
     * Gets the attributes.
     *
     * @return Returns the dynamic attribute containers.
     */
    @XmlElement(name = "attribute")
    @XmlElementWrapper(name = "attributes", required = false)
    public final List<DynamicAttributeContainer> getAttributes() {

        return attributes;
    }

    /**
     * Sets the attributes.
     *
     * @param containers The dynamic attributes to set.
     */
    public final void setAttributes(final List<DynamicAttributeContainer> containers) {

        attributes = containers;
    }

    /**
     * Gets the external id.
     *
     * @return the external id
     */
    @XmlElement
    public String getExternalId() {

        return externalId;
    }

    /**
     * Sets the external id.
     *
     * @param externalId the new external id
     */
    public void setExternalId(final String externalId) {

        this.externalId = externalId;
    }

    @XmlElement(name = "attachment")
    @XmlElementWrapper(name = "attachments", required = false)
    public List<AttachmentContainer> getAttachments() {

        return attachments;
    }

    public void setAttachments(final List<AttachmentContainer> attachments) {

        this.attachments = attachments;
    }

    /**
     * @return Returns the category.
     */
    public CategoryNode getCategory() {

        return category;
    }

    /**
     * @param category The category to set.
     */
    public void setCategory(CategoryNode category) {

        this.category = category;
    }
}
