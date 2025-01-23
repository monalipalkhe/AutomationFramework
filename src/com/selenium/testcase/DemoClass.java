package com.selenium.testcase;
import org.testng.annotations.Test;

import io.qameta.allure.Allure;

public class DemoClass {

	@Test
    public void testMethod() {
        // Your test code here
        System.out.println("Test method executed");
    }

    // Another test method
    @Test
    public void anotherTestMethod() {
        System.out.println("Another test executed");
    }
    
    @Test
    public void yourTestMethod() {
        Allure.addAttachment("This is an attachment", "text/plain", "This is the content", "txt");
        System.out.println("Test method executed");
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hello Monali....");

	}

}
