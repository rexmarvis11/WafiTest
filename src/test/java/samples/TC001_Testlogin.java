//package test.java.samples;
//
//import base.BaseTest;
//import org.openqa.selenium.By;
//import org.testng.annotations.Test;
//import utilities.ReadXLSdata;
//
//public class TC001_Testlogin extends BaseTest {
//
//
//    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata")
//    public static void login(String username, String password) throws InterruptedException {
//
//        driver.findElement(By.xpath(locators.getProperty("login_username_input"))).sendKeys(username);
//        driver.findElement(By.xpath(locators.getProperty("login_password_input"))).sendKeys(password);
//        Thread.sleep(3000);
//        driver.findElement(By.xpath(locators.getProperty("login_submit_button"))).click();
//        Thread.sleep(2000);
//        driver.close();
//
//    }
//}
