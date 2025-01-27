# API Automation Testing with Reqres API

This repository is dedicated to learning Software Quality Assurance (SQA) through API automation testing using **RestAssured** and **Cucumber**.

This personal project focuses on practicing functional API automation testing on the **Reqres API**.
It aims to enhance skills in API End-to-End (E2E) testing by covering essential workflows,
such as creating users, retrieving user details, updating user information, deleting users,
and validating error responses.

## 🚀 Project Highlights

The project automates various API testing scenarios with the **Reqres API**. Key functionalities tested include:

- **Users**:
    - Listing users
    - Fetching single user details
    - Creating, updating, and deleting users
- **Resource**:
    - Listing available resources
    - Fetching single resources
    - Handling "not found" cases
- **Login**:
    - Validating successful and unsuccessful login attempts
- **Register**:
    - Testing successful and unsuccessful user registrations

## ⚙️ Technologies Used

This project leverages the following tools and technologies:

- **💻 Java**: The primary programming language used for the project.
- **✅ JUnit**: A framework for unit testing, version 4.13.2.
- **🍏 Cucumber**: For behavior-driven development (BDD) testing.
    - `cucumber-junit` (7.20.1) for JUnit integration.
    - `cucumber-java` (7.20.1) for Gherkin syntax bindings.
    - `cucumber-java8` (7.20.1) for Java 8 functional support.
- **🌐 RestAssured**: A library for testing REST APIs, version 5.5.0.
- **📑 JSON Schema Validator**: For validating JSON responses against schemas.
- **📦 Gradle**: Build automation tool for managing dependencies, building the project, and running tests.
- **🗂️ Git**: Version control tool for managing the project codebase and collaboration.

## 📂 Project Structure

The repository follows a well-organized structure to enhance readability and maintainability:

- **`src/test/resources`**: Contains:
    - Gherkin feature files for defining test scenarios.
    - JSON schema files for response validation.
- **`src/test/java/steps`**: Includes:
    - Step definitions for Cucumber.
    - Test runners.
- **`src/main/java`**: Holds:
    - Utility classes.
    - Core logic for automation.
    - Page Object Models.

## 🛠️ Installation and Usage

To get started with this project, follow these steps:

1. **Clone the repository**:
   ```bash
   https://github.com/herbetsimanjuntaak/rest-assured-reqres.git
2. **Navigate to the project directory**:
   ```
   cd rest-assured-reqres
   ```
3. **Build the project and install dependencies**:
   ```
   ./gradlew build
   ```
4. **Run the tests**:
   ```
   ./gradlew test
   ```

## 📝 Test Reporting

After executing the tests, you can find the reports in the following locations:

- **HTML Report**: View detailed test results in an easy-to-read format at
    - **Path**:`target/reqres-api-report.html`.
    - Provides a detailed summary of test results.

- **JSON Report**: Access raw test results data in JSON format at
    - **Path**:`target/reqres-api-report.json`
    - Contains raw test execution data for further analysis.

## 🔗 Resources

- **Reqres API**: [Visit Website](https://reqres.in/)
- **Test Case Documentation**: [Reqres API Test Cases](https://docs.google.com/spreadsheets/d/1yWwq_G2lcTAUBSiyaBKEvAsQ1SbVBAAyDtkpSzitgQA/edit?usp=sharing)
