FROM openjdk:21
WORKDIR /app
EXPOSE 8484
ADD target/springrabbitmq-docker.jar springrabbitmq-docker.jar
ENTRYPOINT ["java", "-jar", "/app/springrabbitmq-docker.jar"]