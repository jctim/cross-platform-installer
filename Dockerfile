FROM maven:3.6.3-openjdk-14-slim

RUN apt-get -y update
RUN apt-get -y install fakeroot
RUN apt-get -y install binutils
RUN apt-get -y install rpm

COPY . /app
WORKDIR /app
RUN mvn clean package
