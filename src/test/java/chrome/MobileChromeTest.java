package chrome;

import chrome.mobileChromePages.CreditsPageMobile;
import chrome.mobileChromePages.HomePageMobile;
import chrome.mobileChromePages.IpotekaPageMobile;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
public class MobileChromeTest extends MobileBaseTest {
    HomePageMobile homePageMobile = new HomePageMobile();
    CreditsPageMobile creditsPageMobile = new CreditsPageMobile();
    IpotekaPageMobile ipotekaPageMobile = new IpotekaPageMobile();
    @Description("Проверка что при смене города на главной странице будет отображаться новый город")
    @DisplayName("Проверка отображения нового города при смене")
    @ParameterizedTest
    @ValueSource(strings = {"Амурск"})
    public void citySelection(String city) {
        homePageMobile.openPage().citySelection(city);
        homePageMobile.cityCheck(city);
    }
    @Test
    @Description("Проверка что в разделе Ипотека/Программы/Ипотека для ИТ в калькуляторе по умолчанию отображается ставка 5%")
    @DisplayName("Проверка процентной ставки по умолчанию в Ипотеке для IT")
    public void ipotekaValue() {
        homePageMobile.openPage().acceptCity();
        homePageMobile.individualsOpen();
        creditsPageMobile.ipotekaForIT();
        ipotekaPageMobile.valueCheck();
    }
}
