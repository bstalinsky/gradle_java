package com.amazon.pageobject;

import org.openqa.selenium.By;

public class MainPage {
    private final By dissmissCountry = By.xpath("//input[@data-action-params='{\"toasterType\":\"AIS_INGRESS\"}']");
    private final By cartButton = By.xpath("//span[@id='nav-cart-count']");
    private final By menuLangList = By.xpath("//div[@class = 'a-row a-spacing-mini']");
    private final By menuLangNavigate = By.xpath("//div[@id='nav-tools']//a//span[@class='icp-nav-link-inner']");
    private final By searchLine = By.xpath("//input[@id='twotabsearchtextbox']");
    private final By searchLineBut = By.xpath("//input[@id='nav-search-submit-button']");

}
