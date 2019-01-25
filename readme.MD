## Pre Requisits

- Java 8+
- Maven

## Build project with docker

Build image:
```
$ ./mvnw clean package dockerfile:build
```

Run container:
```
$ docker run -d --name bravi-api -p 8001:8080 ledson/bravi-app
```

Running:
```
http://localhost:8001/
```

## Balance Brackets function

Unit tests run on project build.

- Class implementation `src/main/java/com.ledsonsilva/util/BalanceBracketsUtil.java`
- Created unit tests in `test/java/util/BalanceBracketsUtilTest.java` to simulate the scenarios of valid and invalid expressions.

## Resource components
Major resource components supported by the Bravi API are:

- Persons

| Http      | Resource                 | Return                            |
|:----------|:-------------------------|:----------------------------------|
| GET       | `/persons`               | HTTP 200 - Return a list of all persons
| POST      | `/persons`               | HTTP 201 - Return id
| GET       | `/persons/{id}`          | HTTP 200 - Return Person
| PUT       | `/persons/{id}`          | HTTP 200 - Return Person
| DELETE    | `/persons/{id}`          | HTTP 200 - Void
| GET       | `/persons/{id}/contacts` | HTTP 200 - Return a list of all contacts by person

List persons parameters:

`?name=example` Filter by name  
`?page=0` Current page for pagination  
`?size=10` Max records  
`?sort={id, desc}` Order by  

Created person payload:
```json
{
    "name": "Example"
}
```

- Contacts

| Http      | Resource                  | Return                            |
|:----------|:--------------------------|:----------------------------------|
| GET       | `/contacts`               | HTTP 200 - Return a list of all contacts
| POST      | `/contacts`               | HTTP 201 - Return id
| GET       | `/contacts/{id}`          | HTTP 200 - Return Contact
| PUT       | `/contacts/{id}`          | HTTP 200 - Return Contact
| DELETE    | `/contacts/{id}`          | HTTP 200 - Void

List contacts parameters:

`?contact=example` Filter by contact  
`?typeContact=PHONE` Filter by type  
`?page=0` Current page for pagination  
`?size=10` Max records  
`?sort={id, desc}` Order by  

Created contact payload:

- types accepted: "PHONE", "WHATS", "EMAIL"

```json
{
    "name": "61991740585",
    "typeContact": "PHONE",
    "personId": 1
}
```

### Contact

Email: ledson.dev@gmail.com  
Phone: 61 991740585
