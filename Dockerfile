FROM adoptopenjdk/openjdk11:alpine-jre
VOLUME /tmp
ARG JAR_FILE=target/airline-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} airline-service.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/airline-service.jar"]