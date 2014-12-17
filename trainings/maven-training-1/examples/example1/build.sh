#!/bin/bash

JAR_NAME="maven1.jar"

#TOMCAT_DEPLOY_DIR="../../apache-tomcat-7.0.56/webapps/maven1"
TOMCAT_DEPLOY_DIR=/home/tibusz/dev/apache-tomcat/tomcat-7.0.56/webapps/maven1

#############
### Compile #
#############

	##
	## Delete & re-create build folder
	##

	rm -rf build
	mkdir build

	###
	### 1st part
	###
	#javac -cp "web/WEB-INF/lib-dev/*," -d build web/WEB-INF/src/com/liferay/trainings/internal/maven/servlet/TestServlet.java

	###
	### 2nd part: added more source files + properties file
	###

	find -name "*.java" > sources.txt

	javac -cp "web/WEB-INF/lib/*:web/WEB-INF/lib-dev/*" -d build @sources.txt

	rm sources.txt

	###
	### 3rd part: package as JAR
	###

	cp src/beans.xml build
	cp src/example.properties build

	cd build

	jar cvf $JAR_NAME *

	cd ..

############
### Deploy #
############

	rm -rf $TOMCAT_DEPLOY_DIR

	mkdir $TOMCAT_DEPLOY_DIR
	mkdir -p $TOMCAT_DEPLOY_DIR/WEB-INF/classes
	mkdir -p $TOMCAT_DEPLOY_DIR/WEB-INF/lib

	cp build/$JAR_NAME $TOMCAT_DEPLOY_DIR/WEB-INF/lib
	cp -r web/WEB-INF/lib/* $TOMCAT_DEPLOY_DIR/WEB-INF/lib
	cp -r web/content $TOMCAT_DEPLOY_DIR/
	cp web/WEB-INF/web.xml $TOMCAT_DEPLOY_DIR/WEB-INF