import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobjects.*;


public class TC1_Test {

    @Test
    public void TestCase1() throws InterruptedException {

        WebDriver driver = BasePage.initializeBrowser("chrome");
        HomePage home = new HomePage(driver);
        PayeesPage payees  = new PayeesPage(driver);

        home.navigateToPage("Payees");
        payees.verifyLoadedPage("Payees");

    }
}
