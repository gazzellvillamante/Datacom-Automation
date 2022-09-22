package pageobjects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage {

    private WebDriver driver;
    private Logger log = LogManager.getLogger();

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button/span/span/span[text()='Menu']")
    private WebElement menuButton;

    protected final String MENU_OPTION = "//a[contains(@class, 'Button')]/span[text()='%s']";
    protected final String MENU_OPTION_2 = "//button/span[text()='%s']";



    public void navigateToPage(String pageName)  {
        clickElement(menuButton);

        if(driver.findElements(xpath(String.format(MENU_OPTION, pageName))).size() > 0){
            clickElement(driver.findElement(xpath(String.format(MENU_OPTION, pageName))));
            log.info("Navigated to page "+pageName);
        }
        else{
            clickElement(driver.findElement(xpath(String.format(MENU_OPTION_2, pageName))));
            log.info("Navigated to page "+pageName);
        }
    }


}
