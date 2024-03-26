FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/comments-0.0.1-SNAPSHOT.jar comments.jar
ENTRYPOINT ["java","-jar","/comments.jar"]