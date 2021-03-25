package com.TesttingSite.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.TesttingSite.Automation.POM.HomePage;
import com.TesttingSite.Automation.POM.LoginPage;
import com.TesttingSite.Automation.POM.Spinner;



/**
 * Unit test for simple App.
 */
class AppTest {
    LoginPage loginPage;
    HomePage homePage;
    WebDriver driver;
    Spinner spinner;
    /**
     * Rigorous Test.
     */
    DesiredCapabilities caps;
    @Parameters({"browser","url"})
    @BeforeMethod
    
    void setUp(String browser, String url) throws MalformedURLException{
        caps = new DesiredCapabilities();
        caps.setCapability("browserName", browser);
       
        
    //    driver=loginPage.chromeDriverConnection();
        driver=new RemoteWebDriver(new URL("http://192.168.1.34:4444/wd/hub"),caps);
        driver.get(url);
        loginPage=new LoginPage(driver);
        homePage=new HomePage(driver);
        spinner=new Spinner(driver);

    }


    @Parameters({"url"})
    @Test
    void test1(String url) throws IOException {
        homePage.ClickLogin();
        loginPage.LoginWithUserPass(driver ,"cristianadrian22@hotmail.com", "Jesica01", url);
        homePage.ValidateHomeAssets();
        spinner.WaitSpinner(driver);
        By TXTNombre = By.id("TXTUser");
        homePage.findElement(TXTNombre).sendKeys("Cristian");
    }
    @Parameters({"url"})  
    @Test
    void test2(String url) throws IOException {
        homePage.ClickLogin();
        loginPage.LoginWithUserPass(driver ,"cristianadrian22@hotmail.com", "Jesica01", url);
        homePage.ValidateHomeAssets();
        spinner.WaitSpinner(driver);
        By TXTNombre = By.id("TXTUser");
        homePage.findElement(TXTNombre).sendKeys("Cristian");
    }
    @AfterMethod 
    void tearDown(){
        driver.quit();
    }

}
