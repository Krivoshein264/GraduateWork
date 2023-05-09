package chrome.mobileChromePages;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static chrome.MobileBaseTest.config;
import static chrome.MobileBaseTest.driver;
import static com.codeborne.selenide.Selenide.*;
public class HomePageMobile {
    private static final By CITY_CLICK = By.xpath("//div[@class='Wrapper-sc-1vydk7-0 qtifC sc-clsFYl jvRhgn']");
    private static final By ACCEPT_CITY = By.xpath("//button[@class='Wrapper-sc-48arcs-1 jHfosx']");
    private static final By INDIVIDUALS = By.xpath("//div[text()='Частным лицам']");
    private static final By CREDITS_AND_IPOTEKA = By.xpath("//div[text()='Кредиты и ипотека']");
    private static final By TELEGA = By.xpath("//a[@href=\"https://t.me/mts_bank_official\"]");
    public HomePageMobile openPage() {
        WebDriverRunner.setWebDriver(driver);
        driver.get(config.baseUrl());
        return this;
    }
    public void acceptCity() {
        $(ACCEPT_CITY).click();
        try {
            $(ACCEPT_CITY).click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
        }
    }
    public void citySelection(String city) {
        $(CITY_CLICK).click();
        try {
            $(By.xpath("//ul[@class='sc-dWddBi bxuBnY']//button[text()='" + city + "']")).click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            $(By.xpath("//ul[@class='sc-kYrlTI ffNyOp']//button[text()='" + city + "']")).click();
        }
    }
    public void cityCheck(String city) {
        Assertions.assertEquals(city, $(CITY_CLICK).getText());
    }
    public void individualsOpen() {
        $(TELEGA).hover();
        $(INDIVIDUALS).click();
        $(CREDITS_AND_IPOTEKA).click();
    }
}
