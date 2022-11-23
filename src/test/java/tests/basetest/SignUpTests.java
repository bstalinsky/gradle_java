package tests.basetest;

import com.amazon.pageobject.MainPage;
import com.amazon.pageobject.SignInPage;
import com.amazon.pageobject.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignUpTests extends BasicTest{
   public String name = "BOHDAN1";
    String email = "bstalinskyi@gmail.com";
    String password = "Dsaewqxx!!";
    String password_re = "Dsaewqxx!!";


    @BeforeMethod
    public void goToSignUpPage(){
        MainPage mainPage = new MainPage(baseFunc);
        mainPage.clickSignIn();
        SignInPage signInPage = new SignInPage(baseFunc);
        signInPage.clickCreateAccount();
    }

    @Test
    public void successfulSignUP() throws InterruptedException {
        SignUpPage signUpPage = new SignUpPage(baseFunc);
        signUpPage.register(name, email, password, password_re);
    }
    @Test
    public void invalidNameSignUP(){
        SignUpPage signUpPage = new SignUpPage(baseFunc);
        signUpPage.register("1", "dasdsadsasad" , "dasdsadsa", "dsasaddsa");
        String errorEmail = signUpPage.getEmailInvalidText();
        assertEquals(errorEmail, "Wrong or Invalid email address or mobile phone number. Please correct and try again.");
        String errorPassword = signUpPage.getPasswordMustMatch();
        assertEquals(errorPassword, "Passwords must match");
        ;
    }
    @Test
    public void emptyFieldSignUpValid(){
        SignUpPage signUpPage = new SignUpPage(baseFunc);
        signUpPage.clickContinue();

        String error1 = signUpPage.getNameErrorText();
        assertEquals(error1, "Enter your name");
        String error2 = signUpPage.getEmailErrorText();
        assertEquals(error2, "Enter your email or mobile phone number");
        String error3 = signUpPage.getPasswordErrorText();
        assertEquals(error3, "Minimum 6 characters required");
    }
}
