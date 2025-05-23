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
- https://springdoc.org/ - springdoc openapi documentation.
- https://www.lucidchart.com/blog/ddd-event-storming/ - event storming.

## Learnings
- @MappedSuperclass - marks the class as a parent for other entity classes.

## APIs
- smoke test: GET http://localhost:8080/api/sayHello
- create an account: POST http://localhost:8080/api/create
- get account details: GET http://localhost:8080/api/fetch?mobileNumber=001
- swagger: http://localhost:8080/swagger-ui/index.html

## Tips
- A better Constructor annotation for the controller.
Instead of creating a constructor manually because of the inclusion of String buildVersion, 
you can define the IAccountsService as "final" and use the @RequeridArgsConstructor of Lombok.
If you have intentions to use @RequeridArgsConstructor annotation, then you need to mark these fields as well final. 
So that Spring takes care of Auto-wiring them as dependencies.
