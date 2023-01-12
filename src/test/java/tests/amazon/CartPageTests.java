package tests.amazon;

import com.amazon.pageobject.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.basetest.BasicTest;

public class CartPageTests extends BasicTest {

    @BeforeMethod(groups = {"smoke"})
    public void addItemToCart(){
        new MainPage(baseFunc).inputSearchLineType("Jordan ").clickSearch().menShoesSize("9")
                .chooseItemFullMenu("Nike Mens Dunk High DD1399 102 Game Royal - Size")
               .addToCart();
    }
    @Test(groups = {"smoke"})
    public void deleteItem() {
       new MainPage(baseFunc).goToCartBut().deleteBut().deleteButassert();


    }


}
