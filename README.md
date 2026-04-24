# Cafe-Connect

A Spring Boot application for managing café operations.

## Project Package Structure

Base package: `com.yash.cafe_connect`

```
src/main/java/com/yash/cafe_connect/
├── config/          # Spring configuration classes (beans, CORS, Swagger, etc.)
├── controller/      # REST controllers – handle HTTP requests and responses
├── dto/             # Data Transfer Objects – request/response payloads (no JPA)
├── entity/          # JPA entity classes mapped to database tables
├── exception/       # Custom exception classes and global exception handler
├── repository/      # Spring Data JPA repositories (interfaces)
├── security/        # Security configuration (JWT filters, auth providers, etc.)
├── service/         # Service interfaces defining business logic contracts
│   └── impl/        # Concrete service implementations
└── util/            # Utility/helper classes shared across layers

src/main/resources/
├── application.properties   # Main application configuration
├── static/                  # Static web assets (JS, CSS, images)
├── templates/               # Server-side templates (Thymeleaf, etc.)
└── db/
    └── migration/           # Flyway SQL migration scripts (V1__init.sql, …)
```

### Layer Responsibilities

| Layer | Package | Responsibility |
|-------|---------|---------------|
| Controller | `controller` | Receive HTTP requests, delegate to service, return responses |
| Service | `service` + `service/impl` | Business logic; interface + implementation pattern |
| Repository | `repository` | Database access via Spring Data JPA |
| Entity | `entity` | Database table mappings (`@Entity` classes) |
| DTO | `dto` | Request/response objects to avoid exposing entities directly |
| Config | `config` | Application-wide Spring beans and configuration |
| Security | `security` | Authentication & authorisation (JWT, filters, roles) |
| Exception | `exception` | Custom exceptions and `@ControllerAdvice` error handling |
| Util | `util` | Stateless helper/utility classes |