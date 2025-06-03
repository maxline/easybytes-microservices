# Section 6 - Configuration management in Microservices
## 70. Accounts - reading configuration from Value annotation
AccountController - build.version

## 71.  reading configuration using Environment interface

## 72.  reading configuration using @ConfigurationProperties
- AccountContactInfoDto - `@ConfigurationProperties(prefix = "accounts")`
- AccountsApplication - `@EnableConfigurationProperties(AccountContactInfoDto.class)`