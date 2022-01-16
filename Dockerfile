FROM openjdk:8
COPY ./target/assesement-comprehensive.jar /
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "assesement-comprehensive.jar"]
