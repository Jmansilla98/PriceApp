# PriceApp

[![CI Pipeline](https://github.com/Jmansilla98/PriceApp/actions/workflows/ci.yml/badge.svg)](https://github.com/Jmansilla98/PriceApp/actions/workflows/ci.yml)
[![codecov](https://codecov.io/gh/Jmansilla98/PriceApp/branch/main/graph/badge.svg)](https://codecov.io/gh/Jmansilla98/PriceApp)

This is a Spring Boot application for managing product prices.

## Features
- CI pipeline with Maven build and test
- Dependency security analysis with OWASP Dependency-Check

## Getting Started

To run the application locally:

```bash
./mvnw spring-boot:run
```

to run test

```bash
./mvnw test
```

## Postman Collection
To test the API endpoints using Postman, follow these steps:

Download the Postman collection.
Open Postman.
Click on the "Import" button in the top left corner.
Select "Upload Files" and choose the downloaded JSON file.
Click "Import" to add the collection to Postman.
## API Endpoints
Here are the endpoints included in the Postman collection:

### Get Price at 10:00 on 14th

URL: http://localhost:8080/price?productId=35455&brandId=1&applicationDate=2020-06-14T10:00:00
### Get Price at 16:00 on 14th

URL: http://localhost:8080/price?productId=35455&brandId=1&applicationDate=2020-06-14T16:00:00
### Get Price at 21:00 on 14th

URL: http://localhost:8080/price?productId=35455&brandId=1&applicationDate=2020-06-14T21:00:00
### Get Price at 10:00 on 15th

URL: http://localhost:8080/price?productId=35455&brandId=1&applicationDate=2020-06-15T10:00:00
### Get Price at 21:00 on 16th

URL: http://localhost:8080/price?productId=35455&brandId=1&applicationDate=2020-06-16T21:00:00