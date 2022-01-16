FROM openjdk:8
ADD target/assesement-comprehensive.jar assesement-comprehensive.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "assesement-comprehensive.jar"]