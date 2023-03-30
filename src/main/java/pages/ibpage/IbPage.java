package pages.ibpage;

import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import pages.base.BasePage;

import java.time.Duration;
import static common.Config.EXPLICIT_WAIT;

public class IbPage extends BasePage {

    public IbPage (WebDriver driver) {
        super(driver);
    }

    private final String login = ".//*[@id='loginInput']";
    private final String password = " .//*[@id='passInput']";
    private final String button = ".//button[contains(text(), 'Войти')]";
   // private final By password = By.id("passInput");

    @Step("Авторизация")
    public IbPage authorization (String s_login,  String s_password) {
        try {
          //  WebElement welogin = driver.findElement(login);
            findByXpath(login, Duration.ofSeconds(EXPLICIT_WAIT)).sendKeys(s_login);
            findByXpath(password, Duration.ofSeconds(EXPLICIT_WAIT)).sendKeys(s_password);
            findByXpath(button, Duration.ofSeconds(EXPLICIT_WAIT)).click();
           // WebElement wepassword = driver.findElement(password);
         //   waitElementIsVisible(wepassword).sendKeys(s_password, Keys.ENTER);

            LogEntries logs = driver.manage().logs().get(LogType.PERFORMANCE);

            for (LogEntry entry : logs) {
                if(entry.toString().contains("\"type\":\"XHR\"")) {
                    JSONParser parser = new JSONParser();
                    JSONObject jsonObject = null;

                    try {
                        jsonObject = (JSONObject) parser.parse(entry.getMessage());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    JSONObject messageObject = (JSONObject) jsonObject.get("message");
                    System.out.println(messageObject.toJSONString());
                    // You can do the required processing to messageObject
                }
            }
        }
        catch (NoSuchElementException e)
        {
           // driver.quit();
            System.out.println("Errrrrrrr! "+ e.toString());
        }
        return this;
    }


}
