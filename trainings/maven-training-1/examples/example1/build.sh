#!/bin/bash

#TOMCAT_DEPLOY_DIR="../../apache-tomcat-7.0.56"
TOMCAT_DEPLOY_DIR=/home/tibusz/dev/apache-tomcat-bundles/apache-tomcat-7.0.56/webapps/example1


#############
### Compile #
#############

	##
	## Delete & re-create output folder
	##

	OUTPUT="WEB-INF/classes"

	rm -rf $OUTPUT

	mkdir $OUTPUT

	###
	### 1st part
	###
	#-javac -cp "WEB-INF/lib/*" -d $OUTPUT WEB-INF/src/com/liferay/trainings/internal/maven/servlet/TestServlet.java


	###
	### 2nd part: added more source files + properties file
	###

	find -name "*.java" > sources.txt

	javac -cp "WEB-INF/lib/*" -d $OUTPUT @sources.txt

	rm sources.txt

	###
	### 3rd part: package as JAR
	###

	jarName="example.jar"

	cd WEB-INF/classes

	jar cvf $jarName *

	cd ../..

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

	cp $jarName $TOMCAT_DEPLOY_DIR/WEB-INF/lib
	cp -r jsp $TOMCAT_DEPLOY_DIR/
	cp WEB-INF/src/example.properties $TOMCAT_DEPLOY_DIR/WEB-INF/classes
	cp WEB-INF/web.xml $TOMCAT_DEPLOY_DIR/WEB-INF