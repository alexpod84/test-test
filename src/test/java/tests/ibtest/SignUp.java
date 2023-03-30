package tests.ibtest;

//Страница тестов

//import org.junit.Test;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import static common.Config.*;


public class SignUp extends BaseTest {

    @Test
    public void testMvn(){
        System.out.println("check maven");
    }


    @Test(priority = 1, description = "Вход")

  public void authorization() {

        basePage.open(URL);


        ibPage
                .authorization(LOGIN, PASSWORD);

    }
    @Test(priority = 2, description = "Открытие платежного поручения")

  //  @Step ("Открытие списка документов и пп")
    public void openDocBook() throws InterruptedException{
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
    public void savePayDocBy() throws InterruptedException {
        payDocBy
                .sendForm();
    }
}
