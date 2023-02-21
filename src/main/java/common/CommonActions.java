package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.internal.Configuration;

import java.time.Duration;
import java.util.logging.Level;

import static common.Config.PLATFORM_AND_BROWSER;
import static pages.base.constants.Constant.TimeoutVariable.IMPLICIT_WAIT;

public class CommonActions {
    @BeforeSuite
    public static WebDriver createDriver () {
        WebDriverManager.chromedriver().setup();
       // DesiredCapabilities capabilities = new DesiredCapabilities()

      /* */ LoggingPreferences preferences = new LoggingPreferences();
        preferences.enable(LogType.PERFORMANCE, Level.ALL);
        preferences.enable(LogType.BROWSER, Level.ALL);

        ChromeOptions option = new ChromeOptions();
        option.setCapability(CapabilityType.LOGGING_PREFS, preferences);
        option.setCapability("goog:loggingPrefs", preferences);
        option.addArguments();
        
        WebDriver driver = null;

        switch (PLATFORM_AND_BROWSER){
            case  "win_chrome" :
                //System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
                driver = new ChromeDriver(option);
                break;
            default:
                Assert.fail("Incorrect platform and browser name: " + PLATFORM_AND_BROWSER);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        return driver;
    }


}
