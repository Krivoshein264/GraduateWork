package chrome.chromePages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static chrome.BaseTest.config;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class HomePage {
    private static final By SERVICES = By.xpath("//div[text()='Сервисы и услуги']");
    private static final By SERVICES_CARDS_AND_CREDITS = By.xpath("//a[text()='Пополнение карт и погашение кредитов']");
    private static final By BLOG = By.xpath("//a[@href='https://www.mtsbank.ru/articles/']/div/h2");
    private static final By SMALL_BUSINESS = By.xpath("//a[@href='/malomu-biznesu/']");
    private static final By CORPORATE_BUSINESS = By.xpath("//a[@href='/korporativnim-klientam/']");
    @Step("Открыть главную страницу")
    public HomePage openPage() {
        open(config.baseUrl());
        return this;
    }
    @Step("Навести на сервисы и услуги, перейти в Пополнение карт и погашение кредитов")
    public void servicesCardsAndCredits() {
        $(SERVICES).hover();
        $(SERVICES_CARDS_AND_CREDITS).click();
    }
    @Step("Перейти в блог")
    public void blog() {
        $(BLOG).click();
    }
    @Step("Нажать 'Малый бизнес и ИП'")
    public void smallBusinessClick() {
        $(SMALL_BUSINESS).click();
    }
    @Step("Нажать 'Корпоративный бизнес'")
    public void corporateBusinessOpen() {
        $(CORPORATE_BUSINESS).click();
    }
}
