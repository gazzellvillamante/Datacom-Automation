import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobjects.BasePage;
import pageobjects.HomePage;
import pageobjects.PayeesPage;
import testdata.TC2;

public class TC2_Test {

    @Test
    public void TestCase2() throws InterruptedException {
        WebDriver driver = BasePage.initializeBrowser("chrome");
        HomePage home = new HomePage(driver);
        PayeesPage payees  = new PayeesPage(driver);


        home.navigateToPage("Payees");
        payees.clickButton("Add");
        payees.enterPayeeDetails(TC2.PAYEE_NAME.getName(), TC2.PAYEE_ACCOUNT_NUM.getName(), TC2.FOR_YOU_PARTICULAR.getName(),
                TC2.FOR_YOU_CODE.getName(), TC2.FOR_YOU_REFERENCE.getName(), TC2.FOR_PAYEE_PARTICULAR.getName(),
                TC2.FOR_PAYEE_CODE.getName(), TC2.FOR_PAYEE_REFERENCE.getName(), TC2.IDENTIFIER.getName(),
                TC2.RELATIONSHIP.getName(), TC2.PAYER_NAME.getName());
        payees.clickButton("Add");
        payees.verifyPayeeAdded();


    }
}
