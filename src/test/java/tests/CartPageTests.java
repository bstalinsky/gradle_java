package tests;

import com.amazon.pageobject.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.basetest.BasicTest;

public class CartPageTests extends BasicTest {

    @BeforeClass
    public void signIn(){
        new MainPage(baseFunc).clickSignIn().signIn("bstalinskyi@gmail.com", "Dsaewqxx!!");
    }
    @BeforeMethod
    public void addItemToCart(){
        new MainPage(baseFunc).inputSearchLineType("Jordan ").clickSearch().menShoesSize("9")
                .chooseItem("Men's Jordan 1 Mid Black/Fire Red-White (554724 078)")
               .addToCart();
    }
    @Test
    public void deleteItem() throws InterruptedException {
       new MainPage(baseFunc).goToCartBut().deleteBut().deleteButassert();
       Thread.sleep(5000);

    }


}
