Examples
=

This repository includes the following examples: 

* Monolithic layered application
* Monolithic hexagonal application
* The same app but implemented as a distributed app

All the apps are Spring Boot applications, so, go to the necessary folder and execute the Maven 
goal:

```shell
$ mvn spring-boot:run
```

All the dependencies will be downloaded, the app will be built and started. 

Monolithic Layered Application
=

Monolithic layered application is in the `monolithic/monolithic-layered` module. By default, 
the app is running on port `8080`, so, when you open `http://localhost:8080/` you'll see
the Bootstrap-based UI. 

The main point of this implementation is that classes annotated with `@Entity` annotation which
are actually domain classes are passed from the persistence layer up to the controller layers. It
actually means that in case if it is necessary to have another representation of data, it will be
necessary to use another set of domain classes. 

The solution here is to use view-model classes. 

Monolithic Hexagonal Application
=

The hexagonal version of the application is located in the `monolithic/monolithic-haxagonal` 
module. This is the same application but split into submodules: 

* `monolithic-hexagonal-core` contains domain classes and service which work on top of them. The 
  main point here is that all the services are using domain classes, domain classes are 
  completely independent of way of storage, loading or display. There is a repository layer (see 
  the `repository` package) which implements ports for the persistence layer. 
* `monolithic-hexagonal-persistence` contains two sets of components: entity classes and 
  transformers between entity and domain classes. The main point here is to highlight that 
  persistence and domain layers are using different set of classes so that it is necessary to 
  transform data between them. 
* `monolithic-hexagonal-web` also contains three sets of components: view models, transformers 
  and controllers. In this case idea is the same as for the persistence layer - these classes are 
  independent, and it is necessary to transform data before passing to the UI (highlight both 
  benefits and drawbacks).
* `monolithic-hexagonal-loader` is an independent module which uses only core classes but 
  technically implements a separate business logic which is built on top of them. 
* `monolithic-hexagonal-app` is an aggregator which takes all the modules and brings them together. 

Technologies to highlight here:

* Lombok
* Mapstruct