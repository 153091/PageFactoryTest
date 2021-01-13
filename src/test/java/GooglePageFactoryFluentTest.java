import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleMainFluentPage;
import pages.GoogleMainPage;
import pages.GoogleSearchResultPage;

/**
 * запускать mvn clean test
 * */
public class GooglePageFactoryFluentTest {
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

    @Test
    public void pageFactoryFluentTest() {
        new GoogleMainFluentPage(driver)
                .search("Сбербанк")
                .checkFirstSearchResult("Частным клиентам — СберБанк - SberBank", "www.sberbank.ru › person")
                .printFirstSearchResult();
    }
}
