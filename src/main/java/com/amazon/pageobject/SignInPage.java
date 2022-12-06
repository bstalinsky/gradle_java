package com.amazon.pageobject;

import com.amazon.pageobject.basefunc.BaseFunc;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignInPage {
    private  BaseFunc baseFunc;

    private final By emailField = By.xpath("//input[@id='ap_email']");
    private final By passwordField = By.xpath("//input[@id='ap_password']");
    private final By rememberMeCheckbox = By.xpath("//input[@name='rememberMe']");
    private final By signInBut = By.xpath("//input[@id='signInSubmit']");

    private final By navBarMenu = By.xpath("//a[@id='nav-link-accountList']");




    private final By continueBut = By.xpath("//input[@id='continue']");
    private final By createAccountSubmit = By.xpath("//a[@id='createAccountSubmit']");
    public static By errorEmail = By.xpath("//h4[text() = 'There was a problem']");
    public static By HELLO_USER = By.id("nav-link-accountList-nav-line-1");
    private final By assertSignIn = By.xpath("//h1[contains(text() , 'Sign in')]");

    public SignInPage(BaseFunc baseFunc){
        this.baseFunc=baseFunc;
    }

    public void clickCreateAccount(){
        baseFunc.click(createAccountSubmit);
    }

    public MainPage clickCountinue(){
        baseFunc.click(continueBut);
        return new MainPage(baseFunc);
    }

    public SignInPage typeEmail(String email){
        baseFunc.type(emailField, email);
        return this;
    }
    public SignInPage typePassword(String password){
        baseFunc.type(passwordField, password);
        return this;
    }
    public SignInPage clickSignInBut( ){
        baseFunc.click(signInBut);
        return this;
    }
    public void keepMeSign( ){
            baseFunc.click(rememberMeCheckbox );
    }

    public String setAssertSignIn(){
       return baseFunc.getText(errorEmail);
    }

    public MainPage signInSuccessful()   {

        String error = getTextEmail();
        Assert.assertEquals(error, "Hello, BOHDAN1");
        return new MainPage(baseFunc);
    }

    public void invalidPassValid()  {
        String error1 = getTextEmail1();
        assertEquals(error1, "There was a problem");
    }

    public SignInPage signIn(String email, String password){
        this.typeEmail(email);
        this.clickCountinue();
        this.typePassword(password);
        keepMeSign();
        this.clickSignInBut();
        return new SignInPage(baseFunc);
//        this.typePassword(password);
    }
    

    public SignInPage invalidEmailType(String email){
        this.typeEmail(email);
        this.clickCountinue();
        return new SignInPage(baseFunc);
    }

    public String getTextEmail()  {
       return baseFunc.findElement(HELLO_USER).getText();
    }

    public String getTextEmail1()  {
        return baseFunc.findElement(errorEmail).getText();
    }

    public void asserSignOut(){
       String error =  baseFunc.findElement(assertSignIn).getText();
       Assert.assertEquals(error , "Sign in");
    }



}
