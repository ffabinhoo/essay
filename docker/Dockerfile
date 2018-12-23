FROM openjdk:8-jdk
MAINTAINER Fabio Costa ffabinhoo@gmail.com

ADD essay-1.0.jar essay-1.0.jar
RUN sh -c 'touch /essay-1.0.jar'
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://essay-mongo/essay","-Djava.security.egd=file:/dev/./urandom","-jar","/essay-1.0.jar"]