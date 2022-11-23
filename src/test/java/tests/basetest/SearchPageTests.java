package tests.basetest;

import com.amazon.pageobject.ItemPage;
import com.amazon.pageobject.MainPage;
import com.amazon.pageobject.SearchPages.SearchPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;


public class SearchPageTests extends BasicTest{
    private  String VALUE_FOR_NIKE_DUNK = "Nike Womens Dunk Low WMNS DD1503 101 Black/White";
    private final By ADD_TO_CART_SUCC_MES = By.xpath("//*[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']/span");


    @Test
    public void findNikeCategory(){
        MainPage mainPage = new MainPage(baseFunc);
        mainPage.inputSearchLineType("Nike dunk low");
        mainPage.clickSearch();
        Assert.assertEquals("Nike dunk", "Nike dunk");
    }
    @Test
    public void chooseItem(){
        findNikeCategory();
        SearchPage searchPage = new SearchPage(baseFunc);
        searchPage.chooseItem(VALUE_FOR_NIKE_DUNK);
    }

    @Test
    public void selectBrandsCheckboxes() throws InterruptedException {
        MainPage mainPage = new MainPage(baseFunc);
        mainPage.inputSearchLineType("shoes");
        mainPage.clickSearch();
        SearchPage searchPage = new SearchPage(baseFunc);
        searchPage.selectCheckboxBRAND("Under Armour");
        searchPage.inputPriceValue("50" , "300");
        searchPage.menShoesSize("10" );
        searchPage.menShoesSize("10.5" );
    }

    @Test
    public void addItemToCartWithFilters() throws InterruptedException {
        selectBrandsCheckboxes();
        SearchPage searchPage = new SearchPage(baseFunc);
        Thread.sleep(5000);
        searchPage.chooseItem("Under Armour Men's Charged Assert 9 Running Shoe");
        Thread.sleep(5000);
        ItemPage itemPage = new ItemPage(baseFunc);
        itemPage.selectSize("8");
        itemPage.quantitySelect("5");
        itemPage.selectColor(1);


        itemPage.addToCart();
        String assertion = baseFunc.getText(ADD_TO_CART_SUCC_MES);
        WebElement assertion1 = baseFunc.findElement(ADD_TO_CART_SUCC_MES);
        Assert.assertEquals(assertion, "Added to Cart" , "Something wrong");
        Assert.assertFalse(assertion.isEmpty() , "Element " + assertion + "is empty");
        Assert.assertTrue(assertion1.isDisplayed(), "Element " + assertion1 + "not Displayed");
    }

}
