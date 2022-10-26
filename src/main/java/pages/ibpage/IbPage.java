package pages.ibpage;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import pages.base.BasePage;


public class IbPage extends BasePage {

    public IbPage (WebDriver driver) {
        super(driver);
    }

    private final By login = By.id("loginInput");
    private final By password = By.id("passInput");

    @Step("Авторизация")
    public IbPage authorization (String s_login,  String s_password) {
        try {
            WebElement welogin = driver.findElement(login);
            waitElementIsVisible(welogin).sendKeys(s_login);
            WebElement wepassword = driver.findElement(password);
            waitElementIsVisible(wepassword).sendKeys(s_password, Keys.ENTER);
        }
        catch (NoSuchElementException e)
        {
           // driver.quit();
            System.out.println("Errrrrrrr! "+ e.toString());
        }
        return this;
    }


}
