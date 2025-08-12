# Goodreads QA Automation Project

## Overview
This project demonstrates automated UI and API testing for the Goodreads app using Selenium WebDriver (Java) and Postman. It includes end-to-end test cases for key user workflows and API validations, with Continuous Integration powered by GitHub Actions.

## Tech Stack
- Selenium WebDriver (Java)
- TestNG
- Postman + Newman CLI
- GitHub Actions (CI/CD)

## Features
- UI Tests: Book search, adding/removing shelves, profile validation.
- API Tests: Fetching book data and validating API responses using the Open Library API.
- Automated test execution on every push via GitHub Actions.
- HTML reports generated for both UI and API test runs.

## Project Structure
goodreads-qa-automation/
├── selenium-tests/              # Selenium UI tests (Java + TestNG)
│   ├── src/main/java/           # Page Object classes
│   ├── src/test/java/           # Test classes
│   ├── pom.xml                  # Maven config and dependencies
│
├── postman-tests/               # Postman API collections and environments
│   ├── openlibrary_collection.json
│   ├── openlibrary_env.json
│
├── .github/
│   └── workflows/
│       └── ci.yml               # GitHub Actions workflow for CI/CD
│
├── LICENSE                      # MIT License file
├── README.md                    # Project documentation
├── .gitignore                   # Git ignore settings
