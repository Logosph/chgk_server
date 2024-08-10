# Use the official OpenJDK 21 image as the base image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file into the container
COPY build/libs/chgk_server-0.0.1-SNAPSHOT.jar app.jar

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]