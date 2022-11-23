package com.amazon.pageobject;

import com.amazon.pageobject.basefunc.BaseFunc;
import org.openqa.selenium.By;

public class SignInPage {
    private  BaseFunc baseFunc;

    private final By emailField = By.xpath("//input[@id='ap_email']");
    private final By passwordField = By.xpath("//input[@id='ap_password']");
    private final By rememberMeCheckbox = By.xpath("//input[@id='ap_password']");
    private final By signInBut = By.xpath("//input[@id='signInSubmit']");





    private final By continueBut = By.xpath("//input[@id='continue']");
    private final By createAccountSubmit = By.xpath("//a[@id='createAccountSubmit']");
    private final By errorEmail = By.xpath("///span[@class='a-list-item']");
    private final By assertSignIn = By.xpath("//span[contains(text() , 'Hello, BOHDAN1')]");

    public SignInPage(BaseFunc baseFunc){
        this.baseFunc=baseFunc;
    }

    public void clickCreateAccount(){
        baseFunc.click(createAccountSubmit);
    }

    public SignInPage clickCountinue(){
        baseFunc.click(continueBut);
        return this;
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
        if(!baseFunc.findElement(rememberMeCheckbox).isSelected()){
            baseFunc.click(rememberMeCheckbox );
        } else {
            System.out.println("checkbox not selected");
        }
    }
    public String setAssertSignIn(){
       return baseFunc.getText(assertSignIn);

    }

    public void signIn(String email, String password){
        this.typeEmail(email);
        this.clickCountinue();
        this.typePassword(password);
        keepMeSign();
        this.clickSignInBut();
//        this.typePassword(password);
    }

}
