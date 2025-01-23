package com.selenium.testcase;


import org.openqa.selenium.By;
//import org.testng.Assert;
import org.testng.annotations.Test;
import TestEnv.BaseClass;

public class SeleniumClassDemo extends BaseClass{
		
	@Test(priority=1)
    public void AMethod() throws InterruptedException {
        // Your test code here
		Thread.sleep(5000);
     driver.findElement(By.xpath("//*[contains(text(), 'Login Page')]"));
     //Assert.assertEquals(driver., "Login");

        }

}
