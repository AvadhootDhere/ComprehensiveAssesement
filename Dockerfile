FROM openjdk:8
COPY target/*.jar /
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "/assesement-comprehensive.jar"]
