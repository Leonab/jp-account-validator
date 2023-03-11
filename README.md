# jp-account-validator

---

### Folder Structure
Probably went a little overboard with the DDD based directories but was a good opportunity to learn

```
com.jpmorgan.accounts.validation
├── application
│   ├── controller
│   ├── dto
├── domain
│   ├── model
│   └── service
├── config
└── infrastructure
    └── mapper

```

&nbsp;
### How to run

#### Using gradle wrapper

`./gradlew bootRun --args='--spring.profiles.active=test'`

Available profiles: `test`, `prod`

#### Using docker

- Run `./gradlew clean build`
- Run `docker build -t jpvalidator .`
- Run `docker run -p 8080:8080 jpvalidator`

Another way is using the jib gradle plugin
- Run `gradle jibDockerBuild`
- `docker run` the generated image