#!/usr/bin/env sh
git clone https://github.com/Ivpion/bittrex-markets-aggregator-tz.git
cd bittrex-markets-aggregator-tz
docker-compose up --no-deps -d db
./gradlew assemble
java -jar build/libs/bittrex-market-aggregator-1.0.jar
