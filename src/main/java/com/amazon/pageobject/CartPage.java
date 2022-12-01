package com.amazon.pageobject;

import com.amazon.pageobject.basefunc.BaseFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.testng.Assert;

public class CartPage  {
    protected BaseFunc baseFunc;

    private final By DELETE_BUT = By.xpath("//input[@data-action = 'delete']");
    private final By removedAssert = By.xpath("//span[contains(text() , 'was removed from Shopping Cart.')]");
    private final By itemFound = By.xpath("//span[contains(text() , 'was removed from Shopping Cart.')]");



    public CartPage(BaseFunc baseFunc){
        this.baseFunc=baseFunc;
    }

    public CartPage deleteBut(){
        baseFunc.click(DELETE_BUT);
        return new CartPage(baseFunc);
    }
    public void deleteButassert(){
       String we = baseFunc.findElement(itemFound).getText();
       String error = baseFunc.findElement(removedAssert).getText();
        Assert.assertEquals(error, we );
    }

}
