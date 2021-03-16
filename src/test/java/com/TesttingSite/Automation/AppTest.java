package com.TesttingSite.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    @BeforeTest
    void setUp(){
        
       
        loginPage=new LoginPage(driver);
        driver=loginPage.chromeDriverConnection();
        driver.get("https://testappautomation.herokuapp.com/");
        homePage=new HomePage(driver);
        spinner=new Spinner(driver);

    }



    @Test
    void testApp() throws IOException {
        homePage.ClickLogin();
        loginPage.LoginWithUserPass(driver ,"cristianadrian22@hotmail.com", "Jesica01");
        homePage.ValidateHomeAssets();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        Path path = Paths.get("./src/test/resourses/axe.min.js");

        String content = new String(Files.readAllBytes(path));
        jse.executeScript(content);

        File output = new File("report.json");
        FileWriter writer = new FileWriter(output);
        String result = (String) jse.executeScript("let result; await axe.run().then((r)=> {result=r}); return JSON.stringify(result);");
        writer.write(result);
        writer.flush();
        writer.close();
        spinner.WaitSpinner(driver);
        By TXTNombre = By.id("TXTUser");
        homePage.findElement(TXTNombre).sendKeys("Cristian");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @AfterTest 
    void tearDown(){
        driver.quit();
    }

}
