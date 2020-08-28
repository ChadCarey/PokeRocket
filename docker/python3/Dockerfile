FROM ubuntu:20.04

RUN apt-get update

RUN apt-get install iputils-ping -y

RUN apt-get install python3 -y \
    && apt-get install python3-pip -y \
    && apt-get install dos2unix -y

ENV LC_ALL=C.UTF-8 LANG=C.UTF-8

EXPOSE 5000
