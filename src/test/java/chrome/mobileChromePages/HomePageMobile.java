package chrome.mobileChromePages;

import io.qameta.allure.Step;
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
    private static final By MTS_BANK_APP = By.xpath("//div[text()='Установите МТС Банк на смартфон']");
    private static final By CLIENTS_HELP = By.xpath("//div[text()='Помощь клиентам']");
    private static final By SAFETY_REGULATIONS = By.xpath("//div[text()='Правила безопасности']");
    @Step("Открыть домашнюю страницу")
    public HomePageMobile openPage() {
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
    @Step("Нажать на город и в появившемся списке выбрать новый")
    public void citySelection(String city) {
        $(CITY_CLICK).click();
        try {
            $(By.xpath("//ul[@class='sc-dWddBi bxuBnY']//button[text()='" + city + "']")).hover().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            $(By.xpath("//ul[@class='sc-kYrlTI ffNyOp']//button[text()='" + city + "']")).hover().click();
        }
    }
    @Step("Проверить что на главной странице отображается выбранный город")
    public void cityCheck(String city) {
        Assertions.assertEquals(city, $(CITY_CLICK).getText());
    }
    @Step("Внизу страницы раскрыть список 'Частным лицам' и выбрать 'Кредиты и ипотека'")
    public void individualsOpen() {
        $(MTS_BANK_APP).hover();
        $(INDIVIDUALS).click();
        $(CREDITS_AND_IPOTEKA).click();
    }
    @Step("Внизу страницы раскрыть список 'Помощь клиентам' и выбрать 'Правила безопасности'")
    public void securityOpen() {
        $(MTS_BANK_APP).hover();
        $(CLIENTS_HELP).click();
        $(MTS_BANK_APP).hover();
        $(SAFETY_REGULATIONS).click();
    }
}
