# AutomationSelenium
# README: Running Amazon India Search and Add to Cart Automation

## Overview
This automation script tests the functionality of searching for wrist watches on Amazon India, filtering results by brand and material, navigating to the second page of search results, selecting a product, and adding it to the shopping cart. It uses **Selenium WebDriver** for browser automation, **TestNG** for test management, and **WebDriverManager** for managing the ChromeDriver installation.

## Prerequisites
Before running the automation script, ensure the following tools are installed and set up:

### 1. **Java**
   - Ensure **Java** is installed on your system. You can download it from [Oracle's official site](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
   - Verify Java installation with:
     ```bash
     java -version
     ```

### 2. **Maven**
   - Ensure **Maven** is installed. If not, download it from [Maven's official website](https://maven.apache.org/download.cgi) and follow the installation instructions.
   - Verify Maven installation with:
     ```bash
     mvn -v
     ```

### 3. **IDE Setup**
   - Use an IDE like **Eclipse** with Maven support to run this project.

### 4. **Browser & Driver**
   - **Google Chrome** should be installed on your system.
   - **ChromeDriver** will be automatically managed by **WebDriverManager** in the script. Ensure that your system’s environment allows the execution of ChromeDriver.

## Dependencies
The script uses several dependencies which are managed by **Maven**. These dependencies are specified in the `pom.xml` file.

### Required Libraries
- **Selenium WebDriver**: For automating browser actions.
- **WebDriverManager**: Automatically manages the ChromeDriver binary.
- **TestNG**: Framework for running the tests.

### Example of Maven dependencies in `pom.xml`:
```xml
<dependencies>
    <!-- Selenium WebDriver -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.27.0</version>
    </dependency>

    <!-- WebDriverManager -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.9.2</version>
    </dependency>

    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.10.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Steps to Run the Automation Script

### 1. **Clone the Repository**
   If the code is hosted on a Git repository, clone it to your local system:
   ```bash
   git clone https://github.com/your-repository/AmazonIndiaTest.git
   ```

### 2. **Navigate to the Project Directory**
   Go to the root directory of the project:
   ```bash
   cd AmazonIndiaTest
   ```

### 3. **Build the Project (Optional)**
   If you haven't built the project yet, you can do so using Maven. This step downloads the dependencies and compiles the project:
   ```bash
   mvn clean install
   ```

### 4. **Run the Test with Maven**
   To run the automation script using TestNG, use the following command:
   ```bash
   mvn test
   ```

   This will trigger the execution of the `AmazonIndiaTest` class.

### 5. **Running TestNG through IDE (Optional)**
   If you're using an IDE like **IntelliJ IDEA** or **Eclipse**, you can run the test directly from the IDE by:
   - Right-clicking the `AmazonIndiaTest` class or the test method `testAmazonSearchAndAddToCart`.
   - Selecting **Run**.

### 6. **Observe the Test Execution**
   - The script will automatically launch a new **Chrome browser** window.
   - It will perform the following actions on Amazon India:
     1. Search for "Wrist Watches".
     2. Apply filters for **Leather** and **Fastrack** brands.
     3. Navigate to the second page of the search results.
     4. Select the first product in the first row and add it to the shopping cart.
   - After completing the actions, the test will close the browser.

## Troubleshooting

### 1. **WebDriverManager Setup Issues**
   If WebDriverManager isn't correctly managing the ChromeDriver, try manually downloading the appropriate version of **ChromeDriver** for your system from [ChromeDriver Downloads](https://sites.google.com/a/chromium.org/chromedriver/) and set the path in your environment variables or in the code.

### 2. **TestNG Assertion Failures**
   - If TestNG reports failures, verify the XPath selectors for the elements. Amazon's website design may change over time, requiring updates to the locators.

### 3. **Slow Execution or Timeout**
   - If the test fails due to timeouts (elements not found within the given time), try increasing the wait time in the `WebDriverWait` instantiation:
     ```java
     wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     ```

## Code Explanation

### Setup:
- **`@BeforeMethod`** initializes the browser, maximizes the window, and navigates to Amazon India’s homepage.

### Test Steps:
1. **Search for wrist watches** by interacting with the search bar.
2. **Apply filters** for "Leather" and "Fastrack" to narrow down the results.
3. **Navigate to the second page** of search results.
4. **Click on the first product** in the first row of the second page.
5. **Switch to the new tab** that opens and add the product to the cart.

### Cleanup:
- **`@AfterMethod`** closes the browser after the test execution is completed.

## Conclusion
Follow these steps to run the **Amazon India Search and Add to Cart** automation successfully. You can extend this script by adding more test cases or handling additional user interactions on Amazon. Make sure to regularly check the XPath selectors and update them if Amazon updates their web page design.

For any further questions, feel free to refer to the [Selenium Documentation](https://www.selenium.dev/documentation/en/) or [TestNG Documentation](https://testng.org/doc/).

Happy testing! 🎉
