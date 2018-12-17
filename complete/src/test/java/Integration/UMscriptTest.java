package Integration;


        import java.util.regex.Pattern;
        import java.util.concurrent.TimeUnit;

        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.openqa.selenium.firefox.FirefoxOptions;
        import org.openqa.selenium.htmlunit.HtmlUnitDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.annotations.*;
        import static org.testng.Assert.*;
        import org.openqa.selenium.*;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.support.ui.Select;

public class UMscriptTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless","--no-sandbox","--disable-dev-shm-usage");
        driver = new FirefoxDriver(options);

        //driver = new HtmlUnitDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        System.out.println("********************");
        System.out.println("*   Begin Testing Katalon");
        System.out.println("********************");

        driver.get("http://esbapp-sum-0001:8080/Fractals/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.id("modal_auth_input_user")));
        driver.findElement(By.id("modal_auth_input_user")).clear();
        driver.findElement(By.id("modal_auth_input_user")).sendKeys("um");
        driver.findElement(By.id("modal_auth_input_pass")).click();
        driver.findElement(By.id("modal_auth_input_pass")).clear();
        driver.findElement(By.id("modal_auth_input_pass")).sendKeys("um");

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Conversations'])[1]/following::span[1]")));

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Conversations'])[1]/following::span[1]")).click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Profile'])[1]/following::span[1]")));
        //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Profile'])[1]/following::span[1]")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}