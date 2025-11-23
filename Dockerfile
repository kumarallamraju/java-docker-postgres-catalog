
# Build stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn -q -e -B -DskipTests package

# Runtime stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /build/target/catalog-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENV DB_HOST=db DB_PORT=5432 DB_NAME=catalogdb DB_USER=catalog DB_PASSWORD=catalogpass
ENTRYPOINT ["java","-jar","app.jar"]
