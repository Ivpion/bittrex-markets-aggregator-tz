FROM java:8-jdk

RUN mkdir /app2
WORKDIR /app2

COPY . /app2

RUN ./gradlew assemble

ENTRYPOINT ["java", "-jar", "/app2/build/libs/bittrex-market-aggregator-1.0.jar"]
