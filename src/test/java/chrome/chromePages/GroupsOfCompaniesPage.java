package chrome.chromePages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
public class GroupsOfCompaniesPage {
    private static final By CLOSED_ELEMENT = By.xpath("//div[@class='Wrapper-sc-zhf5t7-0 jMaoHR']");
    private static final By OPENED_ELEMENT = By.xpath("//div[@class='Wrapper-sc-1vydk7-0 qtifC CollapseText-sc-zhf5t7-6 iwMmBd']");
    public void checkOpen() {
        ElementsCollection allElements = $$(CLOSED_ELEMENT);
        for (SelenideElement selenideElement : allElements) {
            selenideElement.click();
            $(OPENED_ELEMENT).click();
            selenideElement.click();
        }
    }
}
