package com.amazon.pageobject.signInMenu;

import com.amazon.pageobject.basefunc.BaseFunc;
import org.openqa.selenium.By;

public class YourAccountMenu {
    private final BaseFunc baseFunc;
    private final By yourOrders = By.xpath("//h2[normalize-space()='Your Orders']");
    private final By loginSecurity = By.xpath("//h2[normalize-space()='Login & security']");
    private final By prime = By.xpath("//h2[normalize-space()='Prime']");
    private final By giftCards = By.xpath("//h2[normalize-space()='Gift cards']");
    private final By yourPayments = By.xpath("//h2[normalize-space()='Your Payments']");
    private final By yourProfiles = By.xpath("//h2[normalize-space()='Your Profiles']");
    private final By digitalServicesAndDevice = By.xpath("//h2[normalize-space()='Digital Services and Device Support']");
    private final By yourMessage = By.xpath("//h2[normalize-space()='Your Messages']");

    private final By navBarMenu = By.xpath("//a[@id='nav-link-accountList']");
    private final By yourAccount = By.xpath("//span[normalize-space()='Account']");


    public YourAccountMenu (BaseFunc baseFunc){
        this.baseFunc=baseFunc;
    }

    public YourAccountMenu clickYourAccount(){
        baseFunc.moveToElement(navBarMenu);
        baseFunc.click(yourAccount);
        return new YourAccountMenu(baseFunc);
    }
    public void clickYourOrders(){
        baseFunc.click(yourOrders);
    }
    public void loginSecurity(){
        baseFunc.click(loginSecurity);
    }
    public void clickPrime(){
        baseFunc.click(prime);
    }
    public void clickGiftCards(){
        baseFunc.click(giftCards);
    }
    public void clickYourProfiles(){
        baseFunc.click(yourProfiles);
    }
    public void clickYourPayments(){
        baseFunc.click(yourPayments);
    }
    public void clickDigitalServicesAndDevice(){
        baseFunc.click(digitalServicesAndDevice);
    }
    public void clickYourMessage(){
        baseFunc.click(yourMessage);
    }


}
