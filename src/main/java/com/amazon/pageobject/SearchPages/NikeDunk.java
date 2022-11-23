package com.amazon.pageobject.SearchPages;

import com.amazon.pageobject.basefunc.BaseFunc;
import org.openqa.selenium.By;

public class NikeDunk {
    protected BaseFunc baseFunc;

    private final By PRODUCT_SEARCH_LIST = By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']//div/h2/a/span");

    public NikeDunk (BaseFunc baseFunc){
        this.baseFunc=baseFunc;
    }


    public void nikeDunkAirListGet(String value){
        baseFunc.chooseCategory(PRODUCT_SEARCH_LIST , value);
    }
}
