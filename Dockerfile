FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8081
ARG JAR_FILE=/Users/shubham/.m2/repository/org/test/my-test-app/0.0.1-SNAPSHOT/my-test-app-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]