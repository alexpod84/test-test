package pages.ibpage;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

import java.time.Duration;

import static common.Config.EXPLICIT_WAIT;

public class DocBook extends BasePage {
    public DocBook (WebDriver driver) {super(driver); }

    private final String createBtn = "//button[text()='Создать']";
    private final String payDocBy = "//sc-modal-body//span[text()='101 - Платежное поручение']/..";
    private final String docbook = "//a[@tutorial-data = 'document_nav']";
    @Step("Новый документ")
    public DocBook openDocBook ()  throws InterruptedException {
        try{
            findByXpath(docbook, Duration.ofSeconds(EXPLICIT_WAIT)).click();
       // WebElement weDocBook = driver.findElement(docbook);
       // waitElementToBeClickable(weDocBook).click();
        }
        catch (NoSuchElementException e)
        {
            Assert.fail("Ошибка нахождения элемента : " + e.toString());
        }
        return this;
    }
    @Step("Создать")
    public DocBook openDocList () throws InterruptedException  {
        try{
            findByXpath(createBtn, Duration.ofSeconds(EXPLICIT_WAIT)).click();
      //  WebElement weCreateBtn = driver.findElement(createBtn);
      //  Thread.sleep(1000);
      //  waitElementToBeClickable(weCreateBtn).click();
        }
        catch (NoSuchElementException e)
        {
            Assert.fail("Ошибка нахождения элемента : " + e.toString());
        }
        return this;
    }
    @Step("Открываем рублевую платежку")
    public DocBook openBayDocBy () {
        try {
            findByXpath(payDocBy, Duration.ofSeconds(EXPLICIT_WAIT)).click();
            //   WebElement wePayDocBy = driver.findElement(payDocBy);
            //   waitElementToBeClickable(wePayDocBy).click();
            //  Assert.assertEquals(1, 1);
         }
            catch (NoSuchElementException e)
            {
                Assert.fail("Ошибка нахождения элемента : " + e.toString());
            }
        return this;
    }
}
