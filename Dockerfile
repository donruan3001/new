FROM openjdk:21-jdk-alpine

WORKDIR /src

COPY . .

EXPOSE 8080

ENTRYPOINT [ "java ","-jar","app.jar" ]