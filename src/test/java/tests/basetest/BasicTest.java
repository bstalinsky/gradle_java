
package tests.basetest;

import com.amazon.pageobject.MainPage;
import com.amazon.pageobject.basefunc.BaseFunc;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import tests.MainPageTests;


public abstract class BasicTest {

    protected final String HOME_PAGE_URL = "https://www.amazon.com/";
    public BaseFunc baseFunc = new BaseFunc();

    @BeforeTest
    public void setUp() throws InterruptedException {
        baseFunc.setUP();
        BaseFunc.openUrl(HOME_PAGE_URL);
    }

    @BeforeClass
    public void deliveryChangeMenuSelect() throws InterruptedException {
        new MainPage(baseFunc).clickOnDeliverTo()
                .selectDeliveryCountry("Canada").clickDoneBut().verifyDeliveryCountry();
    }


    @AfterMethod
    public void openUrl(){
        BaseFunc.openUrl(HOME_PAGE_URL);
    }


    @AfterTest
    public void tearDown() {
        baseFunc.tearDown();
    }
}

