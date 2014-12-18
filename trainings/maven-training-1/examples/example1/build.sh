#!/bin/bash

#####################
###	Build constants	#
#####################

#DEPLOY_DIR="../../apache-tomcat-7.0.56/webapps/maven1"
DEPLOY_DIR=/home/tibusz/dev/apache-tomcat/tomcat-7.0.56/webapps/maven1

JAR_NAME="maven1.jar"

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

	echo -e "[compile]\n"

	find -name "*.java" > sources.txt

	javac -cp "web/WEB-INF/lib/*:web/WEB-INF/lib-dev/*" -d build @sources.txt

	rm sources.txt

	###
	### 3rd part: package as JAR
	###

	echo -e "[package <jar>]\n"

	cp src/beans.xml build
	cp src/example.properties build

	cd build

	jar cvf $JAR_NAME *

	cd ..

############
### Deploy #
############

	rm -rf $DEPLOY_DIR

	mkdir $DEPLOY_DIR
	mkdir -p $DEPLOY_DIR/WEB-INF/classes
	mkdir -p $DEPLOY_DIR/WEB-INF/lib

	echo -e "\n[deploy] to $DEPLOY_DIR\n"

	cp build/$JAR_NAME $DEPLOY_DIR/WEB-INF/lib
	cp -r web/WEB-INF/lib/* $DEPLOY_DIR/WEB-INF/lib
	cp -r web/content $DEPLOY_DIR/
	cp web/WEB-INF/web.xml $DEPLOY_DIR/WEB-INF