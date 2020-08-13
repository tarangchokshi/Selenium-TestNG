package Stepdefinations.ServicePortal;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Models.PortalNewsModel;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class ServicePortalNews extends Base {
	
	WebDriver driver;
	PortalNewsModel portalNewsModel=new PortalNewsModel();
	Boolean messagePresent;
	
	@Given("^Open the url and login with right credential$")
	public void open_the_url_and_login_with_right_credential() throws Throwable {
		
		SetProperty();
		driver = Login();	
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
		GoToModule(Module.ServicePortal, driver);			
	}

	@Then("^User click on the MyApplication >Serviceportal>newsitems$")
	public void user_click_on_the_MyApplication_Serviceportal_newsitems() throws Throwable {
		
	    driver.findElement(By.xpath("//*[@id='navbar-pronectic']/ul[1]/li[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='container-main']/div/div[2]/div/a")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@data-id='"+ buildingUnitDataId +"']")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,500)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='checkwizard-next']"))).click();
	}
	
	@Then("^Click on the create news fill the detail and publish it$")
	public void click_on_the_create_news_fill_the_detail_and_publish_it() throws Throwable {
		
	   driver.findElement(By.xpath("//*[@id='Subject']")).sendKeys(portalNewsModel.getSubject());
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//*[@id='Message']")).clear();
	   driver.findElement(By.xpath("//*[@id='Message']")).sendKeys(portalNewsModel.getMessage());
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//*[@id='newsItemSubmit']")).click();
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='container-main']/div[1]/div[1]/h1")));
	   Thread.sleep(3000);
	   Assert.assertEquals(driver.findElement(By.xpath("//*[@id='display-Subject']/label")).getText(),portalNewsModel.getSubject());
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//*[@id='container-main']/div[1]/div[2]/div/a[1]")).click();
	   Thread.sleep(1000);
	   String message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='toast-container']/div/div"))).getText();
	   System.out.println("Publish Message::"+message);
	   Assert.assertEquals(message,portalNewsModel.getPublish());
	   Thread.sleep(3000); 
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("window.scrollBy(0,300)");
	   Thread.sleep(1000);
	  
	   Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='container-main']/table/tbody/tr/td[3]")).getText(),"Sir Winston Churchillln 299");
	   Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='container-main']/table/tbody/tr/td[6]")).getText(),"Rijswijk");   		
	}
	
	@Then("^Login and verify the News board and detail$")
	public void login_and_verify_the_News_board_and_detail() throws Throwable {
	    
		String windowHandle = driver.getWindowHandle();
	    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
	
		driver.get(SiteUrl+"/Serviceportaal/loekautomationbu/Login");
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(portalNewsModel.getEmail());
		driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(portalNewsModel.getPassword());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='login']/form/div[3]/input")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='navbar-pronectic']/ul[1]/li[3]/a"))).click();
		Thread.sleep(1000);
		String unreadmessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(html/body/div[1]/table/tbody/tr)[last()]/td[4]"))).getText();
		messagePresent = false;
		if(unreadmessage.contains("Ongelezen") || unreadmessage.contains("Unread"))
		{
			messagePresent = true;
		}
		Assert.assertEquals(messagePresent,true);
		Thread.sleep(1000);
		  
        List<WebElement> rows = driver.findElements(By.xpath("html/body/div[1]/table/tbody/tr"));
		int count = rows.size();
		System.out.println("Initial ROW COUNT : "+count);
		
		driver.navigate().refresh();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(html/body/div[1]/table/tbody/tr)[last()]/td[1]/a"))).click();
		Thread.sleep(1000);
		String str1=driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]")).getText();
		String str2=driver.findElement(By.xpath("html/body/div[1]/div[4]/div[2]")).getText();
		Assert.assertEquals(portalNewsModel.getBuildingunitdescription().toLowerCase().contains(str1.toLowerCase()), true);
		Assert.assertEquals(str2,portalNewsModel.getBuildingdescription());
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(2000);
        String readmessage=driver.findElement(By.xpath("(html/body/div[1]/table/tbody/tr)[last()]/td[4]")).getText();
        System.out.println("Message read::" + readmessage);
        messagePresent = false;
		if(readmessage.contains("Gelezen op") || readmessage.contains("Read on"))
		{
			messagePresent = true;
		}
		Assert.assertEquals(messagePresent,true);
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='navbar-pronectic']/ul[1]/li[1]/a")).click();
        Thread.sleep(1000);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div/div[1]/div[1]/div/div[1]/a[1]/div/p[1]"))).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//a[@class='btn btn-default']")).click();
		Thread.sleep(1000);
	    Alert alt=driver.switchTo().alert();
		alt.accept();
		Thread.sleep(1000);
		List<WebElement> rowslast = driver.findElements(By.xpath("html/body/div[1]/table/tbody/tr"));
		int counts = rowslast.size();
		System.out.println("Final ROW COUNT : "+counts);
		driver.close();
	}
}