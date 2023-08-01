# Yeehaw! Welcome to the Ranch Hand Diary Application!

This is a standalone Java, Spring Boot, and Hibernate (postgresql) application using Maven as the build tool. It provides for a set of RESTful operations to save, update, and delete diary entries.

### Prerequisites

- Java 17 Runtime
- Maven
- Postgres external database

### Installation

1. Clone the repo
   ```
   git clone git@github.com:trenton-taylor/bnr-backend-code-challenge.git
   ```
4. Build and run the project from the command line
   ```
   mvn clean spring-boot:run
   ```




## Usage
There are a few different endpoints to interact with the application to achieve the desired functionality. These options consist of standard Http `@Get`, `@Put`, and `@Delete` operations on both diary entries and authors.

There is also some exception handling (during save/delete operations, invalid entry and author ids) as well as plenty of notifications on what is happening behind the scenes. Please check out the screenshots for more detail. All screenshots were created using Postman.

### Sample @GETs
*Retrieves all diary entries for all authors:*
```
curl --location 'localhost:8080/diary/entries'
```

*Retrieves a single diary entry (work in progress, currently throws an unhandled exception due to typo with using @PathParam instead of @PathVariable annotation):*
```
curl --location --request GET 'localhost:8080/diary/entry/355'
```

*Retrieves all entries by a single author:*
```
curl --location 'localhost:8080/diary/author/102'
```
```
[
    {
        "id": 355,
        "author": {
            "id": 102,
            "name": "trenton",
            "email": "trenton.a.taylor@gmail.com",
            "expertise": null
        },
        "title": "title 1",
        "body": "body 1"
    },
    {
        "id": 356,
        "author": {
            "id": 102,
            "name": "trenton",
            "email": "trenton.a.taylor@gmail.com",
            "expertise": null
        },
        "title": "title 2",
        "body": "body 2"
    }
]
```

### Sample @POSTs

---

*Create an author with a new sequential id (work in progress, bug in capturing expertise field)*
```
curl --location 'localhost:8080/diary/author' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "trenton",
    "email": "trenton.a.taylor@gmail.com",
    "expertise:":"java"
}'
```
*Result:*
```
{
    "id": 102,
    "name": "trenton",
    "email": "trenton.a.taylor@gmail.com",
    "expertise": null
}
```
---
*Create a new diary entry for an author:*
```
curl --location 'localhost:8080/diary/entry' \
--header 'Content-Type: application/json' \
--data '{
    "author" : {
        "id" : 102
    },
    "title": "title 1",
    "body": "body 1"
}'
```
*Result:*
```
{
    "id": 355,
    "author": {
        "id": 102,
        "name": "trenton",
        "email": "trenton.a.taylor@gmail.com",
        "expertise": null
    },
    "title": "title 1",
    "body": "body 1"
}
```
---

### Sample @Deletes
*With request body:*

Deletes a specific diary entry:
```
curl --location --request DELETE 'localhost:8080/diary/entries/355'
```
```
{
    "status": 200,
    "message": "Successfully deleted diary entry with id 355"
}
```
Deleting an invalid entry, with error message:
```
curl --location --request DELETE 'localhost:8080/diary/entries/999'
```
```
{
    "status": 400,
    "message": "Service Exception: Error deleting diary entry with id 999"
}
```

### Other Errors
*Invalid route:*
```
curl --location 'localhost:8080/diary'
```
```
{
    "status": 404,
    "message": "Service Exception: Route not found."
}
```
*Creating a diary entry for an invalid author:*
```
curl --location 'localhost:8080/diary/entry' \
--header 'Content-Type: application/json' \
--data '{
    "author" : {
        "id" : 999
    },
    "title": "title 2",
    "body": "body 2"
}'
```
```
{
    "status": 400,
    "message": "Service Exception: Error retrieving author by id 999"
}
```

*Method Not Allowed*
```
curl --location --request POST 'localhost:8080/diary/entries/355'
```
```
{
    "type": "about:blank",
    "title": "Method Not Allowed",
    "status": 405,
    "detail": "Method 'POST' is not supported.",
    "instance": "/diary/entries/355"
}
```
## Contact

Trenton Taylor - trenton.a.taylor@gmail.com

Project Link: [https://github.com/trenton-taylor/bnr-backend-code-challenge](https://github.com/trenton-taylor/bnr-backend-code-challenge)
