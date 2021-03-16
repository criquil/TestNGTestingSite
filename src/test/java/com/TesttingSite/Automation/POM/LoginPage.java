package com.TesttingSite.Automation.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Base {

    public LoginPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }
    By userLocator = By.name("username");
    By passLocator = By.name("password");
    By submitLocator = By.name("action");
    By submitGoogleLocator = By.xpath("//span[contains(.,'Continue with Google')]");
    By signUpLocator = By.partialLinkText("Sign Up");
    By forgotPassLocator = By.partialLinkText("Forgot password?");
    By viewPassLocator = By.xpath("/html/body/div[2]/main/section/div/div[2]/div/form/div[1]/fieldset/div[2]/span");
    By identifierLocator = By.name("identifier");
    By siguienteLocator = By.id("identifierNext");
    By passwordLocator = By.name("password");
    By siguientePassLocator = By.id("passwordNext");

    String PageTitle = "Log in to automationDemo";

    public void WaitPageLoaded(){
        
    }

    public void LoginWithUserPass(WebDriver driver, String user, String pass){
        WebDriverWait wait = new WebDriverWait(driver,30);
        findElement(userLocator).clear();
        findElement(userLocator).sendKeys(user);
        wait.until(ExpectedConditions.presenceOfElementLocated(passLocator));
        findElement(passLocator).click();
        findElement(passLocator).clear();
        findElement(passLocator).sendKeys(pass);
        wait.until(ExpectedConditions.presenceOfElementLocated(submitLocator));
        findElement(submitLocator).submit();
        wait.until(ExpectedConditions.urlToBe("https://testappautomation.herokuapp.com/forms/"));
    }

    public void loginWithGoogle(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(submitGoogleLocator));
        findElement(submitGoogleLocator).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(identifierLocator));
        findElement(identifierLocator).sendKeys("cristianquil");
        wait.until(ExpectedConditions.presenceOfElementLocated(siguienteLocator));
        findElement(siguienteLocator).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(passLocator));
        findElement(passLocator).sendKeys("");
        findElement(siguienteLocator).click();
    }
    
}
