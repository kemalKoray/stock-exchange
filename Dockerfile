# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the application's JAR file into the container
COPY target/stock-exchange-0.0.1-SNAPSHOT.jar /app/stock-exchange.jar

# Expose the port that your Spring Boot application will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/stock-exchange.jar"]
