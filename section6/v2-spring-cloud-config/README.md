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
- http://localhost:8071/loans/prod