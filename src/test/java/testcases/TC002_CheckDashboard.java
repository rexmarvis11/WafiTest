package test.java.testcases;
import main.java.pageEvents.Events;
import main.java.pageObjects.DashboardPageObj;
import main.java.utilities.ElementFetch;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import test.java.base.BaseApp;
import main.java.pageEvents.Events;
import javax.swing.*;

public class TC002_CheckDashboard extends BaseApp{
    ElementFetch elem = new ElementFetch();
    Events events = new Events();

    @Test(priority = 1)
    public void loginToApp() {
        BaseApp.logger.info("Login to App");
        TC001_LoginTest logNow = new TC001_LoginTest();
        logNow.validUser();
    }
    @Test(priority = 2)
    public void accessJobTitlePage(){
      events.hover("XPATH", DashboardPageObj.menu_admin );

    }
}
