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
package de.verit.klaros.migration.testrail;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import jakarta.xml.bind.JAXBException;
import nu.xom.ParsingException;

/**
 * The basic migration test.
 */
class MigrationTest {

    @Test
    void testBackBugsMigration() throws ParsingException, IOException, JAXBException {

        TestRailTestMigration.migrateTestCases("src/test/resources/backbugs-testrail.xml",
            "target/backbugs-klaros.xml");
        assertTrue(true);
    }

    @Test
    void testBackParabankMigration() throws ParsingException, IOException, JAXBException {

        TestRailTestMigration.migrateTestCases("src/test/resources/parabank-testrail.xml",
            "target/parabank-klaros.xml");
        assertTrue(true);
    }

    @Test
    void testShoppingCartMigration() throws ParsingException, IOException, JAXBException {

        TestRailTestMigration.migrateTestCases("src/test/resources/shopping_cart-testrail.xml",
            "target/shopping_cart-klaros.xml");
        assertTrue(true);
    }

    @Test
    void testSwagLabsMigration() throws ParsingException, IOException, JAXBException {

        TestRailTestMigration.migrateTestCases("src/test/resources/swag_labs-testrail.xml",
            "target/swag_labs-klaros.xml");
        assertTrue(true);
    }

    @Test
    void testMasterMigration() throws ParsingException, IOException, JAXBException {

        TestRailTestMigration.migrateTestCases("src/test/resources/master-testrail.xml",
            "target/master-klaros.xml");
        assertTrue(true);
    }

}
