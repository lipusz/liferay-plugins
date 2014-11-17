#!/bin/bash

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

rm $jarName

jar cvf $OUTPUT/$jarName $OUTPUT -C $OUTPUT $OUTPUT