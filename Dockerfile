FROM openjdk:8
COPY target/compassesement.jar compassesement.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "/compassesement.jar"]
CMD [ "docker" "push" "avadhootdhere/compassesement"]
