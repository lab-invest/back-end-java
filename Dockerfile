FROM maven:3.8.6-eclipse-temurin-21 as build
WORKDIR /app
COPY . .
RUN mvn clean package -X -DskipTests

FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build ./app/target/*.jar ./investlab.jar
ENTRYPOINT ["java", "-jar", "investlab.jar"]
