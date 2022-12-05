package com.amazon.pageobject.basefunc;

import com.amazon.common.CommonActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static com.amazon.common.Config.CLEAR_COOKIES_AND_STORAGE;
import static com.amazon.common.Config.PLATFORM_AND_BROWSER;

public class BaseFunc {


    protected static WebDriver driver;
    private static WebDriverWait wait;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());


    public BaseFunc() {
    }


    public void setUP() {
//        WebDriver driver = null;
        switch (PLATFORM_AND_BROWSER) {
            case "win_chrome":
                System.setProperty("webdriver.chrome.driver", "C:/Users/bohdan.stalinskyi/IdeaProjects/gradle_java/src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "win_gecko":
                System.setProperty("webdriver.firefox.driver", "src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                Assert.fail("Incorrect platform or browser nae" + PLATFORM_AND_BROWSER);
        }
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    }

    public void moveToElement(By locator){
        WebElement we = driver.findElement(locator);
      new Actions(driver)
              .moveToElement(we).build().perform();
    }


    public static void openUrl(String url) {driver.get(url);}

    public void submit(By locator){
        WebElement we = wait.until(ExpectedConditions.elementToBeClickable(locator));
        we.submit();
    }

    public void click(By locator) {
        LOGGER.info("Click to element" + locator);
        WebElement we = wait.until(ExpectedConditions.elementToBeClickable(locator));
        try {
            we.click();

        } catch (ElementClickInterceptedException e) {
            System.out.println("Can't click");
            we.click();
        }
    }

    public void cleanCookies(){
        LOGGER.info("CLEAN COOKIES");
        if (CLEAR_COOKIES_AND_STORAGE){
            JavascriptExecutor js = (JavascriptExecutor)driver;
            driver.manage().deleteAllCookies();
            js.executeScript("window.sessionStorage.clear()");
        }

    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public void pressKeys(Keys keys ) {
        Actions action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        action.sendKeys(Keys.ENTER).build().perform();
    }

    public void type(By locator, String text) {
        LOGGER.info("Type text" + text);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        WebElement inputField = driver.findElement(locator);
        inputField.clear();
        inputField.sendKeys(text);
    }

    public void pressKey(By locator, Keys key) {
        findElement(locator).sendKeys(key);

    }


    public void selectMultiplieCheckbox(By locator , String... value) {
        LOGGER.info("Selected checkboxes : " +value);
        List<WebElement> checkboxname = driver.findElements(locator);
        if (!value[0].equalsIgnoreCase("all")){
            for (WebElement item : checkboxname){
                String text =item.getText();
                for (String val:value){
                    if(text.equals(val)){
                        item.click();
                        break;
                    }
                }
            }
        } else{
            for (WebElement item : checkboxname){
                item.click();
            }
        }
    }

    public void selectAllCheckboxes(By locator){
        List<WebElement> checkboxes = driver.findElements(locator);
        for (WebElement we: checkboxes) {
            we.click();
        }
    }

    public void selectByTextCheckbox(By locator , String value ) {
        LOGGER.info("Selected checkboxes : " +value);
        List<WebElement> checkboxes = driver.findElements(locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        for (WebElement we : checkboxes) {
            String checkboxname = we.getText();
            if (checkboxname.equals(value))
                try {
                    we.click();
                    break;
                } catch (org.openqa.selenium.StaleElementReferenceException e) {
                    System.out.println("Can't click");
                    we.click();
                }
        }
    }

    public void select(By locator, String value) {
        LOGGER.info("Select dropdown element" + value);
        Select select = new Select(findElement(locator));
        select.selectByValue(value);
    }

    public void selectByVisibleText(By locator, String value) {
        LOGGER.info("Select dropdown element" + value);

        Select select = new Select(findElement(locator));
        select.selectByVisibleText(value);
    }

    public void selectByIndex(By locator, Integer value) {
        Select select = new Select(findElement(locator));
        select.selectByIndex(value);
    }

    public void tearDown() {
        LOGGER.info("TESTING FINISHED");
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

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }


    public void chooseCategory(By locator, String value) {
        LOGGER.info("Category : " + value);
        driver.findElement(locator);
        WebElement element = driver.findElement(locator);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> elements = element.findElements(locator);
        boolean flag = false;
        for (WebElement item : elements) {
                System.out.println("Text " + item.getText());
            if (item.getText().contains(value)) {
                System.out.println("Name  : "+ item.getText());
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

    public void chooseCategory1(By locator, String value) {
        driver.findElement(locator);
        WebElement element = driver.findElement(locator);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> elements = element.findElements(locator);
        boolean flag = false;
        for (WebElement item : elements) {
            if (item.getAttribute("id").contains(value)) {
                System.out.println("Checkbox name : "+ item.getAttribute("id"));
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

    public void clickByArrayNumb(By locator, int value) {
        WebElement element = driver.findElement(locator);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> elements = element.findElements(locator);
                System.out.println("Color list  : "+ elements.size());
                try {
                    elements.get(value).click();
                } catch (ElementClickInterceptedException e) {
                    elements.get(value);
                }

        }

        public void switchToTabLast(){
        for (String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }
        }




}

