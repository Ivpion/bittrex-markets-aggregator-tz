## This is bittrex-markets-aggregator-tz project. 

Sincerely, 
Captain obvious

### Get info by market name

http://localhost:8080/get-market-info?name=BTC-2GIVE

return Market as JSON

### Get last changes by hour by name

http://localhost:8080/get-last-changes?name=BTC-2GIVE

return double 

### For install docker-compose:
 https://docs.docker.com/compose/install/#master-builds

### For start app use next command:
(Before start make sure, that docker-compose install on your machine)

Download project
```
git clone https://github.com/Ivpion/bittrex-markets-aggregator-tz.git
```
navigate to project dir

```
cd bittrex-markets-aggregator-tz
```
set up mysql with docker

```
docker-compose up --no-deps -d db
```
build project

```
./gradlew assemble
```
start project on JVM

```
java -jar build/libs/bittrex-market-aggregator-1.0.jar
```

Or use start-bittrex-app
