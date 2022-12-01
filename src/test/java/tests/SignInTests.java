package tests;

import com.amazon.pageobject.MainPage;
import org.testng.annotations.Test;
import tests.basetest.BasicTest;

public class SignInTests extends BasicTest {
   public static String email = "bstalinskyi@gmail.com";
    public static String password = "Dsaewqxx!!";
    String ERROR_TXT = "There was a problem";

    @Test(groups = "positive")
    public void clickToSignInSignOut() throws InterruptedException {
         new MainPage(baseFunc)
                 .clickSignIn()
                 .signIn(email , password)
                 .signInSuccessful().moveToMenuNavBar().signOutBut().asserSignOut();

    }

    @Test(groups = "negative")
    public void invalidSignInEmail1() throws InterruptedException {
       new MainPage(baseFunc).clickSignIn()
              .invalidEmailType("email")
              .invalidPassValid();

    }

    @Test(groups = "negative")
    public void invalidSignIn() throws InterruptedException {
        new MainPage(baseFunc).clickSignIn().signIn(email, "password")
                .invalidPassValid();

    }

}
