package chrome.chromePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepaymentService {
private static final By ADDRESSES_BUTTON = By.xpath("//div[text()='Адреса']");
String link = "https://www.mtsbank.ru/ofisi-i-bankomati/";
public RepaymentService checkingAddresses() {
    ElementsCollection allElements = $$(ADDRESSES_BUTTON);

    for (SelenideElement selenideElement : allElements) {
        Assertions.assertEquals(link, $(selenideElement).parent().parent().parent().attr("href"));
    }
    return this;
    }
}
