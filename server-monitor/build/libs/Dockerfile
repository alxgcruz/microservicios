FROM openjdk:8u151-jre-slim
MAINTAINER alejandrocruz.x819@gmail.com
COPY server-monitor.jar /opt/server-monitor.jar
EXPOSE 8090
ENTRYPOINT ["java", "-Djava.awt.headless=true", "-jar", "/opt/server-monitor.jar"]
