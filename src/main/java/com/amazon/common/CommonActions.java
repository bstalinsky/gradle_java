package com.amazon.common;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.amazon.common.Config.PLATFORM_AND_BROWSER;
public class CommonActions {

//    public static WebDriver createDriver() {
//     WebDriver driver = null;
//
//        switch (PLATFORM_AND_BROWSER) {
//            case "win_chrome":
//                System.setProperty("webdriver.chrome.driver", "C:/Users/bohdan.stalinskyi/IdeaProjects/gradle_java/src/main/resources/chromedriver.exe");
//                driver = new ChromeDriver();
//                break;
//            case "win_gecko":
//                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//                driver = new FirefoxDriver();
//            default:
//                Assert.fail("Incorrect platform or browser nae" + PLATFORM_AND_BROWSER);
//                break;
//        }
//        driver.manage().window().maximize();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
//        return driver;
//
//    }


}
