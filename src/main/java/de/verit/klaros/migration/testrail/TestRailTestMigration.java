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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.verit.klaros.migration.testrail.container.testcase.TestCaseParser;
import jakarta.xml.bind.JAXBException;
import nu.xom.ParsingException;

public class TestRailTestMigration {

    private static final String FILENAME = "filename";

    private static final String OPTION_TEST_CASES = "test-cases";
    private static final String OPTION_TEST_CASES_OUTPUT = "test-cases-output";
    private static final String OPTION_HELP = "help";

    private static final Logger LOG = LoggerFactory.getLogger(TestRailTestMigration.class);

    private static final Option TEST_CASES = Option.builder("t").longOpt(OPTION_TEST_CASES).required(true)
        .hasArg(true).argName(FILENAME).desc("the TestRail test cases xml export file to read").build();

    private static final Option TEST_CASES_OUTPUT = Option.builder("T").longOpt(OPTION_TEST_CASES_OUTPUT)
        .required(true).hasArg(true).argName(FILENAME).desc("the Klaros test cases xml export file to write")
        .build();

    private static final Option HELP = Option.builder("h").longOpt(OPTION_HELP).required(false).hasArg(false)
        .desc("show help information").build();

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {

        LOG.info("TestRail To Klaros Migration Tool");

        String testCasesFileName = "";
        String testCasesOutputFileName = "";

        final Options options = buildOptions();

        CommandLineParser parser = new DefaultParser();

        try {

            if (checkForHelp(args)) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp(OPTION_HELP, options);
                return;
            }

            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption(OPTION_TEST_CASES)) {
                testCasesFileName = cmd.getOptionValue(OPTION_TEST_CASES);
                LOG.info("Test Cases File: {}", testCasesFileName);
            }

            if (cmd.hasOption(OPTION_TEST_CASES_OUTPUT)) {
                testCasesOutputFileName = cmd.getOptionValue(OPTION_TEST_CASES_OUTPUT);
                LOG.info("Test Cases Output File: {}", testCasesOutputFileName);
            }

            migrateTestCases(testCasesFileName, testCasesOutputFileName);

        } catch (ParseException e) {
            LOG.error("Error parsing command line: {}", e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp(OPTION_HELP, options);
            System.exit(1);
        } catch (FileNotFoundException e) {
            LOG.error("Could not find file: {}", e.getMessage(), e);
            System.exit(1);
        } catch (ParsingException e) {
            LOG.error("Parse Error: {}", e.getMessage(), e);
            System.exit(1);
        } catch (IOException | JAXBException e) {
            LOG.error("I/O Error: {}", e.getMessage(), e);
            System.exit(1);
        }
        LOG.info("Finished successfully");
        System.exit(0);
    }

    /**
     * Migrate the given testrail test case file to klaros format.
     *
     * @param project the project
     * @param testCasesFileName the test cases file name
     * @param testCasesOutputFileName the test cases output file name
     * @throws ParsingException The generic superclass for all thechecked exceptions thrown in XOM.
     * @throws IOException Signals that an I/O exception of some sort has occurred.
     * @throws JAXBException This is the root exception class for all Jakarta XML Binding exceptions.
     */
    public static void migrateTestCases(String testCasesFileName,
        String testCasesOutputFileName) throws ParsingException, IOException, JAXBException {

        final ProjectContext context = new ProjectContext();

        TestCaseParser.parse(context, new FileInputStream(testCasesFileName));
        LOG.info("Found {} test cases", context.getTestCaseContainer().getTestCases().size());

        if (!testCasesOutputFileName.isBlank()) {

            final byte[] content = context.exportTestCases().readAllBytes();
            Files.write(Paths.get(testCasesOutputFileName), content);

            if (LOG.isInfoEnabled()) {
                LOG.info("Written {} bytes of test case data to file {}", new DecimalFormat("#,###").format(
                    content.length), testCasesOutputFileName);
            }
        } else {
            LOG.warn("No valid output file name found");
        }
    }

    /**
     * Builds the command line options.
     *
     * @return the command line options
     */
    private static Options buildOptions() {

        final Options options = new Options();

        options.addOption(TEST_CASES);
        options.addOption(TEST_CASES_OUTPUT);
        options.addOption(HELP);
        return options;
    }

    /**
     * Check command line arguments for the help option.
     *
     * @param args the command line arguments
     * @return true, if help option is given
     * @throws ParseException Base for Exceptions thrown during parsing of a command-line.
     */
    private static boolean checkForHelp(String[] args) throws ParseException {

        boolean hasHelp = false;

        Options options = new Options();

        options.addOption(HELP);

        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption(HELP.getOpt())) {
                hasHelp = true;
            }
        } catch (ParseException e) {
            // Ignore this here
        }

        return hasHelp;
    }
}
