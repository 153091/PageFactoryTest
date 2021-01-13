import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleMainPage;
import pages.GoogleSearchResultPage;

/**
 * запускать mvn clean test
 * */
public class GooglePageFactoryTest {
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
    public void pageFactoryTest() {
        GoogleMainPage googleMainPage = new GoogleMainPage(driver);
        googleMainPage.search("Сбербанк");

        // теперь у нас открылась страница с результатами
        // создаем её, передавая драйвер
        GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage(driver);
        googleSearchResultPage.checkFirstSearchResult("Частным клиентам — СберБанк - SberBank", "www.sberbank.ru › person");
    }
}
