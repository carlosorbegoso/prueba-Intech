
FROM openjdk:21
LABEL authors="Carlos Orbegoso Loayza"
EXPOSE 8080
ARG JAR_FILE=build/libs/*.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
