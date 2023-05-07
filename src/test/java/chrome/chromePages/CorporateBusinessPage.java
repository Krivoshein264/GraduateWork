package chrome.chromePages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
public class CorporateBusinessPage {
    private static final By CASH_SERVICE = By.xpath("//a[text()='Расчетно-кассовое обслуживание'][1]");
    private static final By GROUPS_OF_COMPANIES = By.xpath("//a[@href='/korporativnim-klientam/raschetno-kassovoye-obsluzhivaniye/gruppam-companiy/']");
    public void groupsOfCompaniesClick() {
        $(CASH_SERVICE).hover();
        $(GROUPS_OF_COMPANIES).click();
    }
}
