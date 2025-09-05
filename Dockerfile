FROM amazoncorretto:21
LABEL maintainer="prado-hub"
WORKDIR /application
COPY target/desafio-nubank-backend-0.0.1-SNAPSHOT.jar /application/NubankBackendDocker.jar
ENTRYPOINT ["java","-jar","NubankBackendDocker.jar"]