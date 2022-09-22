import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobjects.BasePage;
import pageobjects.HomePage;
import pageobjects.PayeesPage;
import testdata.TC4;

public class TC4_Test {
    @Test
    public void TestCase4() throws InterruptedException {
        WebDriver driver = BasePage.initializeBrowser("chrome");
        HomePage home = new HomePage(driver);
        PayeesPage payees  = new PayeesPage(driver);


        home.navigateToPage("Payees");
        payees.clickButton("Add");
        payees.enterPayeeDetails(TC4.PAYEE_NAME.getName(), TC4.PAYEE_ACCOUNT_NUM.getName(), TC4.FOR_YOU_PARTICULAR.getName(),
                TC4.FOR_YOU_CODE.getName(), TC4.FOR_YOU_REFERENCE.getName(), TC4.FOR_PAYEE_PARTICULAR.getName(),
                TC4.FOR_PAYEE_CODE.getName(), TC4.FOR_PAYEE_REFERENCE.getName(), TC4.IDENTIFIER.getName(),
                TC4.RELATIONSHIP.getName(), TC4.PAYER_NAME.getName());
        payees.clickButton("Add");
        payees.verifyAscendingOrder();
        payees.clickName();
        payees.verifyDescendingOrder();



    }
}
