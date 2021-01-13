package pages;

import elements.SearchResultBox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleSearchResultFluentPage {

    // список элементов SearchResultBox на нашей поисковой странице
    @FindBy(xpath = "//div[@class='rc']")
    List<SearchResultBox> searchResultBoxList;



    public GoogleSearchResultFluentPage(WebDriver driver) {
        //инициализация
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    // проверка результатов
    // для Fluent стиля добавляем возвращение этой же страницы
    public GoogleSearchResultFluentPage checkFirstSearchResult(String expectedLabel, String expectedUrl) {
        SearchResultBox firstSearchResultBox = searchResultBoxList.get(0);
        String actualLabel = firstSearchResultBox.getLabel();
        String actualUrl = firstSearchResultBox.getUrl();

        // если где-то будет false - то выдаст сообщение
        // но все остальные утверждения всеравно будут проверены
        assertAll("Ожидаемый результат поиска не соответствует действительному",
                () -> assertEquals(expectedLabel, actualLabel),
                () -> assertEquals(expectedUrl, actualUrl));
        // возвращаем экземпляр данной страницы для соблюдения fluent стиля
        return this;
    }

    public GoogleSearchResultFluentPage printFirstSearchResult() {
        SearchResultBox firstSearchResultBox = searchResultBoxList.get(0);
        System.out.println(firstSearchResultBox.getUrl());
        System.out.println(firstSearchResultBox.getLabel());
        // возвращаем экземпляр данной страницы для соблюдения fluent стиля
        return this;
    }
}
