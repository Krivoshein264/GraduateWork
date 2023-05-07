package chrome.chromePages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
public class SmallBusinessPage {
    private static final By SMALL_BUSINESS_BLOCKS = By.xpath("//div[@class='styled__Cell-sc-1m4bvj-0 fKnhyn']//a[contains(@href, '/malomu-biznesu/')]//div[@class='sc-nFqVA bSLeWO']");
    private static final By SUBMIT_BUTTON = By.xpath("//button[@type='submit']//div[@class='Inner-sc-1rfqasg-0 jviKiO ContentWrapper-sc-48arcs-3 jKrHAG']//div[text()='Отправить заявку']");
    public void blockClick() {
        ElementsCollection allElements = $$(SMALL_BUSINESS_BLOCKS);
        for (SelenideElement selenideElement : allElements) {
            selenideElement.click();
            switchTo().window(HomePage.window);
            HomePage.window = HomePage.window - 1;
            Assertions.assertEquals("Отправить заявку", $(SUBMIT_BUTTON).getText());
            Selenide.closeWindow();
            switchTo().window(HomePage.window);
            HomePage.window= HomePage.window + 1;
        }
    }
}
