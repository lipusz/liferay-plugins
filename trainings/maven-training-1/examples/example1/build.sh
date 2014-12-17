#!/bin/bash

JAR_NAME="maven1.jar"

#TOMCAT_DEPLOY_DIR="../../apache-tomcat-7.0.56/webapps/maven1"
TOMCAT_DEPLOY_DIR=/home/tibusz/dev/apache-tomcat/tomcat-7.0.56/webapps/maven1


#############
### Compile #
#############

	##
	## Delete & re-create output folder
	##

	rm -rf build
	mkdir build

	###
	### 1st part
	###
	#javac -cp "web/WEB-INF/lib/*" -d build web/WEB-INF/src/com/liferay/trainings/internal/maven/servlet/TestServlet.java


	###
	### 2nd part: added more source files + properties file
	###

	find -name "*.java" > sources.txt

	javac -cp "web/WEB-INF/lib/*" -d build @sources.txt

	rm sources.txt

	###
	### 3rd part: package as JAR
	###

	cd build

	jar cvf $JAR_NAME *

	cd ..

############
### Deploy #
############

	rm -rf $TOMCAT_DEPLOY_DIR
	mkdir $TOMCAT_DEPLOY_DIR

	###
	### 1st part: copy the necessary files
	###

	#rsync -rvz --exclude-from='exclude.txt' . $TOMCAT_DEPLOY_DIR

	###
	###
	###

	mkdir -p $TOMCAT_DEPLOY_DIR/WEB-INF/classes
	mkdir -p $TOMCAT_DEPLOY_DIR/WEB-INF/lib

	cp build/$JAR_NAME $TOMCAT_DEPLOY_DIR/WEB-INF/lib
	cp -r web/content $TOMCAT_DEPLOY_DIR/
	cp src/example.properties $TOMCAT_DEPLOY_DIR/WEB-INF/classes
	cp web/WEB-INF/web.xml $TOMCAT_DEPLOY_DIR/WEB-INF