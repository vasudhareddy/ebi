FROM maven:3.6.0-jdk-8-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package


FROM openjdk:8-jdk-alpine
COPY --from=build /home/app/target/ebi-0.0.1.jar /usr/local/lib/ebi.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/ebi.jar"]