package tests.basetest;

import com.amazon.pageobject.MainPage;
import com.amazon.pageobject.SignInPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.*;

import static org.testng.Assert.*;

public class SignInTests extends BasicTest{
    protected SignInPage signInPage;
    protected MainPage mainPage;
    String email = "bstalinskyi@gmail.com";
    String password = "Dsaewqxx!!";
    String ERROR_TXT = "There was a problem";
    @Test
    public void clickToSignIn() throws InterruptedException {
         new MainPage(baseFunc)
                 .clickSignIn()
                 .signIn(email , password)
                 .signInSuccessful();
    }


    @Test
    public void invalidSignInEmail1() throws InterruptedException {
       new MainPage(baseFunc).clickSignIn()
              .invalidEmailType("email")
              .invalidPassValid();

    }

    @Test
    public void invalidSignIn() throws InterruptedException {
        new MainPage(baseFunc).clickSignIn().signIn(email, "password")
                .invalidPassValid();

    }

}
