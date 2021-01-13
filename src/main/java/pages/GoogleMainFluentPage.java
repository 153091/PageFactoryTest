package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class GoogleMainFluentPage {

    private WebDriver driver;

    // тип TextInput из библиотеки htmlElements от Яндекс
    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private TextInput searchInput;

    public GoogleMainFluentPage(WebDriver driver) {
        //инициализация
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        this.driver = driver;
    }

    // ввод строки в окошко поиска
    // для fluent стиля добавили возвращение ResultFluentPage (страница на которую мы попадаем)
    public GoogleSearchResultFluentPage search(String searchingText) {
        searchInput.sendKeys(searchingText);
        searchInput.submit();
        return new GoogleSearchResultFluentPage(driver);
    }
}
