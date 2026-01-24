# Stage 1: Build Stage
FROM amazoncorretto:25-al2023 AS build

# Install Maven manually since a combined image isn't available yet
RUN yum install -y maven

WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code and build
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime Stage
FROM amazoncorretto:25-alpine-jdk
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Memory-optimized settings for Render
ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]