FROM ubuntu:20.04

RUN apt-get update

RUN apt-get install iputils-ping -y

RUN apt-get install python3 -y \
    && apt-get install python3-pip -y \
    && apt-get install dos2unix -y

ENV LC_ALL=C.UTF-8 LANG=C.UTF-8

RUN pip3 install nose2 && pip3 install timeout-decorator
RUN pip3 install requests
RUN pip3 install Flask

EXPOSE 5000
