FROM openjdk:8-slim

ADD target/dockerized-0.0.1-SNAPSHOT.jar app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app/app.jar"]