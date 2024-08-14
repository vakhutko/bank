FROM gradle:jdk21-alpine AS build
WORKDIR /workspace
COPY . .
RUN gradle bootJar --no-daemon

FROM openjdk:21
WORKDIR /app
COPY --from=build /workspace/build/libs/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]