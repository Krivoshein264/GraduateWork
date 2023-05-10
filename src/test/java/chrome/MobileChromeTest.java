package chrome;

import chrome.mobileChromePages.CreditsPageMobile;
import chrome.mobileChromePages.HomePageMobile;
import chrome.mobileChromePages.IpotekaPageMobile;
import chrome.mobileChromePages.SafetyRegulationsPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.FileNotFoundException;

public class MobileChromeTest extends MobileBaseTest {
    HomePageMobile homePageMobile = new HomePageMobile();
    CreditsPageMobile creditsPageMobile = new CreditsPageMobile();
    IpotekaPageMobile ipotekaPageMobile = new IpotekaPageMobile();
    SafetyRegulationsPage safetyRegulationsPage = new SafetyRegulationsPage();
    @Description("Проверка что при смене города на главной странице будет отображаться новый город")
    @DisplayName("Проверка отображения нового города при смене")
    @ParameterizedTest
    @ValueSource(strings = {"Амурск", "Ванино"})
    public void citySelection(String city) {
        homePageMobile.openPage().citySelection(city);
        homePageMobile.cityCheck(city);
    }
    @Test
    @Description("Проверка что в разделе Ипотека/Программы/Ипотека для ИТ в калькуляторе по умолчанию отображается ставка 5%")
    @DisplayName("Проверка процентной ставки по умолчанию в Ипотеке для IT")
    public void ipotekaValue() {
        homePageMobile.openPage();
        homePageMobile.individualsOpen();
        creditsPageMobile.ipotekaOpen();
        ipotekaPageMobile.valueCheck();
    }
    @Test
    @Description("Проверка что в разделе Ипотека в калькуляторе при выборе Рефинансирования в цели кредита появляется чекбокс Зарплатный клиент ПАО «МТС-Банк»")
    @DisplayName("Проверка появления чекбокса Зарплатный клиент при выборе Рефинансирования в калькуляторе Ипотеки")
    public void checkBoxTest() {
        homePageMobile.openPage();
        homePageMobile.individualsOpen();
        creditsPageMobile.ipotekaOpen();
        ipotekaPageMobile.checkBoxCheck();
    }
    @Test
    @Description("Проверка что в разделе Ипотека во вкладке Погашение кредита в блоке Выберете способы погашения файл Инструкция.PDF скачивается, в данном случае build/downloads ")
    @DisplayName("Проверка скачивания файла Инструкция.PDF")
    public void downloadPDF() throws FileNotFoundException {
        homePageMobile.openPage();
        homePageMobile.individualsOpen();
        creditsPageMobile.ipotekaOpen();
        ipotekaPageMobile.downloadFile();
    }
    @Test
    @Description("Проверка что при прохождении теста 'Обмани мошенника' в разделе Правила безопасности в конце он выдает правильное кол-во правильных ответов Результат 4/4")
    @DisplayName("Проверка теста 'Обмани мошенника'")
    public void securityTestTest() {
        homePageMobile.openPage();
        homePageMobile.securityOpen();
        safetyRegulationsPage.testCheck();
        safetyRegulationsPage.resultCheck();
    }
}
