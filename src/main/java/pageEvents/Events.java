package main.java.pageEvents;

import main.java.utilities.ElementFetch;
import org.openqa.selenium.interactions.Actions;
import test.java.base.BaseApp;

public class Events extends BaseApp {
    ElementFetch elem = new ElementFetch();

    public void click(String locator, String value){
        elem.getWebElement(locator, value).click();
    }
    public void hover(String locator, String value){
        Actions action = new Actions(driver);
        action.moveToElement(elem.getWebElement(locator, value));
        action.build().perform();
    }
    public String getText(String locator, String value) {
    String txt = elem.getWebElement(locator, value).getText();
        return txt;
    }
}
