# Section 6 - Configuration management in Microservices
## 70. Accounts - reading configuration from Value annotation
AccountController - build.version

## 71.  reading configuration using Environment interface

## 72.  reading configuration using @ConfigurationProperties
- AccountContactInfoDto - `@ConfigurationProperties(prefix = "accounts")`
- AccountsApplication - `@EnableConfigurationProperties(AccountContactInfoDto.class)`

## 74.  Spring boot profiles
- application.yaml
- application_prod.yaml
- application_qa.yaml

## 76.  Activating profiles using command line and JVM & Environment options
Intellij idea > Program arguments - 1st priority:
`--spring.profiles.active=prod --build.version=1.1`

Intellij idea > VM options - 2nd priority:
`-Dspring.profiles.active=qa -Dbuild.version=1.3`

Intellij idea > Environment variables - 2d priority:
`SPRING_PROFILES_ACTIVE=prod;BUILD_VERSION=1.8`
