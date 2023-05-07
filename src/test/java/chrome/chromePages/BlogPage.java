package chrome.chromePages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
public class BlogPage {
private static final By PARAM_BLOG = By.xpath("//a[@class='LinkWrapper-sc-a7l7fm-0 eaxjcO sc-jSgvzq itKQXv']");
    static int window = 1;
    public static void productClick(String product) {
        switchTo().window(window);
        $(By.xpath("//div[text()='" + product +"']")).click();
        window++;
    }
    public static void checkParameter(String product) {
        ElementsCollection allElements = $$(PARAM_BLOG);
        for (SelenideElement selenideElement : allElements) {
            Assertions.assertEquals(product, $(selenideElement).getText());
        }
    }
}
