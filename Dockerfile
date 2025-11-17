FROM eclipse-temurin:17-jre

ADD target/tracetest-0.0.1-SNAPSHOT.jar /app.jar
ADD target/agent/opentelemetry-javaagent.jar opentelemetry-javaagent.jar

ENTRYPOINT java -javaagent:opentelemetry-javaagent.jar -jar /app.jar