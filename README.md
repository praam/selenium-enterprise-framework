# selenium-enterprise-framework
Enterprise Selenium WebDriver automation framework built with Java, TestNG and Maven, following scalable automation and maintainable framework design practices.


# Selenium Enterprise Automation Framework

A scalable and maintainable web test automation framework built using **Java, Selenium WebDriver, TestNG, and Maven**.

This project demonstrates practical automation framework development, including reusable components, Page Object Model, test data management, reporting, cross-browser testing, parallel execution, and CI/CD integration.

## Project Objective

The objective of this project is to build an enterprise-style Selenium automation framework that can support reliable, maintainable, and scalable automated testing for web applications.

The framework is being developed incrementally using industry-standard automation practices and design patterns.

## 🛠️ Technology Stack

| Technology         | Purpose                          |
| ------------------ | -------------------------------- |
| Java               | Programming Language             |
| Selenium WebDriver | Web UI Automation                |
| TestNG             | Test Execution & Test Management |
| Maven              | Build & Dependency Management    |
| Git                | Version Control                  |
| GitHub             | Source Code Management           |
| Extent Reports     | Test Reporting                   |
| Log4j2             | Logging                          |
| Jenkins            | CI/CD                            |
| JSON               | Test Data Management             |

## Framework Architecture

The framework is designed with separation of concerns and reusable components.

```text
selenium-enterprise-framework
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.pramod.automation
│   │   │       ├── driver
│   │   │       ├── pages
│   │   │       ├── utils
│   │   │       └── listeners
│   │   │
│   │   └── resources
│   │
│   └── test
│       ├── java
│       │   └── com.pramod.automation
│       │       └── tests
│       │
│       └── resources
│
├── pom.xml
├── testng.xml
├── .gitignore
└── README.md
```

> The framework structure will evolve as additional automation capabilities are implemented.

## Application Under Test

The initial implementation uses **SauceDemo** as the web application under test.

Planned scenarios include:

* User login
* Invalid login validation
* Product verification
* Product sorting
* Add to cart
* Remove from cart
* Cart validation
* Checkout
* Order confirmation
* Logout

## Planned Framework Features

### Core Automation

* [x] Selenium WebDriver integration
* [x] Maven project setup
* [x] TestNG integration
* [ ] WebDriver Factory
* [ ] Base Test
* [ ] Configuration management
* [ ] Page Object Model
* [ ] Reusable wait utilities
* [ ] Screenshot capture
* [ ] Cross-browser execution

### Test Engineering

* [ ] Data-driven testing
* [ ] TestNG DataProvider
* [ ] Test grouping
* [ ] Retry mechanism
* [ ] Test listeners
* [ ] Parallel execution
* [ ] Failure handling

### Reporting & Logging

* [ ] Extent Reports
* [ ] Allure Reports
* [ ] Log4j2 logging
* [ ] Automatic screenshots for failures

### CI/CD

* [ ] Jenkins pipeline
* [ ] GitHub Actions
* [ ] Maven-based execution
* [ ] Headless browser execution

## How to Run

### Prerequisites

Install:

* Java 17 or higher
* Maven
* Git
* Chrome / Firefox / Edge
* VS Code or another Java IDE

Verify Java:

```bash
java -version
```

Verify Maven:

```bash
mvn -version
```

### Clone the Repository

```bash
git clone <repository-url>
```

Navigate to the project:

```bash
cd selenium-enterprise-framework
```

### Execute Tests

Run the Maven test suite:

```bash
mvn test
```

## Test Execution

The framework will eventually provide:

* Test execution summaries
* Pass/fail status
* Execution logs
* Failure screenshots
* HTML reports
* CI/CD execution results

## Development Approach

The framework is being developed incrementally using feature-based development.

Example development flow:

```text
main
 │
 ├── feature/driver-factory
 ├── feature/base-test
 ├── feature/configuration
 ├── feature/page-object-model
 ├── feature/test-data
 ├── feature/reporting
 └── feature/ci-cd
```

Each major framework capability will be implemented, tested, committed, and integrated into the main branch.

## Learning Objectives

This project is designed to demonstrate practical knowledge of:

* Selenium WebDriver
* Java automation
* TestNG
* Maven
* Page Object Model
* Framework architecture
* Design principles
* Test automation best practices
* Git and GitHub
* CI/CD
* Continuous test execution

## 👨‍💻 Author

**Pramod Ramu**

QA Automation Engineer | Selenium | Playwright | API Testing | Java | JavaScript

---

⭐ If you find this project useful, feel free to explore the framework and its development history.
