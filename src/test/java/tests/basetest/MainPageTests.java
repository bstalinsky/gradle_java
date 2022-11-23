package tests.basetest;

import com.amazon.pageobject.MainPage;
import com.amazon.pageobject.SearchPages.NikeDunk;
import com.amazon.pageobject.SearchPages.SearchPage;
import com.amazon.pageobject.basefunc.BaseFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.testng.Assert;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class MainPageTests extends BasicTest{
    private  String VALUE_FOR_NIKE_DUNK = "Nike Womens Dunk Low WMNS DD1503 101 Black/White";

   @Test
    public void goToSignIn(){
        MainPage mainPage = new MainPage(baseFunc);
        mainPage.clickSignIn();

    }





}
