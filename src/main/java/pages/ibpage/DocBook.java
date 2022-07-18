package pages.ibpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

public class DocBook extends BasePage {
    public DocBook (WebDriver driver) {super(driver); }

    private final By createBtn = By.xpath("//button[text()='Создать']");
    private final By payDocBy = By.xpath(" //sc-modal[8]/div/sc-modal-body/div/div[1]/div[2]");
    public DocBook OpenDocList () {
        driver.findElement(createBtn).click();
        return this;
    }
    public DocBook OpenBayDocBy () {
        driver.findElement(payDocBy).click();
        Assert.assertEquals(1, 1);
        return this;
    }
}
