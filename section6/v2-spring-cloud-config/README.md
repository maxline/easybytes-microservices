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