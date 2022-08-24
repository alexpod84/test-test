package pages.ibpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class PayDocBy extends BasePage {

        private final By inamount = By.xpath("//div[@class='input-amount']/input");
        private final By payerTypecb = By.xpath("//h2[text()='Плательщик']//following-sibling::div//i[@class='sc-icon sc-icon-arrow-down ng-star-inserted']");


        private final By payerType = By.xpath("//div[text()='INI - Индивидуальный предприниматель']");

        public PayDocBy (WebDriver driver) {super(driver); }

        public PayDocBy inputData () {
                WebElement weinamount = driver.findElement(inamount);
                waitElementIsVisible(weinamount).sendKeys("1");
                WebElement wepayerTypecb = driver.findElement(payerTypecb);
                waitElementIsVisible(wepayerTypecb).click();
                WebElement wepayerType = driver.findElement(payerType);
                waitElementIsVisible(wepayerType).click();
                return this;
        }
}
