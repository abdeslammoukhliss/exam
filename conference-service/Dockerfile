# Base image with Maven and JDK 21
FROM maven:3.9.5-eclipse-temurin-21 AS build

# Set working directory
WORKDIR /app

# Copy Maven files
COPY pom.xml ./
COPY src ./src

# Build the project
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:21-jdk-jammy

# Copy the built JAR from the build stage
COPY --from=build /app/target/conference-service-*.jar app.jar

# Expose port 8888
EXPOSE 8082

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
