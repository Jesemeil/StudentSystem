FROM openjdk:21-jdk-slim as builder

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]