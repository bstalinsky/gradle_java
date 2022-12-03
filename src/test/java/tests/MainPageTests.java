package tests;

import com.amazon.pageobject.MainPage;
import com.amazon.pageobject.SignInPage;
import org.testng.annotations.Test;
import tests.basetest.BasicTest;

public class MainPageTests extends BasicTest {
    private final String MONITORS_ITEMS = "Portable Monitor for Laptop, Full HD IPS 1080P Display Laptop Screen Extender, Dual Laptop Monitor Screen";

   @Test
    public SignInPage goToSignIn(){
        MainPage mainPage = new MainPage(baseFunc);
        mainPage.clickSignIn();
        return new SignInPage(baseFunc);

    }

    @Test
    public void deliveryChangeMenuSelect() throws InterruptedException {
       new MainPage(baseFunc).clickOnDeliverTo()
               .selectDeliveryCountry("Canada").clickDoneBut().verifyDeliveryCountry();
    }

    @Test
    public void changeCountryLegion() throws InterruptedException {
        new MainPage(baseFunc).moveToLangMenu().clickChangeCountyRegion()
                .selectRegion("Canada").clickGoToWebsite()
                .assertCanadaLocation();
    }


    @Test
    public void e2eComputerCategoryTest() throws InterruptedException {
       new  MainPage(baseFunc).selectCategory("Computers")
               .inputSearchLineType("Macbook")
               .clickSearch()
               .selectComputerCategory("Computers & Tablets")
               .inputPriceValue("300", "2500")
               .chooseItem("Apple MacBook Pro (13-inch, 8GB RAM, 256GB SSD Storage, Magic Keyboard) - Space Gray (Renewed)")
               .quantitySelect("2")
               .addToCart()
               .assertItemAdded()
               .goToCartBut().deleteBut().deleteButassert();

       Thread.sleep(7000);
    }




}
