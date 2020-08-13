package com.loekautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Login extends base {
	WebDriver driver;
	WebDriverWait wait;
/*test  comment*/
	@Test
	public void Login_Into_TestEnvironment() throws Throwable {

		test = extent.createTest("Check Login Functionality");
		/*For test purpose - test2 to test 6 */
		test2 = extent.createTest("Check Error Functionality");
		test3 = extent.createTest("Check Fail Functionality");
		test4= extent.createTest("Check Fatal Functionality");
		test5 = extent.createTest("Check Warning Functionality");
		test6 = extent.createTest("Check Skip Functionality");


		driver = TestEnvironmentEntry();  /*Call broswer - Base.java file*/
		test.log(Status.INFO, "URL : " + (prop.getProperty("URL")));
		test.log(Status.INFO, "User Email : " + (prop.getProperty("User_Email")));
		test.log(Status.INFO, "User Password : " + (prop.getProperty("User_Password")));
		wait = new WebDriverWait(driver,100);


		test.log(Status.PASS, "Home Page Redirection Successful");


//		if (driver.findElement(By.xpath("//*[@id='txtPassword']")).isDisplayed()) {
//
//			System.out.println("Login page redirection successful");
//			test.log(Status.PASS, capture(driver));
//
//
//		} else {
//			System.out.println("Login page redirection XXXX");
//
//			test.log(Status.FAIL, capture(driver));
//
//		}
		System.out.println("Demo code run finished");
		Thread.sleep(3000);
	}
	
	@Test
	public void error(){
		test2.log(Status.ERROR, "Home Page Redirection Successful");

	}
	
	@Test
	public void fail(){
		test3.log(Status.FAIL, "Home Page Redirection Successful");

	}
	
	@Test
	public void fatal(){
		test4.log(Status.FATAL, "Home Page Redirection Successful");

	}
	
	@Test
	public void warning(){
		test5.log(Status.WARNING, "Home Page Redirection Successful");

	}
	
	@Test
	public void skip(){
		test6.log(Status.SKIP, "Home Page Redirection Successful");

	}
}
