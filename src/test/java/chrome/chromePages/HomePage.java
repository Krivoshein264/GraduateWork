package chrome.chromePages;

import org.openqa.selenium.By;
import static chrome.BaseTest.config;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {
    private static final By SERVICES = By.xpath("//div[text()='Сервисы и услуги']");
    private static final By SERVICES_CARDS_AND_CREDITS = By.xpath("//a[text()='Пополнение карт и погашение кредитов']");
    private static final By BLOG = By.xpath("//a[@href='https://www.mtsbank.ru/articles/']/div/h2");
    public HomePage openPage() {

        open(config.baseUrl());
        return this;
    }
    public void servicesCardsAndCredits() {
        $(SERVICES).hover();
        $(SERVICES_CARDS_AND_CREDITS).click();
    }
    public void blog() {
        $(BLOG).click();

    }
}
