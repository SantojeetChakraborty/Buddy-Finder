# Use Java 21 image
FROM openjdk:21-jdk-slim

# Set work directory
WORKDIR /app

# Copy target JAR
COPY target/bikeridersupport-0.0.1-SNAPSHOT.jar app.jar

# Expose app port
EXPOSE 8080

# Run Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
