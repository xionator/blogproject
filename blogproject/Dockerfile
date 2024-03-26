FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/blogproject-0.0.1-SNAPSHOT.jar blogproject.jar
ENTRYPOINT ["java","-jar","/blogproject.jar"]