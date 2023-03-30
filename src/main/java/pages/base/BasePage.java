package pages.base;

//import com.sun.jdi.request.DuplicateRequestException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.logging.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

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

    public WebElement findByXpath(String xpath, Duration duration){
        return driver.findElement(waitElementIsVisible(By.xpath(xpath), duration.getSeconds()));

    }

    public By waitElementIsVisible(By findStategy, long timeInOutSeconds){
        getWaiter(timeInOutSeconds).until(visibilityOfElementLocated(findStategy));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return findStategy;
    }

    private WebDriverWait getWaiter(long timeInOutSeconds){
        WebDriverWait webDriverWait =  new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        webDriverWait.ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class);
        return webDriverWait;
    }

    public WebElement waitElementToBeClickable(WebElement element){
       WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
       webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return element;
    }

    public void driverPause (Integer t){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(t));
    }
}
