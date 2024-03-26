FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/Api-Gateway-0.0.1-SNAPSHOT.jar Api-Gateway.jar
ENTRYPOINT ["java","-jar","/Api-Gateway.jar"]