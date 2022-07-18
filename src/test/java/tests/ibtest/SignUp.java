package tests.ibtest;


//import org.junit.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ibpage.IbPage;
import tests.base.BaseTest;


import java.time.Duration;

import static constants.Constant.Urls.TEST_URL;
import static constants.Constant.Urls.PROD_URL;
import static constants.Constant.logpass.LOGIN_TEST;
import static constants.Constant.logpass.PASSWORLD_TEST;
import static constants.Constant.logpass.LOGIN_PROD;
import static constants.Constant.logpass.PASSWORLD_PROD;
public class SignUp extends BaseTest {


  @Test

    public void signUp() {

    basePage.open(PROD_URL);


    ibPage
            .authorization(LOGIN_PROD, PASSWORLD_PROD)
            .openDocBook();
    docBook
            .OpenDocList()
            .OpenBayDocBy();

 /*

  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //неявное ожидание


    WebElement docbook = (new WebDriverWait(driver, Duration.ofSeconds(10)) // явное ожидание
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@tutorial-data = 'document_nav']"))));

   */

  }
}
