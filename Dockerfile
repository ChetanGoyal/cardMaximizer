# Step 1: Build stage using Maven and OpenJDK 25
# We use the official Maven image paired with OpenJDK 25
FROM maven:3.9.6-amazoncorretto-25 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and the entire project
COPY . .

# Build the application
# We skip tests to ensure a fast build on the Render Free Tier
RUN mvn clean package -DskipTests

# Step 2: Runtime stage
# Using the Eclipse Temurin JRE 25 image for a lightweight, secure production environment
FROM eclipse-temurin:25-jre-noble

# Set working directory for the runtime
WORKDIR /app

# Copy the built JAR from the build stage
# Since you have no backend folder, the JAR is in /app/target/
COPY --from=build /app/target/*.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Run the application with container-aware memory settings
ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]