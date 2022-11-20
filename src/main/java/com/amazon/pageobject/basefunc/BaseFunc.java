package com.amazon.pageobject.basefunc;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseFunc {


    private static WebDriver driver;
    private static WebDriverWait wait;

    public BaseFunc() {

    }

    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public static void openUrl(String url) {
        driver.get(url);
    }

    public void click(By locator) {

        WebElement we = wait.until(ExpectedConditions.elementToBeClickable(locator));
        try {
            we.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Can't click");
            we.click();
        }
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public void moveToElement(WebElement we) {
        Actions action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        action.moveToElement(we);
    }

    public void type(By locator, String text) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        WebElement inputField = driver.findElement(locator);
        inputField.clear();
        inputField.sendKeys(text);
    }

    public void pressKey(By locator, Keys key) {
        findElement(locator).sendKeys(key);
//        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//        WebElement we = driver.findElement(locator);
//
//        we.sendKeys(key);
    }

    public void select(By locator, String value) {
        Select select = new Select(findElement(locator));
        select.selectByValue(value);
    }

    public void selectByVisibleText(By locator, String value) {
        Select select = new Select(findElement(locator));
        select.selectByVisibleText(value);
    }

    public void tearDown() {
        driver.quit();

    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.dismiss();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void navigageTo(String url) {
        driver.navigate().to(url);
    }


    public void alertOK(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js  .executeAsyncScript("confirm", "Are you sure?");
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    public void chooseCategory(By locator, String value) {
        driver.findElement(locator);
        WebElement element = driver.findElement(locator);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> elements = element.findElements(locator);
        boolean flag = false;
        for (WebElement item : elements) {
            if (item.getText().equals(value)) {
                flag = true;
                try {
                    item.click();
                } catch (ElementClickInterceptedException e) {
                    item.click();
                }
                break;
            }

        }

    }

}

