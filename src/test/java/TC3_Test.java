import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobjects.BasePage;
import pageobjects.HomePage;
import pageobjects.PayeesPage;
import testdata.TC3;

public class TC3_Test {
    @Test
    public void TestCase3() throws InterruptedException {
        WebDriver driver = BasePage.initializeBrowser("chrome");
        HomePage home = new HomePage(driver);
        PayeesPage payees  = new PayeesPage(driver);


        home.navigateToPage("Payees");
        payees.clickButton("Add");
        payees.clickButton("Add");
        payees.verifyPageErrors();
        payees.enterPayeeDetails(TC3.PAYEE_NAME.getName(), TC3.PAYEE_ACCOUNT_NUM.getName(), TC3.FOR_YOU_PARTICULAR.getName(),
                TC3.FOR_YOU_CODE.getName(), TC3.FOR_YOU_REFERENCE.getName(), TC3.FOR_PAYEE_PARTICULAR.getName(),
                TC3.FOR_PAYEE_CODE.getName(), TC3.FOR_PAYEE_REFERENCE.getName(), TC3.IDENTIFIER.getName(),
                TC3.RELATIONSHIP.getName(), TC3.PAYER_NAME.getName());
        payees.verifyPageNoErrors();
    }
}
