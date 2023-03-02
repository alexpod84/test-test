package pages.base;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.logging.*;


import java.time.Duration;

//import static pages.base.constants.Constant.TimeoutVariable.EXPLICIT_WAIT;
import static common.Config.EXPLICIT_WAIT;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);


    }

    public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(element));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return element;
    }

    public WebElement waitElementToBeClickable(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public void driverPause (Integer t){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(t));
    }
}
