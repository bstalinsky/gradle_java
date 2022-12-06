package com.amazon.pageobject.basefunc;

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
import java.util.Arrays;
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
        switch (PLATFORM_AND_BROWSER) {
            case "win_chrome":
                System.setProperty("webdriver.chrome.driver", "C:/Users/bohdan.stalinskyi/IdeaProjects/gradle_java/src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                LOGGER.info("Browser started with : " + "win_chrome");
                break;
            case "win_gecko":
                System.setProperty("webdriver.firefox.driver", "src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                LOGGER.info("Browser started with : " + "win_gecko");
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
        LOGGER.info("Move to element" + we.getText());

    }


    public static void openUrl(String url) {
        driver.get(url);}

    public void submit(By locator){
        WebElement we = wait.until(ExpectedConditions.elementToBeClickable(locator));
        we.submit();
    }

    public void click(By locator) {
        WebElement we = wait.until(ExpectedConditions.elementToBeClickable(locator));
        try {
            LOGGER.info("Try to click element" + we.getText());
            we.click();

        } catch (ElementClickInterceptedException e) {
            LOGGER.info("Cant click to element" + we.getText());

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
    public boolean getTitle(String value) {
        boolean title = driver.getTitle().equals(value);
        if(title){
            LOGGER.info("Correct title" + " " + title);
        } else {
            LOGGER.info("incorrect title" + " " + title);
        }
        return title;
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
        LOGGER.info("Press key : " + keys);
    }

    public void type(By locator, String text) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        WebElement inputField = driver.findElement(locator);
        inputField.clear();
        inputField.sendKeys(text);
        LOGGER.info("Type text" + text);
    }

    public void pressKey(By locator, Keys key) {
        findElement(locator).sendKeys(key);

    }


    public void selectMultiplieCheckbox(By locator , String... value) {
        LOGGER.info("Selected checkboxes : " + Arrays.toString(value));
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
        List<WebElement> checkboxes = driver.findElements(locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        for (WebElement we : checkboxes) {
            String checkboxname = we.getText();
            if (checkboxname.equals(value))
                try {
                    we.click();
                    LOGGER.info("Selected checkboxes : " +we);
                    break;
                } catch (org.openqa.selenium.StaleElementReferenceException e) {
                    LOGGER.info("Can't select checkboxes");
                    we.click();
                }
        }
    }

    public void select(By locator, String value) {
        Select select = new Select(findElement(locator));
        select.selectByValue(value);
        LOGGER.info("Select dropdown element" + value);
    }

    public void selectByVisibleText(By locator, String value) {
        Select select = new Select(findElement(locator));
        select.selectByVisibleText(value);
        LOGGER.info("Select dropdown element" + value);
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
        LOGGER.info("Find element : " + element.getText());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> elements = element.findElements(locator);
        for (WebElement item : elements) {
            LOGGER.info("Elements displayed : " + item.getText());
            if (item.getText().contains(value)) {
                try {
                    item.click();
                    LOGGER.info("Item choosen");
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
        for (WebElement item : elements) {
            if (item.getAttribute("id").contains(value)) {
                System.out.println("Checkbox name : "+ item.getAttribute("id"));
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
                    elements.get(value).click();

        }

        public void switchToTabLast(){
        for (String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
            LOGGER.info("Switch to tab : " + tab );
        }
        }




}

