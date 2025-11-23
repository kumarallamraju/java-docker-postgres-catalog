
# Java + Docker + PostgreSQL Catalog (Frontend + Backend)

A simple full-stack application:
- **Frontend**: Thymeleaf templates served by Spring Boot
- **Backend**: Spring Boot REST API (`/api/products`) with JPA
- **Database**: PostgreSQL
- **Containerization**: Dockerfile + Docker Compose
- **CI**: GitHub Actions (build + Docker image, no registry push)

## Run locally on macOS (no Docker)
Requirements: Java 17, Maven, PostgreSQL running locally (optional; see Compose section for easier setup)

```bash
mvn spring-boot:run
# Visit http://localhost:8080
```

## Run with Docker Compose (recommended)
```bash
# build app image and start db+app
docker compose up --build
# Visit http://localhost:8080
```

### API examples
```bash
curl http://localhost:8080/api/products
curl -X POST http://localhost:8080/api/products   -H 'Content-Type: application/json'   -d '{"name":"Apple Pencil","price":129.99}'
```

## Project structure
```
java-docker-postgres-catalog/
├─ src/main/java/com/example/catalog/
│  ├─ CatalogApplication.java
│  ├─ Product.java
│  ├─ ProductRepository.java
│  ├─ ProductApiController.java
│  └─ WebController.java
├─ src/main/resources/
│  ├─ application.yml
│  ├─ data.sql (seed)
│  ├─ templates/index.html
│  └─ static/styles.css
├─ Dockerfile
├─ docker-compose.yml
├─ pom.xml
├─ .gitignore
├─ .dockerignore
└─ .github/workflows/ci.yml
```

## Push to GitHub
```bash
git init
git add .
git commit -m "Initial commit: Spring Boot + Postgres + Docker Compose"
git branch -M main
git remote add origin https://github.com/<your-username>/<repo-name>.git
git push -u origin main
```

## Notes
- Change DB credentials in `docker-compose.yml` and `ENV` in `Dockerfile` if needed.
- Hibernate is set to `ddl-auto=update` for convenience; for production use **Flyway** or **Liquibase**.
- The GitHub Actions workflow builds the JAR and Docker image **without pushing** to any registry.

## Resume bullet ideas
- Built a Java **Spring Boot** full-stack app (Thymeleaf + REST), containerized with **Docker**, backed by **PostgreSQL**, and automated **CI** with GitHub Actions.
