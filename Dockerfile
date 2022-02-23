FROM pisarenko/jre11-slim
#FROM adoptopenjdk/openjdk11:jre-11.0.13_8-alpine
#FROM openjdk:8-jdk-alpine

ENV CUSTOM_IS-TEST true

EXPOSE 8080

WORKDIR appDir

ADD target/_7-2_REST-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]