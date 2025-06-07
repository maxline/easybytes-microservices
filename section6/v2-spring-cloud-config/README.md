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
