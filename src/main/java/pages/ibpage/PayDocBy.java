package pages.ibpage;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pages.base.BasePage;
import org.testng.Assert;

import java.time.Duration;

public class PayDocBy extends BasePage {

        private final By inamount = By.xpath("//div[@class='input-amount']/input");
        private final By payerTypecb = By.xpath("//h2[text()='Плательщик']//following-sibling::div//i[@class='sc-icon sc-icon-arrow-down ng-star-inserted']");

        private final By thirdCorrTypeNameCl = By.xpath("//label[contains(text(),'Тип получателя')]//following-sibling::dbo-choose-lazy-select-data-reference");

        private final By thirdCorrTypeName = By.xpath("//div[text()='INI - Индивидуальный предприниматель']//..//..");

        private final By payerType = By.xpath("//div[text()='INI - Индивидуальный предприниматель']");
        private final By beneficiar = By.xpath("//div[@class='field-directory']//input");

        private final By beneficiaryAccountNumber = By.xpath("//h2[text()='Получатель']//following-sibling::div//input[@class='-full-width ng-untouched ng-pristine ng-valid']");

        private final By beneficaryTaxIdNumber = By.xpath("//h2[text()='Получатель']//following-sibling::div//input[@class='ng-untouched ng-pristine ng-valid']");

        private final By beneficiaryBankCl = By.xpath("//label[contains(text(),'Банк-получатель')]//following-sibling::dbo-choose-lazy-select-data-reference");

        private final By beneficiaryBankInp = By.xpath("//label[contains(text(),'Банк-получатель')]//following-sibling::dbo-choose-lazy-select-data-reference//input");

        private final By beneficiaryBankSel =  By.xpath("//div[contains(text(), 'AKBBBY2X')]//..//..");

        private final By descriptionData = By.xpath("//label[contains(text(),'Назначение платежа')]//following-sibling::div/textarea");

     //   private final By paymentNotesCode = By.xpath("//label[contains(text(),'Код назначения платежа')]//following-sibling::div/input");
     private final By paymentNotesCode = By.xpath("//label[contains(text(),'Код назначения платежа')]//following-sibling::dbo-input-group-reference//input");

        private final By signRefundCl = By.xpath("//label[contains(text(),'Признак платежа')]//following-sibling::dbo-choose-lazy-select-data-reference");

        private final By signRefundSel = By.xpath("//div[contains(text(), '1 - Платёж')]//..//..");

        private final By transferNotesCodeCl = By.xpath("//label[contains(text(),'Код назначения перевода')]//following-sibling::dbo-input-group-reference/button");

        private final By transferNotesCode  = By.xpath("//span[contains(text(), 'BONU')]//..//..");

        private final By btnSave = By.xpath("//div[@class='-float-right']//button[contains(text(), 'Сохранить')]");

        // private final By  = By.xpath("");


        public PayDocBy (WebDriver driver) {super(driver); }
        @Step ("Ввод данных обычной платежки")
        public PayDocBy inputData () throws InterruptedException {
            try {
                WebElement weinamount = driver.findElement(inamount);
                waitElementIsVisible(weinamount).sendKeys("1");
                WebElement wepayerTypecb = driver.findElement(payerTypecb);
                waitElementIsVisible(wepayerTypecb).click();
                WebElement wepayerType = driver.findElement(payerType);
                waitElementIsVisible(wepayerType).click();
                WebElement wethirdCorrTypeNameCl = driver.findElement(thirdCorrTypeNameCl);
                waitElementIsVisible(wethirdCorrTypeNameCl).click();
                WebElement wethirdCorrTypeName = driver.findElement(thirdCorrTypeName);
                waitElementIsVisible(wethirdCorrTypeName).click();
                WebElement webeneficiar = driver.findElement(beneficiar);
                waitElementIsVisible(webeneficiar).sendKeys("Наименование бенефициара");
                WebElement webeneficiaryAccountNumber = driver.findElement(beneficiaryAccountNumber);
                waitElementIsVisible(webeneficiaryAccountNumber).sendKeys("BY86AKBB30120000049980000000");
                WebElement webeneficaryTaxIdNumber = driver.findElement(beneficaryTaxIdNumber);
                waitElementIsVisible(webeneficaryTaxIdNumber).sendKeys("190819036");
                WebElement webeneficiaryBankCl = driver.findElement(beneficiaryBankCl);
                waitElementIsVisible(webeneficiaryBankCl).click();
                WebElement webeneficiaryBankInp = driver.findElement(beneficiaryBankInp);

                //Не явное ожидание почему-то не срабатывает
                Thread.sleep(1000);
                waitElementIsVisible(webeneficiaryBankInp).sendKeys("AKBBBY2X");
                Thread.sleep(1000);
                webeneficiaryBankInp.sendKeys(Keys.ENTER);

                WebElement wedescriptionData = driver.findElement(descriptionData);
                waitElementIsVisible(wedescriptionData).sendKeys("Назначение платежа");
                WebElement wepaymentNotesCode = driver.findElement(paymentNotesCode);
                waitElementIsVisible(wepaymentNotesCode).sendKeys("12601");
                WebElement wesignRefundCl = driver.findElement(signRefundCl);
                waitElementIsVisible(wesignRefundCl).click();
                WebElement wesignRefundSel = driver.findElement(signRefundSel);
                waitElementIsVisible(wesignRefundSel).click();
                WebElement wetransferNotesCodeCl = driver.findElement(transferNotesCodeCl);
                waitElementIsVisible(wetransferNotesCodeCl).click();
                WebElement wetransferNotesCode = driver.findElement(transferNotesCode);
                waitElementIsVisible(wetransferNotesCode).click();
            }
            catch (NoSuchElementException e)
            {
                Assert.fail("Ошибка нахождения элемента : " + e.toString());
            }


                return this;
        }
        @Step("Сохранить")

        public PayDocBy sendForm (){
                WebElement webtnSave = driver.findElement(btnSave);
                waitElementIsVisible(webtnSave).click();
                return this;
        }
}
