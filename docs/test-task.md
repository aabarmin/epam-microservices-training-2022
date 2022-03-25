# Coding challenge for the microservices class

## Narrative

"Angul-AR" is a leading service which provides booking capabilities for cinemas. "Angul-AR" is developing their own system which allows to perform the following functions: 

* Managing cinemas which are using the the "Angul-AR" system. 
* Managing movies which are available for visitors right now. 
* The booking system. 

Currently, engineers from "Angul-AR" are adopting a new, microservice-based approach and require your assistance to implement the system. Engineers would like you to help with establishing best development practices, sharing knowledge about cutting edge approaches, and help with coding of the application. 

There are no limitations in programming languages or tools to be used, the main goal is to have scalable and reliable system. 

## Acceptance criteria

* The application is deployed into the cloud, please consider using EPAM Cloud. 
* The application be deployed as a set of containers or serverless functions, implementation as a monolith is not acceptable. 
* The application should have an API endpoint (REST or GraphQL), no other services should be exposed.
* Distributed tracing should be applied to all the requests in the application. 
* Every service should expose metrics and report regarding its health. 
* The application should be protected with OAuth 2.0 or OpenID Connect. 
* There should be CI/CD pipeline for every service. 
* Users should be able to get aggregated data from multiple services using CQRS. 
* Hexagonal architecture should be used for services. 
* Service discovery should be established, it's preferable using platform-provided service discovery. 