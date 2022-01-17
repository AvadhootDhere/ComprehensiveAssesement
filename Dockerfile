FROM openjdk:8
COPY target/compassesement.jar compassesement.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "/assesement-comprehensive.jar"]
