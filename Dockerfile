FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:root -o Pfe_App.jar "http://192.168.72.139:8081/repository/maven-releases/tn/actia/pfe/Pfe_App/1.0/Pfe_App-1.0.jar" -L
ENTRYPOINT ["java","-jar","/Pfe_App.jar"]
EXPOSE 8089
