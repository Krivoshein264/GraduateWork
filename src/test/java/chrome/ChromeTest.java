package chrome;

import chrome.chromePages.HomePage;
import chrome.chromePages.RepaymentService;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class ChromeTest extends BaseTest {
    @Test()
    @Description("Проверка что кнопка Адреса ведет по ссылке на карту")
    @DisplayName("Проверка ссылки кнопки адрес")
    public void addressTest() {
        HomePage homePage = new HomePage();
        RepaymentService repaymentService = new RepaymentService();
        homePage.openPage()
                .servicesCardsAndCredits();
        repaymentService.checkingAddresses();

    }
}
