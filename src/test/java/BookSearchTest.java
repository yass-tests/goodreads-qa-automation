import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BookSearchTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Set the path to your chromedriver executable if needed
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.goodreads.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void bookSearchTest() {

        // Wait for the search box and type book name
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sitesearch_field")));
        searchBox.sendKeys("To Kill a Mockingbird");
        searchBox.submit();


        // Wait for page title to confirm search results loaded
        wait.until(ExpectedConditions.titleContains("To Kill a Mockingbird"));

        // Assert the page title contains the searched book name
        String title = driver.getTitle();
        Assert.assertTrue(title.toLowerCase().contains("to kill a mockingbird"), "Title does not contain search term.");

        // Assert at least one search result is visible
        WebElement firstResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bookTitle")));
        Assert.assertTrue(firstResult.isDisplayed(), "No book results found.");
    }


        @AfterClass
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
}
