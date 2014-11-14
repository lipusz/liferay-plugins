#!/bin/bash

#export TOMCAT_HOME=../../apache-tomcat-7.0.56
export TOMCAT_HOME=/home/tibusz/dev/apache-tomcat-bundles/apache-tomcat-7.0.56

rm -rf $TOMCAT_HOME/webapps/example1

mkdir $TOMCAT_HOME/webapps/example1

rsync -rvz --exclude-from='exclude.txt' . $TOMCAT_HOME/webapps/example1