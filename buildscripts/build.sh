#!/bin/bash

# Describing the build process on the very top level
# 1) Build all the code with Apache Maven
# 2) Build Docker images for all the modules with docker build
# 3) Publish all the images to the GitHub Packages

# To take into the account:
# 1) All the services should wait until service discovery is started

### The build starts here ###

# Building all the code with Apache Maven
CURRENT=$(pwd)
cd .. && ./mvnw clean package
cd ${CURRENT}

# Building docker images and publish them
docker build \
    --build-arg module_path=microservices/microservice-service-discovery \
    -t microservices/service-discovery:latest \
    -f ./Dockerfile ..

docker build \
    --build-arg module_path=microservices/microservice-delivery/delivery-app \
    -t microservices/delivery:latest \
    -f ./Dockerfile ..

docker build \
    --build-arg module_path=microservices/microservice-drugs \
    -t microservices/drugs:latest \
    -f ./Dockerfile ..

docker build \
    --build-arg module_path=microservices/microservice-pharmacies \
    -t microservices/pharmacies:latest \
    -f ./Dockerfile ..

docker build \
    --build-arg module_path=microservices/microservice-recipes \
    -t microservices/recipes:latest \
    -f ./Dockerfile ..

docker build \
    --build-arg module_path=microservices/microservice-graphql \
    -t microservices/graphql:latest \
    -f ./Dockerfile ..

docker build \
    --build-arg module_path=microservices/microservice-gateway \
    -t microservices/gateway:latest \
    -f ./Dockerfile ..