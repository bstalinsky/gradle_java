package com.amazon.pageobject;

import com.amazon.pageobject.basefunc.BaseFunc;
import org.openqa.selenium.By;

public class SignUpPage {
    BaseFunc baseFunc;

    private final By customerName = By.xpath("//input[@id='ap_customer_name']");
    private final By emailField = By.xpath("//input[@id='ap_email']");
    private final By passwordField = By.xpath("//input[@id='ap_password']");
    private final By passwordField2 = By.xpath("//input[@id='ap_password_check']");
    private final By countinueBut = By.xpath("//input[@id='continue']");


    private final By alertName = By.xpath("//div[contains(text(),'Enter your name')]");
    private final By alertEmail = By.xpath("//div[contains(text(),'Enter your email or mobile phone number')]");
    private final By alertpassword = By.xpath("//div[@id='auth-password-missing-alert']//div[@class='a-alert-content'][normalize-space()='Minimum 6 characters required']");
    private final By alertInvalidEmail = By.xpath("//div[@class='a-alert-content'][normalize-space()='Wrong or Invalid email address or mobile phone number. Please correct and try again.']");
    private final By alertReEnterPassword = By.xpath("//div[contains(text(),'Passwords must match')]");
    private final By SUCCESS_REGIS = By.xpath("//span[@class='a-size-large']");


    public SignUpPage() {
    }

    public SignUpPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public SignUpPage typeCustomerName(String name) {
        baseFunc.type(customerName, name);
        return this;
    }

    public SignUpPage typeEmail(String email) {
        baseFunc.type(emailField, email);
        return this;
    }

    public SignUpPage typePassword(String password) {
        baseFunc.type(passwordField, password);
        return this;
    }

    public SignUpPage typePassword2(String password) {
        baseFunc.type(passwordField2, password);
        return this;

    }

    public MainPage clickContinue() {
        baseFunc.click(countinueBut);
        return new MainPage(baseFunc);

    }

    public String getNameErrorText(){
      return   baseFunc.getText(alertName);
    }
    public boolean validSignUPsuc(){
        return   baseFunc.findElement(SUCCESS_REGIS).isEnabled();
    }
    public String getPasswordErrorText(){
        return   baseFunc.getText(alertpassword);
    }
    public String getEmailErrorText(){
        return   baseFunc.getText(alertEmail);
    }
    public String getEmailInvalidText(){
        return   baseFunc.getText(alertInvalidEmail);
    }
    public String getPasswordMustMatch(){
        return   baseFunc.getText(alertReEnterPassword);
    }

    public MainPage register(String name, String email, String password, String password_re) {

        this.typeCustomerName(name);
        this.typeEmail(email);
        this.typePassword(password);
        this.typePassword2(password_re);
        this.typeCustomerName(name);
        this.clickContinue();
        return new MainPage(baseFunc);

    }

}
