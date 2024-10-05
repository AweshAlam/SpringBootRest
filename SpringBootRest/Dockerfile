#
# Build stage
#
FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean install

#
# Package stage
#
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/SpringBootRest-0.0.1-SNAPSHOT.jar SpringBootRest-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","SpringBootRest-0.0.1-SNAPSHOT.jar"]
