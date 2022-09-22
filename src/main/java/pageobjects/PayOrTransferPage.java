package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.openqa.selenium.By.xpath;

public class PayOrTransferPage extends BasePage{

    private WebDriver driver;
    private Logger log = LogManager.getLogger();

    public PayOrTransferPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath="//button[@data-monitoring-label='Transfer Form From Chooser']")
    private WebElement transferFromElement;

    @FindBy(xpath="//button[@data-monitoring-label='Transfer Form To Chooser']")
    private WebElement transferToElement;

    @FindBy(xpath="//h2/span[text()='From']/parent::h2/following-sibling::div/span/span/input[@placeholder='Search']")
    private WebElement transferFromSearchElement;

    @FindBy(xpath="//h2/span[text()='To']/parent::h2/following-sibling::div/span/span/input[@placeholder='Search']")
    private WebElement transferToSearchElement;

    @FindBy(xpath="//button[@data-monitoring-label='Transfer Form Account Card']")
    private WebElement searchedAccount;

    @FindBy(name="amount")
    private WebElement amountField;

    @FindBy(xpath="//div[@id='notification']/div[contains(@class,'show js-notificationShown')]")
    private WebElement notification;


    protected final String BUTTONS_XPATH = "//button/span/span/span[text()='%s']";


    public void clickButton(String buttonName)  {

        clickElement(driver.findElement(xpath(String.format(BUTTONS_XPATH, buttonName))));

        log.info("Clicked "+ buttonName + " button.");
    }

    public void chooseFromAccount(String fromAccount) throws InterruptedException {
        clickElement(transferFromElement);
        waitElementVisible(transferFromSearchElement);
        enterValue(transferFromSearchElement, fromAccount);

        waitElementVisible(searchedAccount);
        action.moveToElement(searchedAccount).click().build().perform();

        log.info("Chosen "+ fromAccount + " as from account.");
    }

    public void chooseToAccount(String toAccount) throws InterruptedException{
        clickElement(transferToElement);
        waitElementVisible(transferToSearchElement);
        enterValue(transferToSearchElement, toAccount);

        waitElementVisible(searchedAccount);
        action.moveToElement(searchedAccount).click().build().perform();

        log.info("Chosen "+ toAccount + " as from account.");
    }

    public void enterPayOrTransferDetails(String amount)  {
        enterValue("amount",amount);

        log.info("Entered "+ amount + " as transfer amount.");
    }

    public void verifySuccessfulTransfer() throws NoSuchElementException {
        waitElementVisible(notification);
        if (notification.isDisplayed()){

            log.info("Successfully transferred.");
            Assert.assertTrue(true, "PASSED. Successfully transferred.");
        }
        else{

            log.error("Transfer failed.");
            Assert.assertTrue(false, "FAILED. Transfer failed.");
        }

    }

}








