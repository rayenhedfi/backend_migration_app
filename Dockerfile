FROM openjdk:8-jdk-alpine
RUN apk --no-cache add wget
RUN wget --user=admin --password=root -O Pfe_App.jar "http://192.168.72.140:8081/repository/maven-releases/tn/actia/pfe/Pfe_App/1.0/Pfe_App-1.0.jar"
ENTRYPOINT ["java","-jar","/Pfe_App.jar"]
EXPOSE 8089
