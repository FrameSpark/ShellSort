FROM openjdk:8-alpine
ADD target/editor-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
EXPOSE 5005
ENTRYPOINT ["java", "-Dfile.encoding=UTF-8", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005", "-jar", "/app/app.jar"]
