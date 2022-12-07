package tests.amazon;

import com.amazon.pageobject.MainPage;
import com.amazon.pageobject.SignInPage;
import org.testng.annotations.Test;
import tests.basetest.BasicTest;

public class MainPageTests extends BasicTest {

   @Test(groups = {"smoke"}, priority = 4)
    public SignInPage goToSignIn(){
        MainPage mainPage = new MainPage(baseFunc);
        mainPage.clickSignIn();
        return new SignInPage(baseFunc);

    }

    @Test(groups = {"smoke"} , priority = 5)
    public void checkLogo(){
       new MainPage(baseFunc).logoIsDisplayed().verifyLogo();
    }

    @Test(groups = {"smoke"} , priority = 6)
    public void checkGetTitle(){
        new MainPage(baseFunc).getTitle().getTitleAssert();
    }

    @Test(groups = {"smoke"}, priority = 2)
    public void deliveryChangeMenuSelect() throws InterruptedException {
       new MainPage(baseFunc).clickOnDeliverTo()
               .selectDeliveryCountry("Canada").clickDoneBut().verifyDeliveryCountry();
    }

    @Test(groups = {"smoke"}, priority = 1)
    public void changeCountryLegion() {
        new MainPage(baseFunc).moveToLangMenu().clickChangeCountyRegion()
                .selectRegion("Canada").clickGoToWebsite()
                .assertCanadaLocation();
    }

    @Test(groups = {"smoke"}, priority = 7)
    public void checkHumberMenu()  {
       new MainPage(baseFunc).clickOnHamberMenu().selectCatFromHamMenu()
               .verifyGiftCardsElementPresent().selectGiftCardsSubCategory();
    }


    @Test(groups = {"sanity"}, priority = 3)
    public void e2eComputerCategoryTest() {
//       deliveryChangeMenuSelect();
       new  MainPage(baseFunc).selectCategory("Computers")
               .inputSearchLineType("Macbook")
               .clickSearch()
               .selectComputerCategory("Computers & Tablets")
               .inputPriceValue("300", "3000")
               .chooseItem("Apple MacBook Pro (13-inch, 8GB RAM, 256GB SSD Storage, Magic Keyboard) - Space Gray (Renewed)")
//               .quantitySelect("2")
               .addToCart()
               .assertItemAdded()
               .goToCartBut().deleteBut().deleteButassert();

    }




}
