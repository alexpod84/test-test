package pages.ibpage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;


public class IbPage extends BasePage {

    public IbPage (WebDriver driver) {
        super(driver);
    }

    private final By login = By.id("loginInput");
    private final By password = By.id("passInput");

    public IbPage authorization (String s_login,  String s_password) {
        WebElement welogin = driver.findElement(login);
        waitElementIsVisible(welogin).sendKeys(s_login);
        WebElement wepassword = driver.findElement(password);
        waitElementIsVisible(wepassword).sendKeys(s_password , Keys.ENTER);
        return this;
    }
//555

}
