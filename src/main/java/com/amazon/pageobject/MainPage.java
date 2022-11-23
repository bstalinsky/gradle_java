package com.amazon.pageobject;

import com.amazon.pageobject.SearchPages.SearchPage;
import com.amazon.pageobject.basefunc.BaseFunc;
import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.*;

public class MainPage {
    protected BaseFunc baseFunc;
    private final By dissmissCountry = By.xpath("//input[@data-action-params='{'toasterType':'IS_INGRESS'}']");
    private final By cartButton = By.xpath("//span[@id='nav-cart-count']");

    private final By searchLine = By.xpath("//input[@id='twotabsearchtextbox']");
    private final By searchLineBut = By.xpath("//input[@id='nav-search-submit-button']");
    private final By searchDropDownBox = By.xpath("//select[@id='searchDropdownBox/option']");
    private final By amazonLogo = By.xpath("//a[@id='nav-logo-sprites']");

    private final By navBarBut = By.xpath("//i[@class='hm-icon nav-sprite']");
    private final By navBarMenuList = By.xpath("//ul[@class='hmenu hmenu-visible']//li");

    private final By signInMenuBut = By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
    private final By signInBut = By.xpath("//div[@class='nav-line-1-container']//span[text() = 'Hello, sign in']");

    private final By yourAccountList = By.xpath("//*[@id='nav-al-your-account']//a");
    private final By saleBut = By.xpath("//a[normalize-space()='Sell']");
    private final By giftCardBut = By.xpath("//a[contains(text(),'Gift Cards')]");
    private final By todayDeal = By.xpath("//a[@href='/gp/goldbox?ref_=nav_cs_gb']");

    public MainPage(BaseFunc baseFunc){
        this.baseFunc=baseFunc;
    }

    public MainPage inputSearchLineType(String text){
        baseFunc.type(searchLine , text);
        return this;
    }
    public SearchPage clickSearch(){
        baseFunc.click(searchLineBut);
        return new SearchPage(baseFunc);
    }

    public SignInPage clickSignIn(){
        baseFunc.click(signInBut);
        return new SignInPage(baseFunc);
    }







}

