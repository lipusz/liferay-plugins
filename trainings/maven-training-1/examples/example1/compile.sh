#!/bin/bash

rm --recursive WEB-INF/classes/

mkdir WEB-INF/classes

javac -classpath WEB-INF/lib/servlet-api.jar -d WEB-INF/classes WEB-INF/src/com/liferay/trainings/internal/maven/servlet/TestServlet.java
