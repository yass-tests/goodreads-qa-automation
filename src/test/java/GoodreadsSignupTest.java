import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoodreadsSignupTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Initialize ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void testSignUpForm() {
        // Open Goodreads homepage
        driver.get("https://www.goodreads.com/");

        // Wait for and click the "Sign up with email" link
        WebElement signUpLink = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign up with email"))
        );
        signUpLink.click();

        // Wait for the signup form to appear
        WebElement nameInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("ap_customer_name"))
        );
        WebElement emailInput = driver.findElement(By.id("ap_email"));
        WebElement passwordInput = driver.findElement(By.id("ap_password"));

        // Fill in the form
        nameInput.sendKeys("Test User");
        emailInput.sendKeys("testuser" + System.currentTimeMillis() + "@example.com");
        passwordInput.sendKeys("TestPassword123");

        // Re-enter password (Amazon requires it)
        WebElement rePasswordInput = driver.findElement(By.id("ap_password_check"));
        rePasswordInput.sendKeys("TestPassword123");

        // Click Create Account button
        WebElement createAccountButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("continue"))
        );
        createAccountButton.click();

        // (Optional) Wait for the next page
        System.out.println("Signup form submitted.");
    }
    @Test
    public void testContinueWithAmazon() {
        driver.get("https://www.goodreads.com/");

        // Click "Continue with Amazon"
        WebElement amazonButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("a.gr-button--amazon"))
        );
        amazonButton.click();

        // Verify redirect to Amazon login page
        wait.until(ExpectedConditions.urlContains("amazon.com"));
        System.out.println("Redirected to Amazon login page.");
    }
    @Test
    public void testContinueWithApple() {
        driver.get("https://www.goodreads.com/");

        // Click "Continue with Apple"
        WebElement appleButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='apple.com']"))
        );
        appleButton.click();

        // Verify redirect to Apple login page
        wait.until(ExpectedConditions.urlContains("apple.com"));
        System.out.println("Redirected to Apple login page.");
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
