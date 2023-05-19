package chrome.chromePages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static chrome.BaseTest.config;
public class DepozitPage {
    private static final By INPUT_PHONE = By.xpath("//input[@name='phone']");
    private static final By INPUT_CITY = By.xpath("//input[@placeholder='Выберите из списка']");
    private static final By FIRST_IN_LIST = By.xpath("//li[@id='react-autowhatever-1--item-0']");
    private static final By OFFICE = By.xpath("//div[@label='Офис обслуживания']");
    private static final By CHECK_ERROR = By.xpath("//div[text()='Для обработки вашей заявки вы должны согласиться с условиями']");
    private static final By SUBMIT_BUTTON = By.xpath("//button[@type='submit']//div[@class='Inner-sc-1rfqasg-0 jviKiO ContentWrapper-sc-48arcs-3 jKrHAG']//div[text()='Отправить заявку']");
    String error = "Для обработки вашей заявки вы должны согласиться с условиями";
    String city = "Томск";
    @Step("Заполнить форму 'Заявка на депозит для бизнеса'")
    public void dataInput() {
        $(INPUT_PHONE).sendKeys(config.phone());
        $(INPUT_CITY).doubleClick();
        $(INPUT_CITY).sendKeys(city);
        $(FIRST_IN_LIST).click();
        $(OFFICE).click();
        $(FIRST_IN_LIST).click();
    }
    @Step("Нажать 'Отправить заявку' и проверить наличие ошибки 'Для обработки вашей заявки вы должны согласиться с условиями'")
    public void checkError() {
        $(SUBMIT_BUTTON).click();
        Assertions.assertEquals(error, $(CHECK_ERROR).getText());
    }
}
