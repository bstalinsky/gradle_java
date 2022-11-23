package tests.basetest;

import com.amazon.pageobject.MainPage;
import com.amazon.pageobject.SignInPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.*;

public class SignInTests extends BasicTest{
    SearchPageTests searchPageTests;
    String email = "bstalinskyi@gmail.com";
    String password = "Dsaewqxx!!";
    @BeforeMethod
    public void clickToSignIn(){
        MainPage mainPage = new MainPage(baseFunc);
        mainPage.clickSignIn();
    }
    @Test
    public void signIn() throws InterruptedException {
        SignInPage signInPage = new SignInPage(baseFunc);
        signInPage.signIn(email , password);

    }

//    @Test
//    public void invalidSignIn()   {
//        SignInPage signInPage = new SignInPage(baseFunc);
//        signInPage.signIn("email" , "password");
//
//
//    }

}
