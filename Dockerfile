FROM openjdk:21

ADD ./build/libs/user-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/user-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080