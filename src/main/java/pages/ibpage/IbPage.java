package pages.ibpage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;


public class IbPage extends BasePage {

    public IbPage (WebDriver driver) {
        super(driver);
    }

    private final By login = By.id("loginInput");
    private final By password = By.id("passInput");
    private final By docbook = By.xpath("//a[@tutorial-data = 'document_nav']");

    public IbPage authorization (String s_login,  String s_password) {
        driver.findElement(login).sendKeys(s_login);
        driver.findElement(password).sendKeys(s_password, Keys.ENTER);
        return this;
    }

    public IbPage openDocBook () {
        driver.findElement(docbook).click();
        return this;
    }
}
