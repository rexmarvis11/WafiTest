package main.java.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.java.base.BaseApp;

import java.util.List;

public class ElementFetch {

    public WebElement getWebElement(String identifierType, String IdentifierValue){
        switch (identifierType){
            case "ID":
                return BaseApp.driver.findElement(By.id(IdentifierValue));
            case "XPATH":
                return BaseApp.driver.findElement(By.xpath(IdentifierValue));
            case "CSS":
                return BaseApp.driver.findElement(By.cssSelector(IdentifierValue));
            case "TAGNAME":
                return BaseApp.driver.findElement(By.tagName(IdentifierValue));
            default:
                return null;
        }
    }

    public List<WebElement> getListWebElement(String identifierType, String IdentifierValue){
        switch (identifierType){
            case "ID":
                return BaseApp.driver.findElements(By.id(IdentifierValue));
            case "XPATH":
                return BaseApp.driver.findElements(By.xpath(IdentifierValue));
            case "CSS":
                return BaseApp.driver.findElements(By.cssSelector(IdentifierValue));
            case "TAGNAME":
                return BaseApp.driver.findElements(By.tagName(IdentifierValue));
            default:
                return null;
        }
    }
}
