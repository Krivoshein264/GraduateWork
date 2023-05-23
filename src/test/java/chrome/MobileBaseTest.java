package chrome;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public abstract class MobileBaseTest  {
    public static final ProjectConfig config = ConfigFactory.create(ProjectConfig.class);
    public static WebDriver driver;
    @BeforeAll
    public static void setUp() {
        System.clearProperty("chromeOptions");
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone 8");
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(chromeOptions);
        WebDriverRunner.setWebDriver(driver);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @AfterAll
    public static void turnDown() {
        /*
        System.clearProperty("chromeoptions.mobileEmulation");
        System.clearProperty("chromeOptions");
        driver.manage().deleteAllCookies();*/
        driver.quit();
        System.clearProperty("mobileEmulation");
    }
}
