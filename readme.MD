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

`?name=example`: Filter by name  
`?page=0`: Current page for pagination  
`?size=10`: Max records  
`?sort={id, desc}`: Order by  

Created person payload:
```json
{
    "name": "Example"
}
```

- Contacts

| Http      | Resource                - | Return                            |
|:----------|:--------------------------|:----------------------------------|
| GET       | `/contacts`               | HTTP 200 - Return a list of all contacts
| POST      | `/contacts`               | HTTP 201 - Return id
| GET       | `/contacts/{id}`          | HTTP 200 - Return Contact
| PUT       | `/contacts/{id}`          | HTTP 200 - Return Contact
| DELETE    | `/contacts/{id}`          | HTTP 200 - Void

List contacts parameters:

`?contact=example`: Filter by contact  
`?typeContact=PHONE`: Filter by type  
`?page=0`: Current page for pagination  
`?size=10`: Max records  
`?sort={id, desc}`: Order by  

Created contact payload:

- types accepted: "PHONE", "WHATS", "EMAIL"

```json
{
    "name": "61991740585",
    "typeContact": "PHONE",
    "personId": 1
}