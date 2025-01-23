package com.selenium.testcase;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.selenium.testcase.Utilities.ReadConfig;
import com.selenium.testcase.Utilities.XLUtils;

//import com.selenium.testcase.Utilities.ReadConfig;

import TestEnv.BaseClass;


public class InternetClass extends BaseClass {
    static ReadConfig readconfig;
     
    @Test(dataProvider = "LoginData")
    public void DDF(String Username, String Password) throws InterruptedException {        
        
        // Locate elements using proper locators
        //driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(Username);
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(Username);
        
        
       // driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(Password);
       
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordField.sendKeys(Password);
       
        // Wait for 2 seconds (use WebDriverWait instead for better synchronization)
        
        
        // Click the submit button
       // driver.findElement(By.xpath("//*[@type='submit']")).click();
        
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginButton.click();
        
        
        wait.until(ExpectedConditions.titleContains("The Internet"));
        
     // Validate login success
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "The Internet");
        System.out.println("Successfully logged in with Username: " + Username);
        
    }
    
  //This method is referred to pass the test data through the hard coded value.
	/*
	 * @DataProvider(name = "LoginData") public Object[][] getLoginData() throws
	 * IOException { // Load data from Excel or any other source return new
	 * Object[][] { {"tomsmith", "SuperSecretPassword!"} // Example: username and
	 * password from Excel }; }
	 */
    
    //This method is referred to pass the test data through the excel only
    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() throws IOException {
        String filePath = "C:\\Users\\monali.palkhe\\eclipse-workspace\\AutomationFramework\\src\\TestData\\LoginData.xlsx";
        String sheetName = "Internet";
        return XLUtils.getExcelData(filePath, sheetName);
    }

}

