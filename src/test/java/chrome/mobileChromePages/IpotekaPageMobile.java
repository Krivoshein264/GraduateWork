package chrome.mobileChromePages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class IpotekaPageMobile {
    private static final By PRICE_HOME_GET = By.xpath("//*[@id='form']/div[2]/form/div[2]/div[2]/div[1]/div[1]/div[2]/h4");
    private static final By PROGRAMS = By.xpath("//div[text()='Программы']");
    private static final By IPOTEKA_FOR_IT = By.xpath("//div[text()='Ипотека для IT']");
    private static final By LIST_CLICK = By.xpath("//input[@value='Купить недвижимость']");
    private static final By REFINANCE = By.xpath("//div[text()='Рефинансирование кредита']");
    private static final By CHECK_BOX = By.xpath("//div[text()='Зарплатный клиент ПАО «МТС-Банк» или сотрудник группы компаний ПАО АФК «Система»']");
    String sum = "5 %";
    public void valueCheck() {
        $(PROGRAMS).click();
        $(IPOTEKA_FOR_IT).click();
        Assertions.assertEquals(sum, $(PRICE_HOME_GET).getText());
    }
    public void checkBoxCheck() {
        $(LIST_CLICK).click();
        $(REFINANCE).click();
        $(CHECK_BOX).hover();

    }

}
