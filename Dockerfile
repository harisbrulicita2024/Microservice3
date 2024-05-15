FROM openjdk:21-rc-jdk-slim

WORKDIR /app

COPY target/microservice3-1.0-SNAPSHOT.jar /app/app.jar

EXPOSE 9850

CMD ["java", "-jar", "/app/app.jar"]