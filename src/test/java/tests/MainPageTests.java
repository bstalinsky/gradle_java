package tests;

import com.amazon.pageobject.MainPage;
import com.amazon.pageobject.SignInPage;
import org.testng.annotations.Test;
import tests.basetest.BasicTest;

public class MainPageTests extends BasicTest {
    private  String VALUE_FOR_NIKE_DUNK = "Nike Womens Dunk Low WMNS DD1503 101 Black/White";

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





}
