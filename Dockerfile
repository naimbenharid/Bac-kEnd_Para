FROM openjdk:8
EXPOSE 8080
ADD target/Back-End-Para.jar Back-End-Para.jar

ENTRYPOINT ["java","-jar","/Back-End-Para.jar"]