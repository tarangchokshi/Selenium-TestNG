package Stepdefinations;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public String DriverPath = "src\\main\\java\\ChromeDriver\\chromedriver.exe";
	public WebDriver driver;

	//public String SiteUrl = "http://loekonline7942.azurewebsites.net";

	//Test environment
	public String SiteUrl = "https://apptest.loekonline.nl";
	public String LoginEmail = "testshanoe5@loekonline.onmicrosoft.com";
	public String LoginPassword = "Welkom01!";
	public String BuildingDetailPath = SiteUrl + "/BuildingApp/Building/Details/394";
	public String BuildingUnitDetailPath = SiteUrl + "/BuildingApp/BuildingUnit/Spaces/3683";
	public String buildingUnitDataId = "3683";
	public Environment CurrentEnvironment = Environment.Test;

	//Acceptance environment
	/*public String SiteUrl = "https://acceptance.loekonline.nl";
	public String LoginEmail = "a.testtarang9@loekonline.onmicrosoft.com";
	public String LoginPassword = "Welkom01!";	
	public String BuildingDetailPath = SiteUrl + "/BuildingApp/Building/Details/5852";
	public String BuildingUnitDetailPath = SiteUrl + "/BuildingApp/BuildingUnit/Spaces/26358";
	public String buildingUnitDataId = "26358";
	public Environment CurrentEnvironment = Environment.Acceptance;*/

	//Production data
	public String ProductionUrl = "https://app.loekonline.nl";
	public String ProductionLoginEmail = "shanoe.biere@ebpi.nl";

	public int WebDriverWaitTimeout = 300;
	public enum Module { Building, Ticket, ServicePortal }
	public enum TicketType { Initial, Performing, ExternalPerforming, Delegated }	
	public enum Environment { Test, Acceptance }
	public WebDriverWait wait;

	public void SetProperty() {

		System.setProperty("webdriver.chrome.driver", DriverPath);
	}

	public WebDriver Login() throws Throwable  {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(SiteUrl + "/user/login");
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(LoginEmail);
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(LoginPassword);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='submitInloggen']")).click();
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
		return driver;	
	}

	public void GoToModule(Module moduleName, WebDriver driver)  throws Throwable	{

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='navbar-pronectic']/ul[2]/li[2]/a")));
		driver.findElement(By.xpath(".//*[@id='navbar-pronectic']/ul[2]/li[2]/a")).click();
		Thread.sleep(1000);
		switch(moduleName){
		case Building:
			driver.findElement(By.xpath(".//*[@id='dropdown-applications-buildingapp']/a")).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
			Thread.sleep(2000);
			break;
		case Ticket:
			driver.findElement(By.xpath(".//*[@id='dropdown-applications-ticketapp']/a")).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
			Thread.sleep(2000);
			break;
		case ServicePortal:
			driver.findElement(By.xpath(".//*[@id='dropdown-applications-renterapp']/a")).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
			Thread.sleep(2000);
			break;
		}
	}	

	public void OpenChildWindow(WebDriver driver)	{

		String subWindowHandler = null;
		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);
	}

	public static boolean isAlertPresent(WebDriver driver) {
		try 
		{ 
			driver.switchTo().alert(); 
			return true;
		}  
		catch (Exception e) 
		{
			return false;
		}  
	}

	public boolean IsTextOnPagePresent(WebDriver driver,String text) {

		WebElement body = driver.findElement(By.tagName("body"));
		String bodyText = body.getText();
		return bodyText.contains(text);
	}

	public boolean IsElementExists(WebDriver driver,String xPath) {

		return (driver.findElements(By.xpath(xPath)).size() > 0);
	}

	public void SelectTicketFromTicketList(WebDriver driver)	{

		List<WebElement> locatedElements = driver.findElements(By.xpath(".//*[@id='tickets-default']//div[@style='display: block;']"));
		for(int i = 1; i<locatedElements.size() ; i++)
		{
			WebElement element = driver.findElement(By.xpath(".//*[@id='tickets-default']//div[@style='display: block;']["+i+"]/a"));
			if(element.isDisplayed())
			{
				element.click();
				break;
			}
		}
	}

	public void ImportFile(String path) throws Throwable	{

		StringSelection ss = new StringSelection(System.getProperty("user.dir") + path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Thread.sleep(2000);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
	}
	
	public boolean GoToComplex(String complex) throws Throwable	{
		boolean flag = false;
		int pageScrollLimit = 5;

		while(!flag && pageScrollLimit > 0)
		{		
			List<WebElement> locatedElements = driver.findElements(By.xpath(".//*[@id='list']/div"));
			System.out.println("locatedElements " + locatedElements.size());
			for(int i = 1; i <= locatedElements.size(); i++)
			{ 
				if(IsElementExists(driver,".//*[@id='list']/div["+i+"]/div/a"))
				{
					//flag = true;
					String complexName = driver.findElement(By.xpath(".//*[@id='list']/div["+i+"]/div/a")).getText();
					System.out.println("ComplexName " + driver.findElement(By.xpath(".//*[@id='list']/div["+i+"]/div/a")).getText());
					if(complexName.toLowerCase().trim().equals(complex.toLowerCase().trim()))
					{
						System.out.println("Found ");						
						driver.findElement(By.xpath(".//*[@id='list']/div["+i+"]/div/a")).click();
						return true;
					}
				}
			}
			if(flag || locatedElements.size()== 0)
			{
				break;
			}
			pageScrollLimit --;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)");
			Thread.sleep(3000);
		}
		return false;
	}

	public static void GenerateReport() throws Throwable	{

		FileInputStream ins = null;
		FileOutputStream outs = null;
		try {
			/*Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String pattern = "yyyy_MM_dd HH_mm_ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(timestamp);*/
			File infile =new File("output/LoekAutomationReport.html");
			FileTime modifiedFileTime = GetModifiedTime(infile);
			String modifiedFileTimeFormat = modifiedFileTime.toString().replace(':', '_').replace('T', ' ');
			System.out.println(modifiedFileTimeFormat);
			modifiedFileTimeFormat = modifiedFileTimeFormat.split("\\.")[0];
			System.out.println(modifiedFileTimeFormat);
			File outfile = new File("output/LoekAutomationReport_"+ modifiedFileTimeFormat +".html");
			ins = new FileInputStream(infile);
			outs = new FileOutputStream(outfile);
			byte[] buffer = new byte[1024];
			int length;

			while ((length = ins.read(buffer)) > 0) {
				outs.write(buffer, 0, length);
			} 
			ins.close();
			outs.close();
			System.out.println("File copied successfully!!");
		} catch(Exception ioe) {
			ioe.printStackTrace();
		}
	}

	public static FileTime GetModifiedTime(File file) throws IOException {
		Path p = Paths.get(file.getAbsolutePath());
		BasicFileAttributes view = Files.getFileAttributeView(p, BasicFileAttributeView.class).readAttributes();
		FileTime fileTime=view.lastModifiedTime();
		return fileTime;
	}
}