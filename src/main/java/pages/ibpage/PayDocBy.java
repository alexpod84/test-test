package pages.ibpage;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pages.base.BasePage;
import org.testng.Assert;

import java.time.Duration;
import static common.Config.EXPLICIT_WAIT;
public class PayDocBy extends BasePage {

    private final String inamount = "//div[@class='input-amount']/input";
    private final String payerTypecb = "//h2[text()='Плательщик']//following-sibling::div//i[@class='sc-icon sc-icon-arrow-down ng-star-inserted']";
    private final String thirdCorrTypeNameCl = "//label[contains(text(),'Тип получателя')]//following-sibling::dbo-choose-lazy-select-data-reference";
    private final String thirdCorrTypeName = "//div[text()='INI - Индивидуальный предприниматель']//..//..";
    private final String payerType = "//div[text()='INI - Индивидуальный предприниматель']";
    private final String beneficiar = "//div[@class='field-directory']//input";
    private final String beneficiaryAccountNumber = "//h2[text()='Получатель']//following-sibling::div//input[@class='-full-width ng-untouched ng-pristine ng-valid']";
    private final String beneficaryTaxIdNumber = "//h2[text()='Получатель']//following-sibling::div//input[@class='ng-untouched ng-pristine ng-valid']";
    private final String beneficiaryBankCl = "//label[contains(text(),'Банк-получатель')]//following-sibling::dbo-choose-lazy-select-data-reference";
    private final String beneficiaryBankInp = "//label[contains(text(),'Банк-получатель')]//following-sibling::dbo-choose-lazy-select-data-reference//input";

    private final String beneficiaryBankSel =  "//div[contains(text(), 'AKBBString2X')]//..//..";
    private final String descriptionData = "//label[contains(text(),'Назначение платежа')]//following-sibling::div/textarea";

    //   private final String paymentNotesCode = "//label[contains(text(),'Код назначения платежа')]//following-sibling::div/input";
    private final String paymentNotesCode = "//label[contains(text(),'Код назначения платежа')]//following-sibling::dbo-input-group-reference//input";
    private final String signRefundCl = "//label[contains(text(),'Признак платежа')]//following-sibling::dbo-choose-lazy-select-data-reference";
    private final String signRefundSel = "//div[contains(text(), '1 - Платёж')]//..//..";
    private final String transferNotesCodeCl = "//label[contains(text(),'Код назначения перевода')]//following-sibling::dbo-input-group-reference/button";
    private final String transferNotesCode  = "//span[contains(text(), 'BONU')]//..//..";
    private final String btnSave = "//div[@class='-float-right']//button[contains(text(), 'Сохранить')]";

    private final String belarusbank = ".//div[contains(text(), 'БЕЛАРУСБАНК')]";


        public PayDocBy (WebDriver driver) {super(driver); }
        @Step ("Ввод данных обычной платежки")
        public PayDocBy inputData () throws InterruptedException {
            try {
                findByXpath(inamount, Duration.ofSeconds(EXPLICIT_WAIT)).sendKeys("1");
                findByXpath(payerTypecb, Duration.ofSeconds(EXPLICIT_WAIT)).click();
                findByXpath(payerType, Duration.ofSeconds(EXPLICIT_WAIT)).click();
                findByXpath(thirdCorrTypeNameCl, Duration.ofSeconds(EXPLICIT_WAIT)).click();
                findByXpath(thirdCorrTypeName, Duration.ofSeconds(EXPLICIT_WAIT)).click();
                findByXpath(beneficiar, Duration.ofSeconds(EXPLICIT_WAIT)).sendKeys("Наименование бенефициара");
                findByXpath(beneficiaryAccountNumber, Duration.ofSeconds(EXPLICIT_WAIT)).sendKeys("BY86AKBB30120000049980000000");
                findByXpath(beneficaryTaxIdNumber, Duration.ofSeconds(EXPLICIT_WAIT)).sendKeys("190819036");
                findByXpath(beneficiaryBankCl, Duration.ofSeconds(EXPLICIT_WAIT)).click();
                findByXpath(beneficiaryBankInp, Duration.ofSeconds(EXPLICIT_WAIT)).sendKeys("AKBBBY2X");
           //     Thread.sleep(1000);
                findByXpath(belarusbank, Duration.ofSeconds(EXPLICIT_WAIT)).click();
            //    webeneficiaryBankInp.sendKeys(Keys.ENTER);
                findByXpath(descriptionData, Duration.ofSeconds(EXPLICIT_WAIT)).sendKeys("Назначение платежа");
                findByXpath(paymentNotesCode, Duration.ofSeconds(EXPLICIT_WAIT)).sendKeys("12601");
                findByXpath(signRefundCl, Duration.ofSeconds(EXPLICIT_WAIT)).click();
                findByXpath(signRefundSel, Duration.ofSeconds(EXPLICIT_WAIT)).click();
                findByXpath(transferNotesCodeCl, Duration.ofSeconds(EXPLICIT_WAIT)).click();
                findByXpath(transferNotesCode, Duration.ofSeconds(EXPLICIT_WAIT)).click();
            }
            catch (NoSuchElementException e)
            {
                Assert.fail("Ошибка нахождения элемента : " + e.toString());
            }


                return this;
        }
        @Step("Сохранить")

        public PayDocBy sendForm (){
            findByXpath(btnSave, Duration.ofSeconds(EXPLICIT_WAIT)).click();
             //   WebElement webtnSave = driver.findElement(btnSave);
             //   waitElementIsVisible(webtnSave).click();
                return this;
        }


}
