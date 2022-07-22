package pages.ibpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

public class DocBook extends BasePage {
    public DocBook (WebDriver driver) {super(driver); }

    private final By createBtn = By.xpath("//button[text()='Создать']");
    private final By payDocBy = By.xpath(" //sc-modal[8]/div/sc-modal-body/div/div[1]/div[2]");
    private final By docbook = By.xpath("//a[@tutorial-data = 'document_nav']");
    public DocBook openDocBook () {
        WebElement weDocBook = driver.findElement(docbook);
        waitElementToBeClickable(weDocBook).click();
        return this;
    }
    public DocBook openDocList () {
        WebElement weCreateBtn = driver.findElement(createBtn);
        waitElementToBeClickable(weCreateBtn).click();
        return this;
    }
    public DocBook openBayDocBy () {
        WebElement wePayDocBy = driver.findElement(payDocBy);
        waitElementToBeClickable(wePayDocBy).click();
      //  Assert.assertEquals(1, 1);
        return this;
    }
}
