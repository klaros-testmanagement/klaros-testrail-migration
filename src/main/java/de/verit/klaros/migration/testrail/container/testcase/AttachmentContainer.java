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
 * An attachment data object containing the name and base64 encoded content.
 */
public class AttachmentContainer implements Serializable {

    private static final long serialVersionUID = 8994459571382763820L;

    private String name;
    private String content;

    /**
     * Instantiates a new attachment container object.
     */
    public AttachmentContainer() {

        super();
    }

    /**
     * Instantiates a new attachment container object.
     *
     * @param name the name of the attachment
     * @param content the binary content of the attachment
     */
    public AttachmentContainer(final String name, final String content) {

        this.name = name;
        this.content = content;
    }

    /**
     * Gets the name of the attachment.
     *
     * @return the name
     */
    public String getName() {

        return name;
    }

    /**
     * Sets the name of the attachment.
     *
     * @param value the new name
     */
    public void setName(final String value) {

        name = value;
    }

    /**
     * Gets the binary content of the attachment.
     *
     * @return the content
     */
    public String getContent() {

        return content;
    }

    /**
     * Sets the content.
     *
     * @param value the new content
     */
    public void setContent(final String value) {

        content = value;
    }
}
