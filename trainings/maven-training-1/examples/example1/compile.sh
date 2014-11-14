#!/bin/bash

rm -rf WEB-INF/classes/

mkdir WEB-INF/classes

javac -cp "WEB-INF/lib/*" -d WEB-INF/classes WEB-INF/src/com/liferay/trainings/internal/maven/servlet/TestServlet.java
