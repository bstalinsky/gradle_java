package com.amazon.pageobject;

import org.openqa.selenium.By;

public class MainPage {
    private final By dissmissCountry = By.xpath("//input[@data-action-params='{\"toasterType\":\"AIS_INGRESS\"}']");
    private final By cartButton = By.xpath("//span[@id='nav-cart-count']");
    private final By menuLangList = By.xpath("//div[@class = 'a-row a-spacing-mini']");
    private final By menuLangNavigate = By.xpath("//div[@id='nav-tools']//a//span[@class='icp-nav-link-inner']");
    private final By searchLine = By.xpath("//input[@id='twotabsearchtextbox']");
    private final By searchLineBut = By.xpath("//input[@id='nav-search-submit-button']");
    private final By searchDropDownBox = By.xpath("//select[@id='searchDropdownBox']");
    private final By amazonLogo = By.xpath("//a[@id='nav-logo-sprites']");

    private final By navBarBut = By.xpath("//i[@class='hm-icon nav-sprite']");
    private final By navBarMenuList = By.xpath("//ul[@class='hmenu hmenu-visible']//li");
    private final By signInMenuBut = By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
    private final By signInBut = By.xpath("//div[@id='nav-al-signin']//div//a//span");
    private final By yourAccountList = By.xpath("//*[@id='nav-al-your-account']//a");
    private final By saleBut = By.xpath("//a[normalize-space()='Sell']");



}
