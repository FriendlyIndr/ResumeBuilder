# Stage 1: Build the application using Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

# Stage 2: Create a lightweight runtime image
# Use OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

<<<<<<< HEAD
# Copy the built JAR file from the builder stage
COPY --from-builder /app/target/*.jar app.jar
=======
# Copy and build the app using Maven
COPY . .  

# Make sure the Maven wrapper is executable
RUN chmod +x mvnw
RUN ./mvnw package -DskipTests
>>>>>>> b52f16bacc8def031a51913d76138a41854093f9

# Run the app
CMD ["java", "-jar", "app.jar"]
