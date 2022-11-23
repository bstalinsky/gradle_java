package com.amazon.pageobject.SearchPages;

import com.amazon.pageobject.basefunc.BaseFunc;
import org.openqa.selenium.By;

public class SearchPage {
    private BaseFunc baseFunc;
    private final By PRODUCT_SEARCH_LIST = By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']//div/h2/a/span");

    // FILTERS CHECKBOXES
    private final By MEN_SHOE_SIZE = By.xpath("//ul[@aria-labelledby='p_n_size_browse-vebin-title']/li//span[@class= 'a-list-item']//a//span//button/span");
    private final By FILTER_TYPE = By.xpath("//div[@class='a-popover-inner']//ul[@role='listbox']/li/a");
    private final By INPUT_LOW_PRICE = By.xpath("//input[@id='low-price']");
    private final By INPUT_HIGH_PRICE = By.xpath("//input[@id='high-price']");
    private final By GO_PRICE_BUT = By.xpath("//input[@class='a-button-input']");
    private final By SHOES_TYPE = By.xpath("//ul[@aria-labelledby='n-title']//li/span/a//span");
    private final By COLOR_TYPE = By.xpath("//ul[@aria-labelledby='p_n_size_two_browse-vebin-title']//span/a");
    private final By SELLER_CHECKBOX = By.xpath("//ul[@aria-labelledby = 'p_6-title']/li/span/a");
    private final By BRAND_CHECKBOX = By.xpath("//ul[@aria-labelledby='p_89-title']/li//a/span");


    public SearchPage(BaseFunc baseFunc){
        this.baseFunc=baseFunc;
    }

    public void chooseItem(String value){
        baseFunc.chooseCategory(PRODUCT_SEARCH_LIST , value);
    }
    public void menShoesSize(String value){
        baseFunc.chooseCategory(MEN_SHOE_SIZE , value);
    }
    public void inputPriceValue(String min, String max){
        baseFunc.type(INPUT_LOW_PRICE , min);
        baseFunc.type(INPUT_HIGH_PRICE , max);
        baseFunc.click(GO_PRICE_BUT);
    }

    public void selectCheckboxBRAND(String brand) throws InterruptedException {
        baseFunc.selectByAttributeCheckbox(BRAND_CHECKBOX , brand);
    }
}
