package tests.ibtest;

//Страница тестов

//import org.junit.Test;
import io.qameta.allure.Step;
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
import static constants.Constant.logpass.PASSWORD_TEST;
import static constants.Constant.logpass.LOGIN_PROD;
import static constants.Constant.logpass.PASSWORD_PROD;

public class SignUp extends BaseTest {


    @Test(priority = 1, description = "Вход")
   // @Step ("Авторизация")
    public void authorization() {

        basePage.open(PROD_URL);


        ibPage
                .authorization(LOGIN_PROD, PASSWORD_PROD);

    }
    @Test(priority = 2, description = "Открытие платежного поручения")

  //  @Step ("Открытие списка документов и пп")
    public void openDocBook() {
        docBook
                .openDocBook()
                .openDocList()
                .openBayDocBy();
    }

    @Test(priority = 3, description = "Ввод данных")
  //  @Step ("Ввод данных ПП")
    public void inpPayDocBy() throws InterruptedException {
        payDocBy
                .inputData();

    }

    @Test(priority = 4, description = "Сохранение платежного поручения")
  //@Step ("Отправка ПП")
    public void savePayDocBy() {
        payDocBy
                .sendForm();
    }
}
