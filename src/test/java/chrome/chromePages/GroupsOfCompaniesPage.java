package chrome.chromePages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
public class GroupsOfCompaniesPage {
    private static final By CLOSED_ELEMENT = By.xpath("//div[@class='Wrapper-sc-zhf5t7-0 jMaoHR']");
    private static final By OPENED_ELEMENT = By.xpath("//div[@class='Wrapper-sc-1vydk7-0 qtifC CollapseText-sc-zhf5t7-6 iwMmBd']");
    @Step("Проверить что каждый элемент в 'Список услуг' раскрывается при нажатии и заполнен")
    public void checkOpen() {
        ElementsCollection allElements = $$(CLOSED_ELEMENT);
        for (SelenideElement selenideElement : allElements) {
            selenideElement.click();
            $(OPENED_ELEMENT).click();
            selenideElement.click();
        }
    }
}
