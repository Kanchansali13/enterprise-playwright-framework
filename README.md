# Enterprise Playwright Automation Framework

A scalable and maintainable UI automation framework built using **Playwright**, **Java**, **TestNG**, and **Maven** following the **Page Object Model (POM)** design pattern and enterprise automation best practices.

---

## 🚀 Tech Stack

- Java 21
- Playwright
- TestNG
- Maven
- IntelliJ IDEA
- Git & GitHub
- Log4j2
- Allure (In Progress)

---

## 📂 Project Structure

```
enterprise-playwright-framework
│
├── src
│   ├── main
│   │   └── java
│   │       └── com.kanchansali
│   │           ├── base
│   │           ├── config
│   │           ├── constants
│   │           ├── data
│   │           ├── factory
│   │           ├── pages
│   │           └── utilities
│   │
│   └── test
│       └── java
│           └── com.kanchansali.tests
│
├── pom.xml
└── README.md
```

---

## ✨ Framework Features

- Page Object Model (POM)
- Browser Factory Design Pattern
- Configurable Browser & Headless Execution
- Centralized Test Data
- Reusable Base Classes
- Dynamic XPath/CSS Locators
- Page Chaining
- Utility Classes
- Assertion Utilities
- Screenshot Utility
- Maven Build Management

---

## 🧪 Automated Test Scenarios

### Login Module
- Valid Login
- Invalid Login

### Inventory Module
- Verify Inventory Count
- Add Single Product
- Add Multiple Products

### Cart Module
- Verify Product Added
- Verify Cart Count
- Remove Product
- Checkout Navigation

### Checkout Module
- Complete End-to-End Purchase Flow

---

## ▶️ How to Run the Project

### Clone Repository

```bash
git clone <your-github-repository-url>
```

### Navigate to Project

```bash
cd enterprise-playwright-framework
```

### Install Dependencies

```bash
mvn clean install
```

### Run All Tests

```bash
mvn clean test
```

---

## ⚙️ Configuration

Framework configuration is managed using the `config.properties` file.

Example:

```properties
browser=chrome
headless=false
base.url=https://www.saucedemo.com/
username=standard_user
password=secret_sauce
```

---

## 🏗️ Framework Design

The framework follows enterprise automation principles:

- Page Object Model (POM)
- Reusable Page Components
- Centralized Configuration
- Dynamic Locators
- Modular Design
- Separation of Test Logic and Page Logic

---

## 📌 Current Status

### ✅ Completed

- Framework Setup
- Browser Factory
- BaseTest
- BasePage
- Config Reader
- Login Automation
- Inventory Automation
- Cart Automation
- Checkout Automation

### 🚧 In Progress

- Data Driven Testing
- Allure Reporting
- Extent Reports
- API Automation
- Database Validation
- Jenkins Integration
- Docker Support
- GitHub Actions
- AI-Powered Test Automation

---

## 📈 Future Enhancements

- Excel Data Provider
- JSON Test Data
- Java Faker Integration
- Cross Browser Execution
- Parallel Execution
- REST API Automation
- MySQL Validation
- Jenkins Pipeline
- Docker Execution
- GitHub Actions CI/CD
- AI-assisted Test Generation
- AI Failure Analysis

---

## 👨‍💻 Author

**Kanchan Sali**

Senior Test Automation Engineer

---

## ⭐ If you found this project helpful

Please consider giving it a ⭐ on GitHub.
