# Questions for the microservices class

## Introduction

1. What from the following are benefits of writing monolithic apps (select 3):

- [x] Simple and comfortable development
- [x] Single code base
- [x] Simple testing and deployment
- [ ] Rich user interface
- [ ] Built on top of technologies and frameworks which are hard to change

2. What of the following is functional decomposition? 

- [x] Split of the code based on its functions
- [ ] Split of data and adding multiple instances of the app for every shard
- [ ] Running multiple instances of the application and putting them behind the load balancer

3. What of the following is relevant to the service-oriented architecture (select 3):

- [x] Usage of the enterprise service bus (ESB) or SOAP
- [x] Global or shared database
- [x] Applications are small but strongly coupled
- [ ] Every service has its own database
- [ ] Applications are small and independent

## Decomposition strategies

1. What views are included into 4+1 model (select 5):

- [x] Logical view
- [x] Implementation view
- [x] Deployment view
- [x] Process view
- [x] Scenarios
- [ ] Sequence view
- [ ] Activity view
- [ ] State view

2. What of the following are quality attributes (select 3):

- [x] Performance
- [x] Security
- [x] Observability
- [ ] Functions that an application should perform
- [ ] Color of buttons of the user interface

3. What of the following are characteristics of the hexagonal architecture (select 3):

- [x] Logical view is organized in a way that places the business logic at the centre
- [x] Inbound adapters are handling requests from the outside by invoking business logic
- [x] A port defines a set of operations and how business logic interacts with external services
- [ ] Presentation layer contains code that implements the user interface or external API
- [ ] Persistance layer contains the logic of interacting with a database


4. ... is a standalone, independently deployable software component that implements some functionality

- [x] Service
- [ ] Application
- [ ] Provider
- [ ] API
- [ ] OSGi bundle

5. What is a system operation? 

- [x] An abstraction of a request that the service must handle
- [ ] Way of collaboration between services
- [ ] Operations with underlying file system or database
- [ ] Operations that involve multiple services

6. What of the following system operations are commands (select 3):

- [x] Operations that create data
- [x] Operations that update data
- [x] Operations that delete data
- [ ] Operations that query data
- [ ] Events

7. What are goals of domain-driven design (select 3):

- [x] Placing the project's primary focus on the core domain and domain logic
- [x] Basing complex designs on a model of the domain
- [x] Initiating a creative collaboration between technical and domain experts to iterative refine a conceptual model that addresses particular domain problems
- [ ] Using inbound and outbound ports and adapters to separate business logic from UI and storage
- [ ] Separation of modules based on business capabilities

8. What principle is described below: 

```
The classes in a package should be closed together against the same kinds of changes. A change that affects a package affects all the classes in the package. 
```

- [x] Common Closure Principle
- [ ] Single Responsibility Principle
- [ ] Common Reuse Principle
- [ ] The Acyclic Dependencies Principle
- [ ] Dependency Inversion Principle

9. What of the following are obstacles to decomposing applications into services (select 3):

- [x] Network latency
- [x] Reduced availability 
- [x] Maintaining data consistency across services
- [ ] Small size of resulting applications
- [ ] Increasing code complexity due to using frameworks

## Interprocess communication

