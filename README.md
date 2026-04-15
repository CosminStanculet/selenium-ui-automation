# Selenium Test Automation — Demo Web Shop

Automated UI test suite for [DemoWebShop by Tricentis](https://demowebshop.tricentis.com/) built with **Java**, **Selenium WebDriver**, and **TestNG**.

---

## Project Structure

```
├── SeleniumHelper.java        # WebDriver setup and base configuration
├── SeleniumMethodsNew.java    # Reusable test actions and methods
└── TestsRun.java              # Test scenarios combining multiple actions
```

### Class Overview

- **`SeleniumHelper`** — Initialises the ChromeDriver before each test class, sets the base URL, and maximises the browser window.
- **`SeleniumMethodsNew`** — Contains individual reusable test actions such as user registration, login, adding items to cart, filling checkout forms, and more.
- **`TestsRun`** — Orchestrates full end-to-end test scenarios by combining methods from `SeleniumMethodsNew`.

---

## Test Scenarios

| Test | Description |
|------|-------------|
| `createUserTest` | Registers a new user account |
| `loginUserAndAddAddressTest` | Logs in and adds a shipping address |
| `buyDesktopAsGuestTest` | Guest checkout flow for a desktop product |
| `loginAndBuyMultipleItemsTest` | Logged-in purchase of multiple items (book, apparel, jewelry) |

---

## Prerequisites

- Java 11+
- Maven or Gradle
- Google Chrome (or [Chrome for Testing](https://googlechromelabs.github.io/chrome-for-testing/))
- Internet connection (tests run against the live demo site)

---

## Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/<your-repo>.git
   cd <your-repo>
   ```

2. Update the Chrome binary path in `SeleniumHelper.java` if needed:
   ```java
   options.setBinary("/path/to/Google Chrome for Testing");
   ```

3. Add dependencies to your `pom.xml` (Maven):
   ```xml
   <dependencies>
     <dependency>
       <groupId>io.github.bonigarcia</groupId>
       <artifactId>webdrivermanager</artifactId>
       <version>5.8.0</version>
     </dependency>
     <dependency>
       <groupId>org.seleniumhq.selenium</groupId>
       <artifactId>selenium-java</artifactId>
       <version>4.18.1</version>
     </dependency>
     <dependency>
       <groupId>org.testng</groupId>
       <artifactId>testng</artifactId>
       <version>7.9.0</version>
       <scope>test</scope>
     </dependency>
   </dependencies>
   ```

---

## Running the Tests

Run all tests via Maven:
```bash
mvn test
```

Or run a specific test class through your IDE (IntelliJ IDEA / Eclipse) by right-clicking `TestsRun.java` and selecting **Run**.

---

## Notes

- Tests are written sequentially and some depend on prior state (e.g. `loginUserAndAddAddressTest` assumes the user was already registered).
- The project uses `WebDriverManager` to automatically manage the ChromeDriver binary.
- Firefox support is available but commented out in `SeleniumHelper.java`.
- Test data (names, email, card info) uses placeholder values suitable for the demo environment only.

---

## Tech Stack

- [Selenium WebDriver](https://www.selenium.dev/) 4.x
- [TestNG](https://testng.org/)
- [WebDriverManager](https://bonigarcia.dev/webdrivermanager/)
- Java 11+
