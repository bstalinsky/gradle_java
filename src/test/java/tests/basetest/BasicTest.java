
package tests.basetest;

import com.amazon.common.CommonActions;
import com.amazon.pageobject.MainPage;
import com.amazon.pageobject.basefunc.BaseFunc;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public abstract class BasicTest {

    protected final String HOME_PAGE_URL = "https://www.amazon.com/";
//    protected static WebDriver driver = CommonActions.createDriver();
    public BaseFunc baseFunc = new BaseFunc();

    @BeforeTest
    public void setUp() {
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

