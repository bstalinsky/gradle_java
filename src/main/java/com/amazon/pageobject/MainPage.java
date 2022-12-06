package com.amazon.pageobject;

import com.amazon.mainpagesteps.pageobjectVerify.MainPageAssert;
import com.amazon.pageobject.SearchPages.SearchPage;
import com.amazon.pageobject.basefunc.BaseFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {
    protected BaseFunc baseFunc;
    private final By dissmissCountry = By.xpath("//input[@data-action-params='{'toasterType':'IS_INGRESS'}']");
    private final By deliverToMenu = By.xpath("//a[@id='nav-global-location-popover-link']");
    private final By cartButton = By.xpath("//span[@id='nav-cart-count']");
    private final By GoTocartButton = By.xpath("//a[contains(text() , 'Go to Cart')]");
    private final By shipToCountry = By.cssSelector("#GLUXCountryList");
    private final By doneBut = By.xpath("//button[@name='glowDoneButton']");
    private final By countryList = By.id("//span[@role='radiogroup']");

    private final By searchLine = By.xpath("//input[@id='twotabsearchtextbox']");
    private final By searchLineBut = By.xpath("//input[@id='nav-search-submit-button']");
    private final By searchDropDownBox = By.id("searchDropdownBox");
    private final By amazonLogo = By.xpath("//a[@id='nav-logo-sprites']");

    private final By navBarBut = By.xpath("//i[@class='hm-icon nav-sprite']");
    private final By langMenu = By.xpath("//span[@class='icp-nav-link-inner']//span[@class='nav-line-2']");
    private final By selectRegion = By.id("icp-dropdown");
    private final By navBarMenuList = By.xpath("//ul[@class='hmenu hmenu-visible']//li");

    private final By signInBut = By.xpath("//div[@class='nav-line-1-container']//span[text() = 'Hello, sign in']");

    private final By yourAccountList = By.xpath("//*[@id='nav-al-your-account']//a");
    private final By sellBut = By.xpath("//a[normalize-space()='Sell']");
    private final By giftCardBut = By.xpath("//a[contains(text(),'Gift Cards')]");
    private final By todayDeal = By.xpath("//a[@href='/gp/goldbox?ref_=nav_cs_gb']");
    private final By cancelBut = By.xpath("//a[normalize-space()='Cancel']");
    private final By goToWebsite = By.cssSelector(".a-button-input");

    private final By navBarMenu = By.xpath("//a[@id='nav-link-accountList']");
    private final By changeRegionLang = By.xpath("//div[text() = 'Change country/region.']");



    public MainPage(BaseFunc baseFunc){
        this.baseFunc=baseFunc;
    }


    public MainPageAssert logoIsDisplayed(){
        baseFunc.findElement(amazonLogo).click();
                return new MainPageAssert(baseFunc);
    }
    public MainPageAssert getTitle(){
        baseFunc.getTitle("Amazon.com. Spend less. Smile more.");
        return new MainPageAssert(baseFunc);
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
    public CartPage cartBut(){
        baseFunc.click(cartButton);
        return new CartPage(baseFunc);
    }
    public CartPage goToCartBut(){
        baseFunc.click(GoTocartButton);
        return new CartPage(baseFunc);
    }
    public SignInPage signOutBut() {
        List<WebElement> webElementList = baseFunc.findElements(yourAccountList);
        webElementList.get(12)
                .click();
        return new SignInPage(baseFunc);
    }

    public MainPage moveToMenuNavBar(){
        baseFunc.moveToElement(navBarMenu);
        return new MainPage(baseFunc);
    }

    public MainPage clickOnDeliverTo(){
        baseFunc.click(deliverToMenu);
        return new MainPage(baseFunc);
    }

    public MainPage clickCountryList() throws InterruptedException {
        Thread.sleep(1000);
        baseFunc.click(countryList);
        return new MainPage(baseFunc);
    }
    public MainPage selectDeliveryCountry(String value){
        baseFunc.selectByVisibleText(shipToCountry, value);
        return new MainPage(baseFunc);
    }

        public MainPageAssert clickDoneBut(){
        baseFunc.click(doneBut);
        return new MainPageAssert(baseFunc);
        }

        public MainPage moveToLangMenu(){
        baseFunc.moveToElement(langMenu);
        return new MainPage(baseFunc);
        }
    public MainPage clickChangeCountyRegion(){
        baseFunc.click(changeRegionLang);
        return new MainPage(baseFunc);
    }
    public MainPage selectRegion(String country){
        baseFunc.selectByVisibleText(selectRegion, country);
        baseFunc.pressKeys(Keys.ENTER);
        return new MainPage(baseFunc);
    }

    public MainPageAssert clickGoToWebsite() {
        baseFunc.click(goToWebsite);
        baseFunc.switchToTabLast();
        return new MainPageAssert(baseFunc);
    }

    public MainPage selectCategory(String category){
        baseFunc.selectByVisibleText(searchDropDownBox, category);
        return new MainPage(baseFunc);
    }


}

