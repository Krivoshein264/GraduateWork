package chrome.mobileChromePages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
public class SafetyRegulationsPage {
    private static final By FIRST_CORRECT_ANSWER = By.xpath("//label[@for='quiz-1-3']");
    private static final By SECOND_CORRECT_ANSWER = By.xpath("//label[@for='quiz-2-3']");
    private static final By THIRD_CORRECT_ANSWER = By.xpath("//label[@for='quiz-3-2']");
    private static final By FOURTH_CORRECT_ANSWER = By.xpath("//label[@for='quiz-4-2']");
    private static final By BUTTON_NEXT = By.xpath("//button[@class='slide__btn quiz__btn'][1]");
    private static final By BUTTON_NEXT2 = By.xpath("//button[@data-parent-fieldset='quiz-2']");
    private static final By BUTTON_NEXT3 = By.xpath("//button[@data-parent-fieldset='quiz-3']");
    private static final By BUTTON_NEXT4 = By.xpath("//button[@data-result-filedset='quiz-final']");
    private static final By RESULT = By.xpath("//h5[text()='Результат 4/4 ']");
    String result = "Результат 4/4";
    public void testCheck() {
        $(FIRST_CORRECT_ANSWER).click();
        $(BUTTON_NEXT).click();
        $(SECOND_CORRECT_ANSWER).click();
        $(BUTTON_NEXT2).click();
        $(THIRD_CORRECT_ANSWER).click();
        $(BUTTON_NEXT3).click();
        $(FOURTH_CORRECT_ANSWER).click();
        $(BUTTON_NEXT4).click();
    }
    public void resultCheck() {
        Assertions.assertEquals(result, $(RESULT).getText());
    }
}
