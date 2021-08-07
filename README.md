Building the microservices
=

In order to build all the microservices, execute the following command: 

```shell
$ ./gradlew clean buildMicroservices
```

As a result, all the microservice apps will be compiled and packed into the
executable Jar's with Spring Boot apps inside. 

Just to check it, execute the following command:

```shell
docker image ls | grep microservice
microservice-state-machine                      1.0-SNAPSHOT                                            20e0f14069ae   41 years ago    269MB
microservice-gateway                            1.0-SNAPSHOT                                            c54c89ebe09f   41 years ago    291MB
microservice-pharmacies                         1.0-SNAPSHOT                                            9a660dbe95bb   41 years ago    323MB
microservice-recipies                           1.0-SNAPSHOT                                            4e1a3d72b175   41 years ago    325MB
microservice-graphql                            1.0-SNAPSHOT                                            bff861c6f52b   41 years ago    308MB
microservice-drugs                              1.0-SNAPSHOT                                            d1ea9cdc4f6a   41 years ago    320MB
microservice-service-discovery                  1.0-SNAPSHOT                                            87b173a247b2   41 years ago    294MB
```