# Use OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy and build the app using Maven
COPY . .  

# Make sure the Maven wrapper is executable
RUN chmod +x mvnw
RUN ./mvnw package -DskipTests

# Run the app
CMD ["java", "-jar", "target/*.jar"]
