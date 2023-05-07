package chrome;

import chrome.chromePages.BlogPage;
import chrome.chromePages.HomePage;
import chrome.chromePages.RepaymentService;
import chrome.chromePages.SmallBusinessPage;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ChromeTest extends BaseTest {
    HomePage homePage = new HomePage();
    RepaymentService repaymentService = new RepaymentService();
    SmallBusinessPage smallBusinessPage = new SmallBusinessPage();
    @Test()
    @Description("Проверка что кнопка Адреса ведет по ссылке на карту")
    @DisplayName("Проверка ссылки кнопки адрес")
    public void addressTest() {
        homePage.openPage()
                .servicesCardsAndCredits();
        repaymentService.checkingAddresses();
    }
    @Description("Зайти в Блог, проверить что в Блог: 'Продукт' только блоки с подписью 'Продукт'")
    @DisplayName("Проверка соответствия подписи в блоках продукта в разделе 'Блог'")
    @ParameterizedTest
    @ValueSource(strings = { "Кредитование", "Кредитные карты", "Дебетовые карты", "Вклады и счета", "Ипотека", "Бизнес" })
    public void blogTest(String product) {
        homePage.openPage()
                .blog();
        BlogPage.productClick(product);
        BlogPage.checkParameter(product);
    }
    @Test()
    @Description("Проверка что в каждом из блоков, часть ссылок которых содержит /malomu-biznesu/ в разделе 'Малый бизнес и ИП', есть поля для оформления заявки с кнопкой 'Отправить заявку'")
    @DisplayName("Проверка кнопки 'Отправить заявку' в блоках ссылка которых содержит /malomu-biznesu/")
    public void smallBusinessTest() {
        homePage.openPage()
                .smallBusinessClick();
        smallBusinessPage.blockClick();
    }
}
