package pageobjects;

import enums.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.time.Duration;

import static org.openqa.selenium.By.xpath;


public class BasePage {


    static WebDriver driver;

    public static WebDriver initializeBrowser(String browser) {
        System.out.println(Constants.CHROME_DRIVER_PATH.getName());
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH.getName());

            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");

            driver = new ChromeDriver(options);
        }
        else{
            System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER_PATH.getName());

            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

        }

        driver.get(Constants.URL.getName());

        return driver;
    }

    Actions action = new Actions(driver);

    @AfterMethod
    public static void tearDown() {
        driver.close();
        driver.quit();
    }

    protected final String FIELD_XPATH = "//input[@name='%s']";


    public void waitElementVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickElement(WebElement element) {
        waitElementToBeClickable(element);
        element.click();
    }

    public void enterValue(WebElement field, String value) {
        waitElementVisible(field);
        field.clear();
        field.sendKeys(value + Keys.ENTER);

    }

    public void enterValue(String field, String value) {
        driver.findElement(xpath(String.format(FIELD_XPATH, field))).clear();
        driver.findElement(xpath(String.format(FIELD_XPATH, field))).sendKeys(value);

    }


}
