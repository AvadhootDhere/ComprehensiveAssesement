FROM adoptopenjdk/openjdk11:jre-11.0.10_9-alpine
COPY ./target/assesement-comprehensive.jar /
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "assesement-comprehensive.jar"]
