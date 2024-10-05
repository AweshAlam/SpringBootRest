# Stage 1: Build the application
FROM maven:3.8.3-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and any additional files required for the build
COPY pom.xml .

# Download dependencies (improve build speed by caching layers)
RUN mvn dependency:go-offline

# Copy the rest of the application code
COPY src ./src

# Build the application (ensure the profile 'prod' exists or remove the -Pprod flag if unnecessary)
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/your-app-name.jar app.jar

# Expose the port that your app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
