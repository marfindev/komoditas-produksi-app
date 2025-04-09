# Komoditas Produksi App

A Spring Boot web application for managing agricultural commodity and production data. The system supports CRUD operations, automated code generation, and monthly production reports. It's built using modern Java technologies including Spring Boot, Spring Data JPA, Thymeleaf, and PostgreSQL.

---

## 📋 Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [Examples](#examples)
- [Troubleshooting](#troubleshooting)
- [Contributors](#contributors)
- [License](#license)

---

## 🚀 Features

- CRUD functionality for commodities and production data
- Automatic code generation for new entries
- Monthly production reporting
- Responsive web UI using Thymeleaf and Bootstrap
- PostgreSQL integration for persistent storage

---

## 🛠 Technologies Used

- Java 21
- Spring Boot 2.7.18
- Spring Data JPA
- PostgreSQL
- Thymeleaf
- Bootstrap
- Maven

---

## 💾 Installation

### Prerequisites

- Java 21+
- Maven
- PostgreSQL (running and accessible)

### Steps

```bash
# Clone the repository
git clone https://github.com/yourusername/komoditas-produksi-app.git
cd komoditas-produksi-app

# Configure your database (see below)

# Build the application
./mvnw clean install

# Run the application
./mvnw spring-boot:run
```

---

## ⚙️ Configuration

Edit `src/main/resources/application.properties` to set up your PostgreSQL connection:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/komoditas_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

---

## 📖 Usage

After starting the application:

- Access the web UI via: `http://localhost:8080`
- Use the navigation to manage commodities and production entries
- Generate monthly reports via the report section

---

## 💡 Examples

- **Commodities:** Add/edit types of crops or products (e.g. rice, corn)
- **Production Records:** Input monthly production figures, linked to specific commodities
- **Reports:** View summarized production by month and commodity

---

## 🛠 Troubleshooting

- Ensure PostgreSQL is running and accessible
- Confirm database credentials in `application.properties`
- Use `mvnw` for consistent Maven builds across platforms

---

## 👥 Contributors

- Marfin

Feel free to contribute by submitting pull requests or issues!

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---
