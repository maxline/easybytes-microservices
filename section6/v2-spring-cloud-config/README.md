# Section 6. Part 2 - Spring cloud configuration 
## 81. Building Config Server using Spring Cloud Config
ConfigserverApplication
`@EnableConfigServer`

## 82. Reading configurations from the class path location of Config Server
config folder:
- accounts-prod.yaml
- cards.yaml
- loans-qa.yaml

- http://localhost:8071/accounts/qa
- http://localhost:8071/cards/native
- http://localhost:8071/cards/default
- http://localhost:8071/loans/prod

## 83. Updating Accounts Microservice to read properties from Config Server
add spring cloud client dependency "spring-cloud-starter-config"
## 84. Updating Loans & Cards Microservice to read properties from Config Server

## 85. Reading configurations from a file system location
- application.yaml
`search-locations: "file:///Users//mac//Learning//udemy-easybytes//config"`

## 86. Reading configurations from a GitHub repository
- `profiles: activate: git`
- `uri: "https://github.com/eazybytes/eazybytes-config.git"`

- Official documentation: https://docs.spring.io/spring-cloud-config/reference/server/environment-repository.html

## 87. Encryption & Decryption of properties inside Config server
- application.yaml `encrypt: key: "111aaa222bbb333ccc"`
- accounts-prod.yaml `{cipher}`

- http://localhost:8071/encrypt
- http://localhost:8071/decrypt
- http://localhost:8071/accounts/prod - `"accounts.contactDetails.mail": "serg_encripted@mail.com"`
- http://localhost:8080/api/contact-info - `"mail": "serg_encripted@mail.com"`

## 88. Refresh configurations at runtime using refresh actuator path
- http://localhost:8080/actuator/refresh
- Change property values runtime without restarting the microservice
management: endpoints: web: exposure: include: refresh

## 89. Refresh configurations at runtime using Spring Cloud Bus
RabbitMQ
- https://www.rabbitmq.com/docs/download
- latest RabbitMQ 4.x
`docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4-management`
- put "spring-cloud-starter-bus-amqp" dependency in each microservice pom.xml
- put   
```
rabbitmq:
  host: localhost
  port: 5672
  username: "guest"
  password: "guest"
```
  to application.yaml 
- http://localhost:8080/actuator
```
"busrefresh-destinations": {
"href": "http://localhost:8080/actuator/busrefresh/{*destinations}",
"templated": true
},
```
- http://localhost:8080/actuator/beans
refreshBusEndpoint

- change configurations properties at git config server
- http://localhost:8071/accounts/prod check changes that happens runtime
- http://localhost:8080/actuator/busrefresh - refresh at runtime and update all 3 microservices config changes
- http://localhost:8080/api/contact-info - check changes that happens after refresh

## 90. Refresh config at runtime using Spring Cloud Bus & Spring Cloud Config monitor
pom.xml `spring-cloud-config-monitor`
- https://hookdeck.com/
- https://console.hookdeck.com/
```
brew install hookdeck/hookdeck/hookdeck
hookdeck login --cli-key 4wj4zlgjd57xo7oyk3bij432vk1n981cq1qtaeucsn190eyr1y
hookdeck listen 8071 Source --cli-path /monitor

Source URL: https://hkdk.events/egkisq4wbhfwc5
>>> Log
2025-06-08 12:47:19 [200] POST http://localhost:8071/monitor | https://dashboard.hookdeck.com/cli/events/evt_lSD99gxc03ZX9iwNvA

```
After config changed in git https://github.com/maxline/eazybytes-config.git - 
it is automatically changed in http://localhost:8080/api/contact-info <br>
and can be checked at 
https://github.com/maxline/eazybytes-config/settings/hooks > 
 Manage webhooks - Recent Deliveries

## 92. Introduction to Liveness and Readiness probes
- http://localhost:8071/actuator/health
- http://localhost:8071/actuator/health/liveness
- http://localhost:8071/actuator/health/readiness
```
"liveness": {
"status": "UP"
},
"readiness": {
"status": "DOWN"
},
```

## 93. Updating Docker Compose file to adapt Config Server changes - Part 2
```
  depends_on:
    rabbit:
      condition: service_healthy
  healthcheck:
    test: ["curl --fail silent http://localhost:8071/actuator/health/readiness | grep UP || exit 1"]
    interval: 10s
    timeout: 5s
    retries: 3
    start_period: 10s
 ...   
  depends_on:
    configserver:
      condition: service_healthy
```


## 94. Optimizing Docker Compose file