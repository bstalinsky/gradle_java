package tests.amazon;

import com.amazon.pageobject.MainPage;
import com.amazon.pageobject.signInMenu.SignInPage;
import org.testng.annotations.Test;
import tests.basetest.BasicTest;

public class SignInTests extends BasicTest {
   public static String email = "bstalinskyi@gmail.com";
    public static String password = "Dsaewqxx!!";
    String ERROR_TXT = "There was a problem";

    @Test(groups = {"smoke"}, priority = 2)
    public void clickToSignInSignOut() {
         new MainPage(baseFunc)
                 .clickSignIn()
                 .signIn(email , password)
                 .signInSuccessful().moveToMenuNavBar().signOutBut().asserSignOut();
    }

    @Test(groups = {"negative"}, priority = 1)
    public void invalidSignInEmail()   {
       new MainPage(baseFunc).clickSignIn()
              .invalidEmailType("email")
              .invalidPassValid();
    }

    @Test(groups = {"negative"}, priority = 2, enabled = false)
    public void invalidSignIn()  {
        new MainPage(baseFunc).clickSignIn().signIn(email, "password")
                .reVerifyInvalid();
    }

    @Test(groups = {"smoke"}, dependsOnMethods = {"clickToSignIn"}, priority = 4)
    public void clickYourAccount(){
        new SignInPage(baseFunc).clickYourAccount();
    }

    @Test(groups = {"smoke"}, priority = 3)
    public void clickToSignIn() {
        new MainPage(baseFunc)
                .clickSignIn()
                .signIn(email , password)
                .signInSuccessful();
    }

}
