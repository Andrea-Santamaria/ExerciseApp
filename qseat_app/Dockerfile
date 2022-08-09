#FROM maven:3.6-jdk-8-alpine as build
#WORKDIR /app
#COPY . ./
#RUN mvn -f pom.xml clean install
#FROM openjdk:8-jdk-alpine
#COPY --from=build /app/target/*.jar qseat_app-0.0.1.jar
#ENTRYPOINT ["java","-jar","/qseat_app-0.0.1.jar"]

FROM openjdk:8-jdk-alpine
ADD target/qseat_app.jar qseat_app.jar
#RUN ./mvnw clean package
#RUN mvn -f pom.xml clean package spring-boot:repackage
ENTRYPOINT [ "java","-jar","qseat_app.jar" ]


#FROM openjdk:8-jdk-alpine
#ADD qseatSpringBoot ./qseatSpringBoot
#WORKDIR qseatSpringBoot
#RUN ./mvnw clean package
#ENTRYPOINT ["java","-jar","target/qseat-0.0.1-SNAPSHOT.jar"]
