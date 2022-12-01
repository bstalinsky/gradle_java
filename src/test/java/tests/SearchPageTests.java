package tests;

import com.amazon.pageobject.ItemPage;
import com.amazon.pageobject.MainPage;
import com.amazon.pageobject.SearchPages.SearchPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import tests.basetest.BasicTest;


public class SearchPageTests extends BasicTest {
    protected MainPage mainPage = new MainPage(baseFunc);
    private String VALUE_FOR_NIKE_DUNK = "Nike Womens Dunk Low WMNS DD1503 101 Black/White";

    @Test
    public void findNikeCategory() {
        new MainPage(baseFunc).inputSearchLineType("Jordan retro")
                .clickSearch();
        mainPage.clickSearch();
        Assert.assertEquals("Nike dunk", "Nike dunk");
    }

    @Test
    public void selectNikeItem() {
        mainPage.inputSearchLineType("Nike Dunk low")
                .clickSearch().chooseItem("Nike Dunk Low Retro Mens Style : Dd1391");
        Assert.assertEquals("Nike dunk", "Nike dunk");
    }

    @Test
    public void selectUnderArmourAndFilters() throws InterruptedException {

        new MainPage(baseFunc)
                .inputSearchLineType("shoes").clickSearch()
                .selectCheckboxBRAND("adidas")
                .inputPriceValue("50", "300")
                .menShoesSize("10")
                .menShoesSize("10.5");
    }

    @Test
    public void addItemToCartWithFilters() throws InterruptedException {
        selectUnderArmourAndFilters();
        new SearchPage(baseFunc).chooseItem("adidas Men's Ultraboost 5.0 Alphaskin Running")
                        .selectSize("8")
//                .quantitySelect("2")
                .selectColor(3)
                .addToCart()
                .assertItemAdded();
    }

}
