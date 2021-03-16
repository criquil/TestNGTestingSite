package com.TesttingSite.Automation.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Spinner extends Base {

    public Spinner(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    By SpinnerLocator=By.id("isLoading");
    public void WaitSpinner(WebDriver driver){
    WebDriverWait wait = new WebDriverWait(driver,5);
   // wait.until(ExpectedConditions.presenceOfElementLocated(SpinnerLocator));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(SpinnerLocator));
    }
}
