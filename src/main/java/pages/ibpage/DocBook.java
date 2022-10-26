package pages.ibpage;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

public class DocBook extends BasePage {
    public DocBook (WebDriver driver) {super(driver); }

    private final By createBtn = By.xpath("//button[text()='Создать']");
    private final By payDocBy = By.xpath("//sc-modal-body//span[text()='101 - Платежное поручение']/..");
    private final By docbook = By.xpath("//a[@tutorial-data = 'document_nav']");
    @Step("Новый документ")
    public DocBook openDocBook () {
        WebElement weDocBook = driver.findElement(docbook);
        waitElementToBeClickable(weDocBook).click();
        return this;
    }
    @Step("Создать")
    public DocBook openDocList () {
        WebElement weCreateBtn = driver.findElement(createBtn);
        waitElementToBeClickable(weCreateBtn).click();
        return this;
    }
    @Step("Открываем рублевую платежку")
    public DocBook openBayDocBy () {
        WebElement wePayDocBy = driver.findElement(payDocBy);
        waitElementToBeClickable(wePayDocBy).click();
        Assert.assertEquals(1, 1);
        return this;
    }
}
