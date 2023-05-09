package chrome.mobileChromePages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
public class CreditsPageMobile {
    private static final By IPOTEKA = By.xpath("//a[@href='/chastnim-licam/ipoteka/']//div[@data-testid='flexbox']");
    public void ipotekaOpen() {
        $(IPOTEKA).click();
    }
}
