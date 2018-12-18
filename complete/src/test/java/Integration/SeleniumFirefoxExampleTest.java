package Integration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SeleniumFirefoxExampleTest {
    @Test
    public static void testCallCheese() throws InterruptedException {
        System.out.println("********************");
        System.out.println("*   Begin Testing Firefox");
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.

        System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
        System.out.println("*   "+System.getProperty("webdriver.gecko.driver"));
        System.out.println("********************");

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless","--no-sandbox","--disable-dev-shm-usage");

        WebDriver driver = new FirefoxDriver(options);

        //WebDriver driver = new HtmlUnitDriver();
        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("********************");
        System.out.println("*   Page title is: " + driver.getTitle());
        System.out.println("********************");

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("********************");
        System.out.println("*   Page title is: " + driver.getTitle());
        System.out.println("********************");

        Thread.sleep(2000);
        //Close the browser
        driver.close();
        System.out.println("********************");
        System.out.println("*   End Testing Firefox");
        System.out.println("********************");
        System.out.println();
        System.out.println();
    }
}
