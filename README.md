# Maven Selenium Test Automation

## Overview

This project contains a suite of automated tests using Selenium WebDriver with TestNG for the FitPeo Revenue Calculator. The tests are designed to interact with various web elements including sliders and checkboxes to ensure the functionality of the application.

## Prerequisites

- **Java**: Ensure Java is installed on your system. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **Maven**: This project uses Maven for dependency management. Install Maven from [Maven's official website](https://maven.apache.org/download.cgi).
- **ChromeDriver**: Download ChromeDriver compatible with your version of Chrome from [ChromeDriver downloads](https://sites.google.com/chromium.org/driver/downloads).

## Setup

1. **Clone the Repository**
    ```bash
    git clone https://github.com/yourusername/your-repository-name.git
    cd your-repository-name
    ```

2. **Update the ChromeDriver Path**
    Edit the `Testmain` class and update the path to your ChromeDriver executable:
    ```java
    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
    ```

3. **Install Dependencies**
    Run the following Maven command to install the required dependencies:
    ```bash
    mvn install
    ```

## Running Tests

To run the tests, execute the following Maven command:
```bash
mvn test
