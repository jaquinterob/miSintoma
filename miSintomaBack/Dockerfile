FROM openjdk:11-jre-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} miSintomaBack-0.0.1-SNAPSHOT.jar.jar
ENTRYPOINT ["java","-jar","/miSintomaBack-0.0.1-SNAPSHOT.jar"]