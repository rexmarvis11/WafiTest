package test.java.testcases;

import main.java.pageEvents.Events;
import main.java.pageObjects.HomePageObjects;
import main.java.testdata.dataFile;
import main.java.utilities.ElementFetch;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.java.base.BaseApp;

import java.time.Duration;

public class HomePage extends BaseApp {
    ElementFetch elem = new ElementFetch();
    Events events = new Events();
    @Test(priority = 1)
    public void RegisterEmployee() {
        BaseApp.logger.info("Fill out Employee form");
        elem.getWebElement("XPATH", HomePageObjects.EmployeeID).sendKeys(dataFile.employeeID);
        elem.getWebElement("XPATH", HomePageObjects.EmployeeName).sendKeys(dataFile.name);
        elem.getWebElement("XPATH", HomePageObjects.EmployeeEmail).sendKeys(dataFile.employee_email);
        elem.getWebElement("XPATH", HomePageObjects.EmployeeContact).sendKeys(dataFile.contact);

        BaseApp.logger.info("Submit Form and verify user was created");
        events.click("XPATH", HomePageObjects.SubButton);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String id = dataFile.employeeID;
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains(id), "User was Not created!");


    }

}
