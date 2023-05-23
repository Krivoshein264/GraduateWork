package chrome.mobileChromePages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$;

public class IpotekaPageMobile {
    private static final By PRICE_HOME_GET = By.xpath("//h4[text()=' %']");
    private static final By PROGRAMS = By.xpath("//div[text()='Программы']");
    private static final By IPOTEKA_FOR_IT = By.xpath("//div[text()='Ипотека для IT']");
    private static final By LIST_CLICK = By.xpath("//input[@value='Купить недвижимость']");
    private static final By REFINANCE = By.xpath("//div[text()='Рефинансирование кредита']");
    private static final By CHECK_BOX = By.xpath("//div[text()='Зарплатный клиент ПАО «МТС-Банк» или сотрудник группы компаний ПАО АФК «Система»']");
    private static final By CREDIT_REPAYMENT = By.xpath("//button//div[text()='Погашение кредита']");
    private static final By PDF_FILE = By.xpath("//*[@id='__next']/div[3]/div[1]/div/div/div[3]/div[3]/div[3]/div[2]/div[2]/div/div/div/div[2]/div[1]/div[1]/a");
    String sum = "5 %";
    @Step("Нажать 'Программы', затем 'Ипотека для IT' и проверить что ставка равна '5 %'")
    public void valueCheck() {
        $(PROGRAMS).click();
        $(IPOTEKA_FOR_IT).click();
        Assertions.assertEquals(sum, $(PRICE_HOME_GET).getText());
    }
    @Step("Выбрать 'Цель кредита' - 'Рефинансирование кредита' и проверить что появился чекбокс 'Зарплатный клиент ПАО «МТС-Банк»'")
    public void checkBoxCheck() {
        $(LIST_CLICK).click();
        $(REFINANCE).click();
        $(CHECK_BOX).hover();
    }
    @Step("Выбрать 'Погашение кредита' и нажать 'Инструкция.PDF' для скачивания")
    public void downloadFile() throws FileNotFoundException {
        $(CREDIT_REPAYMENT).click();
        File report = $(PDF_FILE).download();
    }

}
