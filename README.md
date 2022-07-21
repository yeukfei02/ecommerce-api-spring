# ecommerce-api-spring

ecommerce-api-spring

documentation: <https://documenter.getpostman.com/view/3827865/UzR1JhYe>

api url: <https://ecommerce-api-spring-v1.herokuapp.com/>

## Requirement

- install java (v11+)

## Testing and run

```zsh
// build jar
$ ./gradlew build

// run jar
$ java -jar build/libs/ecommerce-api-spring-1.0.0.jar

// start project
- run EcommerceApiSpringApplication.kt

// db migrate info
$ ./gradlew flywayInfo

// db migrate
$ ./gradlew flywayMigrate

// run test case
$ ./gradlew test
```

open project in intellij idea

open localhost:8080

## Docker

```zsh
// build images and start container in one line
docker-compose up -d --build

// go inside container
docker exec -it <containerId> /bin/bash

// check container logs
docker logs <containerId>

// remove and stop container
docker-compose down
```

open localhost:8080