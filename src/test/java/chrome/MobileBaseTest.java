package chrome;

import config.ProjectConfig;
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
    static ChromeOptions chromeOptions;
    @BeforeAll
    public static void setUp() {
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone 8");
        chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(chromeOptions);
    }
    @AfterAll
    public static void turnDown() {
        driver.quit();
    }
}
