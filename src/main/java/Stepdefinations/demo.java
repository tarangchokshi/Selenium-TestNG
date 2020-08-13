package Stepdefinations;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class demo {
	WebDriver driver;
	@Given("^Open the url and login with the valid credential$")
	public void open_the_url_and_login_with_the_valid_credential() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "E:\\Driver\\geckodriver.exe");
		driver = new FirefoxDriver();
	    driver.manage().window().maximize();
		driver.get("https://www.google.com/gmail/about/#");
		
//		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
//		driver.findElement(By.linkText("urlLink")).sendKeys(selectLinkOpeninNewTab);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"T");
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());//
		driver.switchTo().window(tabs.get(0));
		
	    driver.get("https://apptest.loekonline.nl/user/login");
		
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("testshanoe1@loekonline.onmicrosoft.com");
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("Welkom01!");
     	driver.findElement(By.xpath("//button[@id='submitInloggen']")).click();
		Thread.sleep(3000);
		
		
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"T");
	    ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());//
		driver.switchTo().window(tabs1.get(0));
		driver.get("https://apptest.loekonline.nl/BuildingApp/Building/Add");
		
	}

	@Then("^click on the sumit$")
	public void click_on_the_sumit() throws Throwable {
	    
		
        driver.findElement(By.xpath("//div[@class='map-toggle-button-right']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='search-postalcode']")).sendKeys("");
        driver.findElement(By.xpath("//button[@id='btnSearch']")).click();
        Thread.sleep(5000);
	}
/*
	@Then("^varify the validation error message$")
	public void varify_the_validation_error_message() throws Throwable {
	   //.//*[@id='tooltip393100']/div[2]
		
		driver.switchTo().activeElement();
     	String tooltip=driver.findElement(By.xpath(".//*[@id='tooltip402093']/div[2]")).getText();
		System.out.println("ToolTip is:"+tooltip);
//     	Thread.sleep(2000);
//		Assert.assertEquals(tooltip,"");
	}*/
}
