package com.amazon.pageobject;

import com.amazon.mainpagesteps.pageobjectVerify.MainPageAssert;
import com.amazon.pageobject.basefunc.BaseFunc;
import org.openqa.selenium.By;

public class ItemPage {
    private final BaseFunc baseFunc;


    private final By QUANTITY_DROPDOWN = By.id("quantity");
    private final By ADD_TO_CART_BUT = By.xpath("//input[@id='add-to-cart-button']");
    private final By BUY_NOW_BUT = By.id("buy-now-button");
    private final By ADD_TO_LIST_BUT = By.id("wishListMainButton");
    private final By SELECT_SIZE = By.name("dropdown_selected_size_name");
    private final By CHOOSE_COLOR = By.xpath("//ul[@role='radiogroup']//li[@class = 'swatchAvailable']");



    public ItemPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public ItemPage quantitySelect(String quantity) {
        baseFunc.select(QUANTITY_DROPDOWN, quantity);
        return this;
    }
    public ItemPage selectSize(String size) {
        baseFunc.selectByVisibleText(SELECT_SIZE, size);
        return this;
    }


    public MainPageAssert addToCart(){
        baseFunc.click(ADD_TO_CART_BUT);
        return new MainPageAssert(baseFunc);
    }


    public void buyNowBut(){
        baseFunc.click(BUY_NOW_BUT);
    }
    public void addToListBut(){
        baseFunc.click(ADD_TO_LIST_BUT);
    }

    public ItemPage selectColor(int value){
        baseFunc.clickByArrayNumb(CHOOSE_COLOR , value);
        return this;
    }

}
