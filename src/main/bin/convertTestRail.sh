#!/bin/sh
#
# USER DEFINED VARIABLES
#

# The Java home directory
JAVA_HOME="C:\Program Files\Eclipse Adoptium\jdk-11.0.13.8-hotspot"

# The Migration command
MIGRATE_CMD="$JAVA_HOME/bin/java -Xmx512m -jar testrail-migration-1.0.0.jar"

# The URL of the Klaros server 
KLAROS_BASE_URL="https://www.klaros-testmanagement.com/teaser/"

# The user account importing the test cases, must have the manger role in the project we want to import to
USERNAME="admin"
# The password of above user
PASSWORD="Ci7mJBzW="

# The filesystem path containing the exported TestRail test cases XML file
SRC_FOLDER="src/test/resources"

# The filesystem path to write the converted test cases file to
TARGET_FOLDER="target"

# The Klaros project ID to upload the test cases to
PROJECT="P00050"

# Migrate and import test cases.
#
echo "Converting TestRail test case data to klaros format"

${MIGRATE_CMD} -t $SRC_FOLDER/parabank-testrail.xml -T $TARGET_FOLDER/parabank-klaros.xml

echo "Uploading test case data to Klaros"
curl -T $TARGET_FOLDER/parabank-klaros.xml "$KLAROS_BASE_URL/seam/resource/rest/import/testcase/xml?config=$PROJECT&username=$USERNAME&password=$PASSWORD"

echo "Finished successfully"
