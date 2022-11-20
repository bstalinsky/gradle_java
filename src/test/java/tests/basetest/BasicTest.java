
package tests.basetest;

import com.amazon.pageobject.basefunc.BaseFunc;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public abstract class BasicTest {

    protected final String HOME_PAGE_URL = "https://www.amazon.com/";
    public BaseFunc baseFunc = new BaseFunc();

    @BeforeMethod
    public void openURL() {
        baseFunc.setUP();
        BaseFunc.openUrl(HOME_PAGE_URL);
    }

    @AfterMethod
    public void tearDown() {
        baseFunc.tearDown();
    }
}

