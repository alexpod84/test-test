package tests.ibtest;

//Страница тестов

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
public class SignUp extends BaseTest {


    @Test(priority = 1, description = "Вход")

    public void authorization() {

        basePage.open(TEST_URL);


        ibPage
                .authorization(LOGIN_TEST, PASSWORLD_TEST);

    }
    @Test(priority = 2, description = "Открытие платежного поручения")

    public void openDocBook() {
        docBook
                .openDocBook()
                .openDocList()
                .openBayDocBy();
    }
}
