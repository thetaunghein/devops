FROM amazoncorretto:25
COPY ./target/semCW-0.1.0.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "semCW-0.1.0.1-jar-with-dependencies.jar"]