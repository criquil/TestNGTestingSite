package com.TesttingSite.Automation.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends Base {

    public HomePage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }
 
    By loginBTNLocator = By.id("loginBTN");
    By logoutBTNLocator = By.id("logoutBTN");
    By formsLinkLocator = By.partialLinkText("Testing Forms");

    public void ClickLogin(){
        findElement(formsLinkLocator).click();;
        
        findElement(loginBTNLocator).click();
    }
public void ValidateHomeAssets(){
    Assert.assertFalse(isDisplayed(loginBTNLocator));
    Assert.assertTrue(isDisplayed(logoutBTNLocator));
}


}
