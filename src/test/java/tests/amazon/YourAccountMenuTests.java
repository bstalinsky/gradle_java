package tests.amazon;

import com.amazon.pageobject.signInMenu.SignInPage;
import com.amazon.pageobject.signInMenu.YourAccountMenu;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import tests.basetest.BasicTest;

public class YourAccountMenuTests extends BasicTest {
        SignInTests signInTests;

    @Test(groups = {"smoke"})
    public void totalQuantityYourAccount(){
        new YourAccountMenu(baseFunc).clickYourAccount().clickYourOrders();
    }
}
