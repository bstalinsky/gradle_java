package com.amazon.pageobject.SearchPages;

import com.amazon.pageobject.ItemPage;
import com.amazon.pageobject.basefunc.BaseFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SearchPage {
    private final BaseFunc baseFunc;
    private final By PRODUCT_SEARCH_LIST = By.xpath("//h2[@class = 'a-size-mini a-spacing-none a-color-base s-line-clamp-2']/a");
    private final By PRODUCT_SEARCH_LIST_FULL = By.xpath("//span[@class = 'a-size-base-plus a-color-base a-text-normal']");

    // FILTERS CHECKBOXES
    private final By MEN_SHOE_SIZE = By.xpath("//ul[@aria-labelledby='p_n_size_browse-vebin-title']/li//span[@class= 'a-list-item']//a//span//button/span");
    private final By FILTER_TYPE = By.xpath("//div[@class='a-popover-inner']//ul[@role='listbox']/li/a");
    private final By INPUT_LOW_PRICE = By.xpath("//input[@id='low-price']");
    private final By INPUT_HIGH_PRICE = By.xpath("//input[@id='high-price']");
    private final By GO_PRICE_BUT = By.xpath("//span[@class='a-button-text']");
    private final By SHOES_TYPE = By.xpath("//ul[@aria-labelledby='n-title']//li/span/a//span");
    private final By COLOR_TYPE = By.xpath("//ul[@aria-labelledby='p_n_size_two_browse-vebin-title']//span/a");
    private final By SELLER_CHECKBOX = By.xpath("//ul[@aria-labelledby = 'p_6-title']/li/span/a");
    private final By BRAND_CHECKBOX = By.xpath("//ul[@aria-labelledby='p_89-title']/li//a/span");
    private final By COMPUTER_LIST = By.xpath("//a[@data-routing = 'off']");
    private final By Monitors_category = By.id("n/1292115011");



    public SearchPage(BaseFunc baseFunc){
        this.baseFunc=baseFunc;
    }

    public ItemPage chooseItem(String value){
        baseFunc.chooseCategory(PRODUCT_SEARCH_LIST, value);
        return new ItemPage(baseFunc);
    }

    public ItemPage chooseItemFullMenu(String value){
        baseFunc.chooseCategory(PRODUCT_SEARCH_LIST_FULL, value);
        return new ItemPage(baseFunc);
    }

    public SearchPage menShoesSize(String value){
        baseFunc.selectByTextCheckbox(MEN_SHOE_SIZE , value);
        return this;
    }
    public SearchPage inputPriceValue(String min, String max){
        baseFunc.type(INPUT_LOW_PRICE , min);
        baseFunc.type(INPUT_HIGH_PRICE , max);
        baseFunc.pressKeys(Keys.ENTER);
        return this;

    }

    public SearchPage selectCheckboxBRAND(String brand) throws InterruptedException {
        baseFunc.selectByTextCheckbox(BRAND_CHECKBOX , brand);
        return this;
    }
    public SearchPage selectComputerCategory(String value){
        baseFunc.chooseCategory(COMPUTER_LIST , value);
//        baseFunc.findElements(COMPUTER_LIST).get(5).click();
        return new SearchPage(baseFunc);
    }

    public SearchPage selectMonitors(){
        baseFunc.findElement(Monitors_category).click();
        return new SearchPage(baseFunc);
    }


}
