package com.amazon.pageobject;

import org.openqa.selenium.By;

public class LanguageSettings {

    private final By menuLangList = By.xpath("//a[@id='icp-nav-flyout']//span");
    private final By menuLangNavigate = By.xpath("//div[@id='nav-tools']//a//span[@class='icp-nav-link-inner']");
    private final By LANG_EN = By.xpath("//div[@id='nav-flyout-icp']//i[contains(@class,'icp-radio icp-radio-active')]");
    private final By LANG_DE = By.xpath("//div[@id='nav-flyout-icp']//a[1]//span[1]//i[1]");
}
