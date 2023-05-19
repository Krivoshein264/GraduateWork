package chrome.chromePages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
public class BlogPage {
private static final By PARAM_BLOG = By.xpath("//a[@class='LinkWrapper-sc-a7l7fm-0 eaxjcO sc-jSgvzq itKQXv']");
    @Step("Вместо 'Все' выбрать необходимый продукт")
    public static void productClick(String product) {
        switchTo().window(1);
        $(By.xpath("//div[text()='" + product +"']")).click();
    }
    @Step("Проверить что отобразившиеся элементы относятся только к выбранному продукту - проверить соответствие подписи в элементах и названия выбранного продукта")
    public static void checkParameter(String product) {
        ElementsCollection allElements = $$(PARAM_BLOG);
        for (SelenideElement selenideElement : allElements) {
            Assertions.assertEquals(product, $(selenideElement).getText());
        }
        Selenide.closeWindow();
        switchTo().window(0);
    }
}
