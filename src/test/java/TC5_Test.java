import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobjects.*;
import testdata.TC5;


public class TC5_Test {
    @Test(invocationCount = 3)
    public void TestCase5() throws InterruptedException {
        WebDriver driver = BasePage.initializeBrowser("chrome");
        HomePage home = new HomePage(driver);
        PayOrTransferPage payOrTransferPage  = new PayOrTransferPage(driver);


        home.navigateToPage("Pay or transfer");
        payOrTransferPage.chooseFromAccount(TC5.FROM_ACCOUNT.getName());
        payOrTransferPage.chooseToAccount(TC5.PAYEE_ACCOUNT_NUM.getName());
        payOrTransferPage.enterPayOrTransferDetails(TC5.PAY_OR_TRANSFER_DETAIL.getName());
        payOrTransferPage.clickButton("Transfer");
        payOrTransferPage.verifySuccessfulTransfer();


    }
}
