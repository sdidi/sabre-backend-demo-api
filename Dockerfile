FROM openjdk:11
EXPOSE 8080
ADD ./target/sabre-converter-demo-api.jar sabre-converter-demo-api.jar
ENTRYPOINT ["java","-jar","sabre-converter-demo-api.jar"]