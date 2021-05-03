# crypto-coin - spring boot

This spring boot application demonstrates the information of all the financial assets like Bitcoin, Ether, Tether,... also
fiats like USD, Euro, ...

## Prerequisites

### JDK 8
Install JDK 8 from  [Oracle](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html "Download JDK")

### Maven
Install Maven from [Maven](https://maven.apache.org/install.html "Download Maven")

### Docker (optional)
Install Maven from [Docker](https://docs.docker.com/get-docker/ "Download Docker")

### Coin API key
For run the application you need to go to [coin-api](https://www.coinapi.io/pricing?apikey "Coin API")
and generate the API key and set it as environment variable.

## Installation and running
### Without Docker
run blow commands in order:

```git clone https://github.com/mehran-mehrafarin/crypto-coin.git```

```cd crypto-coin```

```mvn spring-boot:run -Drun.arguments=--coin.api.api.key={YOUR_API_KEY}```

### With Docker
run blow commands in order:

```git clone https://github.com/mehran-mehrafarin/crypto-coin.git```

```cd crypto-coin```

```mvn clean package -DskipTests```

```docker build -t crypto-coin:v-01 .``` (dot at the end of the command is important)

```docker run -d --network=host -e COIN_API_API_KEY='{YOUR_API_KEY}' --name=crypto-coin crypto-coin:v-01```

## Get started

Now you can see ```Hello World!``` message through this url: [localhost:8080/api/v1/hello-world](localhost:8080/api/v1/hello-world "crypto-coin application"):

after running the application, it gets the assets data from CoinAPI and insert it to the database. every five minutes, the application updates the data but if you want to update the data manually, you should call the following API:

[http://localhost:8080/api/v1/assets/update](http://localhost:8080/api/v1/assets/update "crypto-coin application")

for illustration of all data, call:

[http://localhost:8080/api/v1/assets](http://localhost:8080/api/v1/assets "crypto-coin application")


for getting the paginated data, call:

[http://localhost:8080/api/v1/assets/pagination?page=0&size=10](http://localhost:8080/api/v1/assets/pagination?page=0&size=10 "crypto-coin application")


for search in the paginated data, call:

[http://localhost:8080/api/v1/assets/{assetId}](http://localhost:8080/api/v1/assets/{assetId} "crypto-coin application")


Please report issues and bugs in the GitHub issue tracker.

## Settings

Set the following environment variables in order to change the application settings:

Field name | Default value | Description | 
--- | --- | --- | 
SERVER_PORT | 8080 | Application port |
COIN_API_API_KEY | Null | Coin API key|
COIN_API_ENDPOINT_URL | https://rest.coinapi.io | Coin API endpoint URL|

## Changelog

03.05.2021 initial release 1.0
