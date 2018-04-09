FROM java:8-jdk

RUN mkdir ~/app
WORKDIR ~/app

COPY . ~/app

WORKDIR ~/app
RUN ./gradlew assemble

ENTRYPOINT ["java", "-jar", "./build/libs/bittrex-market-aggregator-1.0.jar"]

