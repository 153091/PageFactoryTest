import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
    private WebDriver driver;

    @BeforeAll
    public static void checkBrowserShim() {
        System.setProperty("webdriver.chrome.driver", "/Users/user1234/Downloads/chromedriver");
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://google.com");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Disabled
    @Test
    public void simpleTest() {
        String xpath = "//input[@class='gLFyf gsfi']";
        WebElement inputElement = driver.findElement(By.xpath(xpath));
        inputElement.sendKeys("Сбербанк");
        inputElement.submit();
    }
}
