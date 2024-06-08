#!/bin/bash

UI_HOME_FOLDER="/Users/v4mpc/repo/smt-ui"
UI_DIST_FOLDER="${UI_HOME_FOLDER}/dist"
BACKEND_STATIC_FOLDER="/Users/v4mpc/repo/smt/src/main/resources/static"
BACKEND_TEMPLATES_FOLDER="/Users/v4mpc/repo/smt/src/main/resources/templates"

echo "Building UI project"
cd ${UI_HOME_FOLDER} && yarn build

echo "Copy build artifacts to Spring Boot"
rm "${BACKEND_STATIC_FOLDER}"/assets/*.js
rm "${BACKEND_STATIC_FOLDER}"/assets/*.css
cp -r "${UI_DIST_FOLDER}/assets" ${BACKEND_STATIC_FOLDER}

rm "${BACKEND_TEMPLATES_FOLDER}/index.html"
cp "${UI_DIST_FOLDER}/index.html" ${BACKEND_TEMPLATES_FOLDER}



echo "Building and Deploying to Production"

#cd /Users/v4mpc/repo/smt && ./mvnw spring-boot:build-image

cd /Users/v4mpc/repo/smt/ &&  docker build -t smt:1.0.0 -f /Users/v4mpc/repo/smt/docker/Dockerfile .


docker save -o /Users/v4mpc/Downloads/smt.tar smt:1.0.0


scp /Users/v4mpc/Downloads/smt.tar rootjsi:/tmp

ssh rootjsi /usr/bin/docker load -i /tmp/smt.tar



#
#
##ssh rootjsi rm /root/repo/smt/smt-1.0.0.jar
#scp /Users/v4mpc/repo/smt/target/smt-1.0.0.jar rootjsi:/root/repo/smt
##ssh rootjsi /usr/bin/supervisorctl restart smt:smt_00