package com.amazon.mainpagesteps.pageobjectVerify;

import com.amazon.pageobject.CartPage;
import com.amazon.pageobject.MainPage;
import com.amazon.pageobject.basefunc.BaseFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.testng.Assert.*;

public class MainPageAssert {
    private final BaseFunc baseFunc;
    private final By deliveryCountryAssert = By.xpath("//span[@id='glow-ingress-line2']");
    private final By ADD_TO_CART_SUCC_MES = By.xpath("//*[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']/span");
    private final By CANADA_LANG_ICON = By.xpath("//span[@class='icp-nav-flag icp-nav-flag-ca icp-nav-flag-discoverability-t1']");
    private final By VERIFY_NORESULT = By.xpath("//span[contains(text() , 'No results for')]");




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



    public MainPageAssert (BaseFunc baseFunc){
        this.baseFunc=baseFunc;
    }


}
