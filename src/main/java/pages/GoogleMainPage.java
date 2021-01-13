package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class GoogleMainPage {

    // тип TextInput из библиотеки htmlElements от Яндекс
    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private TextInput searchInput;

    public GoogleMainPage(WebDriver driver) {
        //инициализация
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    // ввод строки в окошко поиска
    public void search(String searchingText) {
        searchInput.sendKeys(searchingText);
        searchInput.submit();
    }
}
