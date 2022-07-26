FROM openjdk:11
COPY phonenumber-service-0.0.1.jar /phonenumber-service-0.0.1.jar
ENTRYPOINT ["java", "-jar", "phonenumber-service-0.0.1.jar"]