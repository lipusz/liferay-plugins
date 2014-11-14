#!/bin/bash

export TOMCAT_HOME=../../apache-tomcat-7.0.56

rm --recursive $TOMCAT_HOME/webapps/example1

mkdir $TOMCAT_HOME/webapps/example1

rsync -rvz --exclude-from='exclude.txt' . $TOMCAT_HOME/webapps/example1