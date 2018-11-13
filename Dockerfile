FROM java:8-alpine

COPY target/uberjar/tinn.jar /tinn/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/tinn/app.jar"]
