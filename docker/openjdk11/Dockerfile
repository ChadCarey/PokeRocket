FROM ubuntu:20.04

RUN apt-get update

RUN apt-get -y install openjdk-11-jre openjdk-11-jdk maven

ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64/

RUN apt-get install iputils-ping -y
RUN apt-get install curl -y

EXPOSE 8080
