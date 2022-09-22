package pageobjects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import testdata.TC2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.openqa.selenium.By.xpath;

public class PayeesPage extends BasePage{

    private WebDriver driver;
    private Logger log = LogManager.getLogger();

    public PayeesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id="ComboboxInput-apm-name")
    private WebElement payeeNameField;

    @FindBy(xpath="//button[contains(@class, 'js-submit Button')]")
    private WebElement modalAddButton;

    @FindBy(id="apm-bank")
    private WebElement apmBankField;

    @FindBy(id="apm-branch")
    private WebElement apmBranchField;

    @FindBy(id="apm-account")
    private WebElement apmAccountField;

    @FindBy(id="apm-suffix")
    private WebElement apmSuffixField;

    @FindBy(id="apm-this-particulars")
    private WebElement fyParticularsField;

    @FindBy(id="apm-this-code")
    private WebElement fyCodeField;

    @FindBy(id="apm-this-reference")
    private WebElement fyReferenceField;

    @FindBy(id="apm-that-particulars")
    private WebElement fpParticularsField;

    @FindBy(id="apm-that-code")
    private WebElement fpCodeField;

    @FindBy(id="apm-that-reference")
    private WebElement fpReferenceField;

    @FindBy(id="apm-identifier")
    private WebElement ampIdentifierField;

    @FindBy(id="ComboboxInput-apm-relationship")
    private WebElement ampRelationshipField;

    @FindBy(id="apm-payer-name")
    private WebElement apmPayerField;

    @FindBy(xpath="//button[contains(@class,'js-additional-details')]")
    private WebElement additionalDetails;

    @FindBy(xpath="//h2[text()='Additional Details']/following-sibling::div")
    private WebElement fieldSet;

    @FindBy(xpath="//div[@id='notification']/div[contains(@class,'show js-notificationShown')]")
    private WebElement notification;

    @FindBy(xpath="//input[contains(@class, 'SearchInput')]")
    private WebElement searchInputField;

    @FindBy(xpath="//div[@class='error-header']")
    private List<WebElement> errorMessage;

    @FindBy(xpath="//h3[contains(@aria-label,'Sort by payee')]")
    private WebElement sortButton;

    @FindBy(xpath="//span[@class='js-payee-name']")
    private List<WebElement> defaultOrder;

    @FindBy(xpath="//span[@class='js-payee-name']")
    private List<WebElement> descendingOrder;

    List<String> defaultlist = new ArrayList<>();
    List<String> descendinglist = new ArrayList<>();


    protected final String PAGE_HEADER = "//h1/span[text()='%s']";
    protected final String BUTTONS_XPATH = "//button/span[text()='%s']";
    protected final String BUTTONS_XPATH_2 = "//button[text()='%s']";
    protected final String PAYEE_LIST = "//p[@class='Avatar-title']/span[text()='%s']";


    public void clickName(){
        clickElement(sortButton);
        log.info("Sorted payee name");
    }

    public void clickButton(String buttonName) throws InterruptedException {
        Thread.sleep(500);
        if(driver.findElements(xpath(String.format(BUTTONS_XPATH_2, buttonName))).size() > 0) {

            clickElement(driver.findElement(xpath(String.format(BUTTONS_XPATH_2, buttonName))));

            log.info("Clicked "+ buttonName + " button.");

        } else if(driver.findElements(xpath(String.format(BUTTONS_XPATH, buttonName))).size() > 0){
                clickElement(driver.findElement(xpath(String.format(BUTTONS_XPATH, buttonName))));

            log.info("Clicked " + buttonName + " button.");
        }


    }

    public void enterPayeeDetails(String payeeName, String accountNum, String fyParticulars, String fyCode, String fyReference, String fPParticulars, String fPCode, String fPReference, String identifier, String relationship, String payerName) throws InterruptedException {

        enterValue(payeeNameField, payeeName);
        log.info("Entered "+ payeeName + " as payee name.");

        if(accountNum.length() == 16){
            enterValue(apmBankField, accountNum.substring(0,2));
            enterValue(apmBranchField,accountNum.substring(2, 6));
            enterValue(apmAccountField,accountNum.substring(6, 13));
            enterValue(apmSuffixField,accountNum.substring(13, 16));

            log.info("Entered "+ accountNum + " as account number.");
        }

        if(fyParticulars != ""){
            enterValue(fyParticularsField,fyParticulars);

            log.info("Entered "+ fyParticulars + " as \"For You\" particulars");

        }

        if(fyCode != ""){
            enterValue(fyCodeField, fyCode);

            log.info("Entered "+ fyCode + " as \"For You\" code");

        }

        if(fyReference != ""){
            enterValue(fyReferenceField, fyReference);

            log.info("Entered "+ fyReference + " as \"For You\" reference");
        }

        if(fPParticulars != ""){
            enterValue(fpParticularsField,fPParticulars);

            log.info("Entered "+ fPParticulars + " as \"For Payee\" particulars");

        }

        if(fPCode != ""){
            enterValue(fpCodeField, fPCode);
            log.info("Entered "+ fPCode + " as \"For Payee\" code");
        }

        if(fPReference != ""){
            enterValue(fpReferenceField, fPReference);

            log.info("Entered "+ fPReference + " as \"For Payee\" reference");
        }

        if(identifier != ""){
            if(!fieldSet.isDisplayed()) {
                clickElement(additionalDetails);
                enterValue(ampIdentifierField, identifier);
                enterValue(ampRelationshipField, relationship);
                enterValue(apmPayerField, payerName);

                log.info("Entered "+ identifier + " as \"For Payee\" identifier, " +relationship+ " as relationship and "+ payerName+ " as payerName");
            }
        }

    }

    public void verifyLoadedPage(String pageName) throws NoSuchElementException {
        waitElementVisible(driver.findElement(xpath(String.format(PAGE_HEADER, pageName))));

        if (driver.findElement(xpath(String.format(PAGE_HEADER, pageName))).isDisplayed()) {
            log.info(pageName + " page was successfully loaded");
            Assert.assertTrue(true, "PASSED. " + pageName + " page was successfully loaded");
        }

        else{
            log.error(pageName + " page was not successfully loaded");
            Assert.assertTrue(false, "FAILED. " + pageName + " page was not successfully loaded");
        }
//        screenshot();
    }

    public void verifyPayeeAdded() throws NoSuchElementException {
        waitElementVisible(notification);
        if (notification.isDisplayed()){
            enterValue(searchInputField, TC2.PAYEE_NAME.getName());

            if(driver.findElements(xpath(String.format(PAYEE_LIST, TC2.PAYEE_NAME.getName()))).size() > 0){
                log.info("Payee is added in the list of payees.");
                Assert.assertTrue(true, "PASSED. Payee is added in the list of payees.");
            }
            else{
                log.error("Payee is not added in the list of payees.");
                Assert.assertTrue(false, "FAILED. Payee is not added in the list of payees.");
            }
        }

    }

    public void verifyPageErrors(){
        if(errorMessage.size() >0){
            log.info("An error message was displayed");
            Assert.assertTrue(true, "PASSED. An error message was displayed.");
        }
        else{
            log.error("An error message was not displayed");
            Assert.assertTrue(false, "FAILED. Error message was not displayed.");
        }
    }

    public void verifyPageNoErrors(){
        if(errorMessage.size() ==0){
            log.info("An error message was displayed.");
            Assert.assertTrue(true, "PASSED. An error message was displayed.");
        }
        else{
            log.error("Error message was not displayed.");
            Assert.assertTrue(false, "FAILED. Error message was not displayed.");
        }

    }

    public void verifyAscendingOrder() throws InterruptedException {

        Thread.sleep(500);

        for(WebElement e: defaultOrder){
            defaultlist.add(String.valueOf(e.getText()));
        }

        List<String> ascendingList = defaultlist;

        Collections.sort(ascendingList);

        Assert.assertEquals(defaultlist,ascendingList);
        log.info("List is sorted in ascending order.");

    }

    public void verifyDescendingOrder(){

        for(WebElement e: descendingOrder){
            descendinglist.add(String.valueOf(e.getText()));
        }

        for(int i=0; i < descendinglist.size(); i++){
            System.out.println(descendinglist.get(i).toString());
        }

        Collections.sort(defaultlist, Collections.reverseOrder());

        for(int i=0; i < defaultlist.size(); i++){
            System.out.println(defaultlist.get(i).toString());
        }

        Assert.assertEquals(descendinglist,defaultlist);
        log.info("List is sorted in descending order.");

    }

}
