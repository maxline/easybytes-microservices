# Course EasyBytes Spring Boot Microservices with Docker and Kubernetes
https://udemy.com/course/master-microservices-with-spring-docker-kubernetes/

## Github link
https://github.com/eazybytes/microservices/

## Useful settings and libraries
- Intellij idea -> Advanced settings -> allow auto-make to start even if developed application starting. 
- Ctrl - F12 - shows all methods in the class. Useful for classes using Lombok or annotated as @Repository.
- https://modelmapper.org/getting-started/, https://mapstruct.org/ - opensource libraries for mapping from entity to dto.
- chrome-extension Talent Api Tester - simple Postman alternative.
- http://localhost:8080/h2-console/ - h2 database console.

## Learnings
- @MappedSuperclass - marks the class as a parent for other entity classes.

## APIs
- smoke test: GET http://localhost:8080/api/sayHello
- create an account: POST http://localhost:8080/api/create
- get account details: GET http://localhost:8080/api/fetch?mobileNumber=001
