# API Automation Testing with Reqres API

Repository for Learning Software Quality Assurance - API Automation Using RestAssured with Cucumber

This is a personal project focused on practicing functional API automation testing on the Reqres API using RestAssured
with Cucumber. The goal is to enhance skills in API End-to-End (E2E) testing, covering critical API workflows such as
creating a user, retrieving user details, updating user information, deleting a user, and validating error responses.

The project leverages:

- **Cucumber** for structuring test scenarios in Gherkin syntax
- **RestAssured** for making HTTP requests and handling API responses
- **JUnit** for managing the test framework
- **JSON Schema Validator** for ensuring response structure compliance.

## 🚀 Project Overview

This project automates various API testing scenarios using the Reqres API. Key areas tested include:

- **Users**: Operations like listing users, fetching single users, creating, updating, and deleting users.
- **Resource**: Listing resources, fetching single resources, and handling "not found" cases.
- **Login**: Testing both successful and unsuccessful login attempts.
- **Register**: Validating successful and unsuccessful user registrations.

## ⚙️ Technologies Used

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

- **`src/test/resources`**: Contains the Gherkin feature files for Cucumber test scenarios and JSON schema files for
  validating API responses.
- **`src/test/java/steps`**: Contains the step definition files and test runners for Cucumber.
- **`src/main/java`**: Contains utility classes, page objects, and core logic for the tests.

## 🛠️ Installation Instructions

1. **Clone the repository**:
   ```bash
   https://github.com/herbetsimanjuntaak/rest-assured-reqres.git
2. **Navigate to the project directory**:
   ```
   cd rest-assured-reqres
   ```
3. **Install dependencies**:
   ```
   ./gradlew build
   ```
4. **Run the tests**:
   ```
   ./gradlew test
   ```

## 📝 Test Reporting

After running the tests, the reports will be available at the following locations:

- **HTML Report**: View detailed test results in an easy-to-read format at
    - `reports/reqres-api-report.html`.

- **JSON Report**: Access raw test results data in JSON format at
    - `reports/reqres-api-report.json`

These reports will provide insights into test execution, including passed/failed tests, test durations, and more.

## 🔗 Resources

- **Reqres API**: [Visit Website](https://reqres.in/)
- **Test Case Documentation**: [Reqres API Test Cases](https://docs.google.com/spreadsheets/d/1yWwq_G2lcTAUBSiyaBKEvAsQ1SbVBAAyDtkpSzitgQA/edit?usp=sharing)

## 🤝 Contributing

We welcome contributions to improve the project! To contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature-name`).
3. Make your changes and commit them (`git commit -am 'Add new feature'`).
4. Push to your branch (`git push origin feature/your-feature-name`).
5. Create a pull request with a clear description of the changes.
   🏃‍♂️
   Please ensure your code follows the project’s coding standards and includes appropriate tests.
