package com.TesttingSite.Automation.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	private WebDriver driver;
	
	public Base(WebDriver driver) {
		this.driver=driver;
	}
	
    public WebDriver chromeDriverConnection() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            return driver;
        }
    public WebDriver edgeDriverConnection() {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            return driver;
        }
    public WebDriver FirefoxDriverConnection() {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            return driver;
        }
	

    public WebElement findCustomElement(String tagType, String value){
        return driver.findElement(By.cssSelector("["+tagType+"="+value+"]"));

    }    
    public List<WebElement> findCustomElements(String tagType, String value){
        return driver.findElements(By.cssSelector("["+tagType+"="+value+"]"));
    }
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator);
	}
	public String getText(WebElement element) {
		return element.getText();
	}
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	public void setText(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	public void submitForm(By locator) {
		driver.findElement(locator).submit();
	}
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		}
		catch(org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	public void navigate(String url) {
		driver.get(url);
	}    
    
}
