# Todo List API

## Overview
This is a RESTful API for managing a simple todo list application using Spring Boot, Hibernate, and MySQL. The API allows users to create, read, update, and delete todo items.

## Features
- CRUD operations for managing todo items.
- Uses Spring Boot and Hibernate for backend logic.
- MySQL as the database.
- Unit tests with >80% coverage.
- Code quality checks (coverage, complexity, checkstyle).

## Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Flyway (for database migrations)
- JUnit & Mockito (for testing)
- Jacoco (for test coverage)
- Checkstyle & PMD (for code quality checks)

## Getting Started

### Prerequisites
Ensure you have the following installed:
- Java 21+
- Maven
- MySQL

### Clone the Repository
```sh
git clone https://github.com/morskyua/todo-list-api.git
cd todo-list-api
```

### Database Setup
Create a MySQL database:
```sql
CREATE DATABASE todo_db;
```
Update `src/main/resources/application.properties` with your MySQL credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### Build and Run the Application
```sh
mvn clean install
mvn spring-boot:run
```

## API Endpoints

### Get All Todos
```http
GET /api/todos
```
Response:
```json
[
  { "id": 1, "title": "Sample Todo", "description": "This is a todo item" }
]
```

### Create a Todo
```http
POST /api/todos
Content-Type: application/json
```
Request Body:
```json
{ "title": "New Task", "description": "Task details" }
```

### Update a Todo
```http
PUT /api/todos/{id}
Content-Type: application/json
```
Request Body:
```json
{ "title": "Updated Task", "description": "Updated details" }
```

### Delete a Todo
```http
DELETE /api/todos/{id}
```

## Running Tests
```sh
mvn test
```

## Code Quality Checks
Run Checkstyle, PMD, and Jacoco coverage checks:
```sh
mvn verify
```

## License
This project is licensed under the MIT License.

