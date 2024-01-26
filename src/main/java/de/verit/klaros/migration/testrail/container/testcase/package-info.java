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
@XmlSchema(elementFormDefault = jakarta.xml.bind.annotation.XmlNsForm.QUALIFIED,
    namespace = TestCaseExportContainer.NAMESPACE_URI, xmlns = {@XmlNs(
        namespaceURI = TestCaseExportContainer.NAMESPACE_URI, prefix = "t") })
@XmlAccessorType(XmlAccessType.PROPERTY)
package de.verit.klaros.migration.testrail.container.testcase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlSchema;
