package test.java.testcases;

import main.java.pageEvents.Events;
import main.java.pageObjects.LoginPageObjects;
import main.java.testdata.dataFile;
import main.java.utilities.ElementFetch;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.java.base.BaseApp;

public class TC001_LoginTest extends BaseApp {
    ElementFetch elem = new ElementFetch();
    Events events = new Events();
    @Test(priority = 1)
    public void validUser() {

        SoftAssert sofass = new SoftAssert();
        BaseApp.logger.info("Verify login is displayed");
        boolean login = elem.getWebElement("XPATH", LoginPageObjects.LoginText).isDisplayed();
        Assert.assertTrue(login);
        String txt = elem.getWebElement("XPATH", LoginPageObjects.LoginText).getText();

        BaseApp.logger.info("Fill out Login form");
        sofass.assertEquals(txt, "LOGIN Panel", "Text Not equal");
        elem.getWebElement("XPATH", LoginPageObjects.UsernameInput).sendKeys(dataFile.username);
        elem.getWebElement("XPATH", LoginPageObjects.PasswordInput).sendKeys(dataFile.password);

        BaseApp.logger.info("Submit Login form");
        events.click("XPATH", LoginPageObjects.SubmitButton);

    }

    @Test(priority = 2)
    public void VerifyDashboard(){
        ElementFetch elem = new ElementFetch();
        BaseApp.logger.info("Verify login was successful");
        boolean DashLogo = elem.getWebElement("XPATH", LoginPageObjects.DashBoardLogo).isDisplayed();
        Assert.assertTrue(DashLogo);


    }
}
