# Stock Exchange Application Documentation (Version 1.0.0)

## About The Application

Stock Exchange Application is a simple stock exchange management application. 

There are many stock exchanges and many stocks in the world. Each stock exchange can have many stocks. Stock exchange having less than 5 stocks can not be
live in the market. The particular stock can be listed in
many stock exchanges and all the properties of a stock will remain same in all the exchanges

Application includes following operations

* Authenticating the user
* Fetching a stock with given name
* Creating new stock
* Deleting a stock
* Updating price of stock
* Fetching a stock exchange with given name
* Creating new stock exchange
* Adding a stock to stock exchange
* Removing a stock from stock exchange

## Getting started

The application is written in Java 17 with spring boot framework and has 3 api controllers
with 9 restful endpoints. All operations are done through these endpoints. The application works on port 8080.

PostgreSQL is used as db and operates on port 5432.

Swagger is used in this application and Swagger UI can be reached through 'http://localhost:8080/swagger-ui/index.html' after the application has started.

Endpoints are secured with java web token. So that access token must be received through /authenticate endpoint with the following credentials
* username : ing
* password : password

### How To Start The Application

All tables will be created and initial values will be inserted when the application starts. You can find initialized data sql files at resources.

The application is containerized and can be executed via docker-compose. Docker must be installed beforehand. The following two commands are enough to start the application.

```
maven clean package
docker-compose up --build
```

#### Containers
There are two containers:

* stock-exchange-app (port 8080)
* postgresql (port 5432)

## Used Technologies

* Java 17
* Spring Boot (3.3.2)
* PostgreSQL
* Maven 3.9.8
* Docker
