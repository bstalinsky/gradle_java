package tests.amazon;

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
    @BeforeMethod(groups = {"negative"})
    public void addItemToCart(){
        new MainPage(baseFunc).inputSearchLineType("Jordan ").clickSearch().menShoesSize("9")
                .chooseItemFullMenu("Men's Jordan 1 Mid Black/Fire Red-White (554724 078)")
               .addToCart();
    }
    @Test(groups = {"negative"})
    public void deleteItem()  {
       new MainPage(baseFunc).goToCartBut().deleteBut().deleteButassert();

    }


}
