package tests.amazon;

import com.amazon.mainpagesteps.pageobjectVerify.MainPageAssert;
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

    private String VERIFY_NO_RESULTS = "тестинг11";

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
                .clickSearch().chooseItemFullMenu("Nike Dunk Low Retro Mens Style : Dd1391");
        Assert.assertEquals("Nike dunk", "Nike dunk");
    }

    @Test
    public void selectAdidasAndFilters() throws InterruptedException {
        new MainPage(baseFunc)
                .inputSearchLineType("shoes").clickSearch()
                .selectCheckboxBRAND("adidas")
                .inputPriceValue("50", "300")
                .menShoesSize("10")
                .menShoesSize("10.5");
    }

    @Test
    public void addItemToCartWithFilters() throws InterruptedException {
        selectAdidasAndFilters();
        new SearchPage(baseFunc).chooseItemFullMenu("adidas Men's Kaptir 2.0 Running Shoe")
                        .selectSize("8")
//                .quantitySelect("2")
                .selectColor(3)
                .addToCart()
                .assertItemAdded();
    }

    @Test
    public void inputWrongItemIntoSearchLine(){
        new MainPage(baseFunc).selectCategory("Deals")
                .inputSearchLineType("тестинг11").clickSearch();
        new MainPageAssert(baseFunc).verifyWrongItem(VERIFY_NO_RESULTS);
    }

}
