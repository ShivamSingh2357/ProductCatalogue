# Product Catalogue API

A RESTful API for managing products built with Spring Boot.

## Tech Stack

- **Java 17**
- **Spring Boot 4.0.0**
- **Spring Data JPA**
- **PostgreSQL**
- **SpringDoc OpenAPI (Swagger)**
- **Docker**

## Quick Start

### Prerequisites

- Java 17 (for local development)
- Maven (for local development)

### Running Locally

```bash
# Build the application
./mvnw clean package -DskipTests

# Run the application
./mvnw spring-boot:run
```

## API Documentation

Once the application is running, access the API documentation at:

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/v3/api-docs

## Health Checks

- **Health**: http://localhost:8080/actuator/health
- **Info**: http://localhost:8080/actuator/info
- **Metrics**: http://localhost:8080/actuator/metrics

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/v1/product` | Get all products |

### Production Deployment

## Environment Variables

| Variable | Description | Default |
|----------|-------------|---------|
| `SPRING_PROFILES_ACTIVE` | Active Spring profile | - |
| `SPRING_DATASOURCE_URL` | Database JDBC URL | - |
| `SPRING_DATASOURCE_USERNAME` | Database username | - |
| `SPRING_DATASOURCE_PASSWORD` | Database password | - |
| `JAVA_OPTS` | JVM options | See Dockerfile |

## Profiles

- **default**: Local development
- **docker**: Docker environment with container networking
- **prod**: Production with optimized settings

## Project Structure

```
src/main/java/com/candescent/ProductCatalogue/
├── common/
│   ├── exception/     # Custom exceptions & global handler
│   └── util/          # Utility classes
├── config/            # Configuration classes
├── controller/        # REST controllers
├── dto/               # Data Transfer Objects
│   └── mock/          # Mock data DTOs
├── entities/          # JPA entities
├── mapper/            # Entity-Model mappers
├── model/             # Domain models
├── repository/        # JPA repositories
└── service/           # Business services
```

## CI/CD Pipeline

This project uses GitHub Actions for continuous integration and deployment.

### Workflows

| Workflow | Trigger | Description |
|----------|---------|-------------|
| **CI Pipeline** | Push to `main`/`develop`, PRs | Build, test, security scan, Docker build |
| **CD Pipeline** | Tags `v*`, Manual | Build & push to GHCR, deploy to staging/prod |
| **PR Check** | Pull requests | Quick validation, tests, Docker build test |

### Pipeline Features

- ✅ Maven build with caching
- ✅ Unit & integration tests
- ✅ OWASP dependency vulnerability scan
- ✅ Docker multi-arch build (amd64/arm64)
- ✅ Trivy container security scan
- ✅ SBOM (Software Bill of Materials) generation
- ✅ GitHub Container Registry (GHCR) publishing
- ✅ Environment-based deployments (staging → production)
- ✅ Dependabot for automated dependency updates

### Creating a Release

```bash
# Trigger release workflow manually from GitHub Actions
# Or create a tag locally:
git tag -a v1.0.0 -m "Release v1.0.0"
git push origin v1.0.0
```

### Environment Variables (Secrets)

Configure these in GitHub repository settings → Secrets:

| Secret | Description |
|--------|-------------|
| `GITHUB_TOKEN` | Auto-provided by GitHub |
| `DATABASE_URL` | Production database URL |
| `DATABASE_USERNAME` | Production database username |
| `DATABASE_PASSWORD` | Production database password |

## License

Apache 2.0

