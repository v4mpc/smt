#!/bin/bash


UI_HOME_FOLDER="/Users/v4mpc/repo/smt-ui"
UI_DIST_FOLDER="${UI_HOME_FOLDER}/dist"
BACKEND_STATIC_FOLDER="/Users/v4mpc/repo/smt/src/main/resources/static"
BACKEND_TEMPLATES_FOLDER="/Users/v4mpc/repo/smt/src/main/resources/templates"

echo "Building UI project"
cd ${UI_HOME_FOLDER} && yarn build

echo "Copy build artifacts to Spring Boot"
cp -r "${UI_DIST_FOLDER}/assets" ${BACKEND_STATIC_FOLDER}

cp "${UI_DIST_FOLDER}/index.html" ${BACKEND_TEMPLATES_FOLDER}
echo "Building and Deploying to http://localhost:8080"

cd /Users/v4mpc/repo/smt && ./mvnw clean package && java -jar /Users/v4mpc/repo/smt/target/smt-0.0.1-SNAPSHOT.jar





