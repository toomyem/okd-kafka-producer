FROM openjdk:8u171-alpine3.7 as builder
RUN mkdir /app
WORKDIR /app
RUN apk --no-cache --update add curl maven
COPY src src
COPY pom.xml .
RUN mvn package

FROM openjdk:8u171-alpine3.7
COPY --from=builder /app/target/kafka-producer-0.1.jar /kafka-producer.jar
CMD java ${JAVA_OPTS} -jar /kafka-producer.jar
