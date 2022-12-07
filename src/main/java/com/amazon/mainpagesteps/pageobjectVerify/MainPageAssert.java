package com.amazon.mainpagesteps.pageobjectVerify;

import com.amazon.pageobject.CartPage;
import com.amazon.pageobject.MainPage;
import com.amazon.pageobject.basefunc.BaseFunc;
import com.sun.media.jfxmedia.logging.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.*;

public class MainPageAssert {
    private final BaseFunc baseFunc;
    private final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(this.getClass());
    private final By deliveryCountryAssert = By.xpath("//span[@id='glow-ingress-line2']");
    private final By ADD_TO_CART_SUCC_MES = By.xpath("//*[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']/span");
    private final By CANADA_LANG_ICON = By.xpath("//span[@class='icp-nav-flag icp-nav-flag-ca icp-nav-flag-discoverability-t1']");
    private final By VERIFY_NORESULT = By.xpath("//span[contains(text() , 'No results for')]");
    private final By amazonLogo = By.xpath("//a[@id='nav-logo-sprites']");
    private final By giftCardMenu = By.xpath("//ul[@class='hmenu hmenu-visible hmenu-translateX']/li");






    public String getTextDelivery(){
        return baseFunc.getText(deliveryCountryAssert);
    }

    public void verifyDeliveryCountry() throws InterruptedException {
        Thread.sleep(2000);
        boolean we = baseFunc.findElement(deliveryCountryAssert).isDisplayed();
        String error = getTextDelivery();
        assertEquals(error, "Canada");
        assertFalse(error.isEmpty(), "Wrong country");
        assertTrue(we, "Wrong country");
    }

    public void  assertCanadaLocation(){
        String assertion = baseFunc.findElement(CANADA_LANG_ICON).getAttribute("class");
        WebElement assertion1 = baseFunc.findElement(CANADA_LANG_ICON);
        assertEquals(assertion, "icp-nav-flag icp-nav-flag-ca icp-nav-flag-discoverability-t1", "Something wrong");
        assertFalse(assertion.isEmpty(), "Element " + assertion + "is empty");
        assertTrue(assertion1.isDisplayed(), "Element " + assertion1 + "not Displayed");
    }

    public MainPage assertItemAdded(){
        String assertion = baseFunc.getText(ADD_TO_CART_SUCC_MES);
        WebElement assertion1 = baseFunc.findElement(ADD_TO_CART_SUCC_MES);
        assertEquals(assertion, "Added to Cart", "Something wrong");
        assertFalse(assertion.isEmpty(), "Element " + assertion + "is empty");
        assertTrue(assertion1.isDisplayed(), "Element " + assertion1 + "not Displayed");
        return new MainPage(baseFunc);
    }

    public void verifyWrongItem(String input){
      String  verify =   baseFunc.getText(VERIFY_NORESULT);
        assertEquals(verify + " " + input , "No results for" +" "+ input , "Something wrong");
    }

    public void verifyLogo(){
       WebElement we = baseFunc.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
       if (baseFunc.findElement(amazonLogo).equals(we)){
           Assert.assertTrue(we.isDisplayed() , "Element not present");

       } else {
           Assert.fail();
        }
        LOGGER.info("Logo verify" + we.isDisplayed());

    }
    public void getTitleAssert (){
        Assert.assertTrue(baseFunc.getTitle("Amazon.com. Spend less. Smile more.") , "Wrong title");
    }


    public MainPageAssert (BaseFunc baseFunc){
        this.baseFunc=baseFunc;
    }

    public MainPage verifyGiftCardsElementPresent(){
        List<WebElement> elements = baseFunc.findElements(giftCardMenu);
        int size = elements.size();
        assertEquals(size, 14, "WRONG SIZE");
        LOGGER.info("SubCategory size :" + size);
        return new MainPage(baseFunc);
    }


}
