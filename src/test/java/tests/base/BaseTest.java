package tests.base;

import common.CommonActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import pages.base.BasePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterSuite;
import pages.ibpage.DocBook;
import pages.ibpage.IbPage;
import pages.ibpage.PayDocBy;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected IbPage ibPage = new IbPage(driver);
    protected DocBook docBook = new DocBook(driver);
    protected PayDocBy payDocBy = new PayDocBy(driver);


    @AfterTest
    public void clearCookiesAndLocalStorage (){
        if (CLEAR_COOKIES_AND_STORAGE){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            if(!driver.getCurrentUrl().contains("data:")){
                javascriptExecutor.executeScript("window.sessionStorage.clear()");
            }
        }

    }

   @AfterSuite (alwaysRun = true)
    public void close() {
        if  (!HOLD_BROWSER_OPEN) {
            driver.quit();
        }
   }


}
