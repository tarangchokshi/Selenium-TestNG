package Stepdefinations.RemoveBuilding;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Models.RemoveBuilding.RemoveBuildingModel;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import Models.Ticket.TicketFailureModel;
import Models.Ticket.TicketInvoiceModel;
import Models.Ticket.TicketModel;
public class RemoveBuilding extends Base{


	WebDriver driver;
	TicketModel ticketModel = new TicketModel();
	TicketInvoiceModel ticketInvoiceModel = new TicketInvoiceModel();
	TicketFailureModel ticketFailureModel = new TicketFailureModel();
	String buildingName = "";
	RemoveBuildingModel buildingManage=new RemoveBuildingModel();
	
	@Given("^User click on the MyApplication > Building> AddBuilding$")
	public void user_click_on_the_MyApplication_Building_AddBuilding() throws Throwable {
		SetProperty();
		driver = Login();	
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);	
	}

	@Then("^User Add building and complex and verify that it works as expected$")
	public void user_Add_building_and_complex() throws Throwable {
		GoToModule(Module.Building,driver);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[1]/div[2]/div/a[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div/div[1]/div[1]/div/div[3]")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='search-postalcode']")).sendKeys(buildingManage.getPostalcode());
		driver.findElement(By.xpath("//input[@id='search-housenumber']")).sendKeys(buildingManage.getHouseNumber());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnSearch']")).click();
		Thread.sleep(4000);
		
		WebElement addBuildingButton = driver.findElement(By.xpath("//*[@id='button-add']"));
		if(addBuildingButton.isDisplayed())
		{			
			driver.findElement(By.xpath("//*[@id='button-add']")).click();
			Thread.sleep(2000);
			String buildingDetails = driver.findElement(By.xpath("//*[@id='queue']/div")).getText();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='button-save']")).click();
			Thread.sleep(5000);
			
			List<WebElement> buildingElements = driver.findElements(By.xpath("//*[@id='list']/div[1]/div/table/tbody/tr")); 
			Boolean buildingAddFlag = false;
			/*System.out.println("Start building")*/
			for(int i = 1; i<= buildingElements.size() ; i++)
			{  
				WebElement innerAddressElement = driver.findElement(By.xpath("//*[@id='list']/div[1]/div/table/tbody/tr[" + i + "]/td[2]"));
				WebElement innerPlaceElement = driver.findElement(By.xpath("//*[@id='list']/div[1]/div/table/tbody/tr[" + i + "]/td[3]"));			

				if(buildingDetails.contains(innerAddressElement.getText()) &&  buildingDetails.contains(innerPlaceElement.getText()))
				{
					buildingName = innerAddressElement.getText();
					System.out.println("buildingName =" + buildingName);
					buildingAddFlag = true;
					break;
				}			  
			}
			//System.out.println("End building");
			if(buildingAddFlag)
			{
				System.out.println("--------Test Case Pass -------");
			}
			else
			{
				System.out.println("--------Test Case fail -------");
			}

			Assert.assertEquals(buildingAddFlag,true);
		}
		else
		{
			System.out.println("--------Building already added -------");
			driver.findElement(By.xpath("//*[@id='navbar-pronectic']/ul[1]/li[1]/a")).click();
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='add-complex-button']")).click();
		Thread.sleep(1000);
		OpenChildWindow(driver);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ComplexName']"))).sendKeys(buildingManage.getComplaxname());
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[2]")).click();
		Thread.sleep(2000);
		String toast=driver.findElement(By.xpath(".//*[@id='toast-container']/div/div")).getText();
		System.out.println("Toast value is::"+toast);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='toast-container']/div/div"))).click();
		Assert.assertEquals(toast,buildingManage.getComplexDelete());
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='container-main']/div[2]/div[3]/div/a[2]")).click();
		Thread.sleep(1000);
		OpenChildWindow(driver);
		Thread.sleep(1000);


		List<WebElement> trElements = driver.findElements(By.xpath("//*[@id='page-modal']/div/div/form/div[2]/table/tbody/tr"));
		for(int j = 1; j<=trElements.size() ; j++)
		{
			WebElement element = driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[2]/table/tbody/tr["+j+"]/td[3]"));
			//System.out.println("tdElement " + element.getText());
			if(element.getText().toLowerCase().contains(buildingName.toLowerCase()))
			{
				WebElement checkboxElement = driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[2]/table/tbody/tr["+j+"]/td[1]/div"));
				checkboxElement.click();
				break;
			}
		}	

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[3]/font[2]/font/input")).click();
		Thread.sleep(1000);
		//js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[4]/div[2]/table/tbody/tr/td[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[1]/div/ul/li[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr/td[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='container-main']/div[2]/div[3]/div/a[2]")).click();
		Thread.sleep(1000);
		Alert alt=driver.switchTo().alert();
		alt.accept();
		Thread.sleep(1000);
		String toas=driver.findElement(By.xpath(".//*[@id='toast-container']/div/div")).getText();
		System.out.println("Toast value is::"+toas);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='toast-container']/div/div"))).click();
		Assert.assertEquals(toas,buildingManage.getBuildingunitdelete());

	}

	@Then("^verify that Building and complex removed respectively$")
	public void verify_that_Building_and_complex_added_respectively() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='container-main']/div[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='button-complex-delete']")).click();

		Thread.sleep(1000);
		OpenChildWindow(driver);
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/input[2]")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);

//		driver.findElement(By.xpath("//*[@id='list']/div[1]/div/table/tbody/tr[12]/td[1]/a")).click();
		List<WebElement> locatedElements = driver.findElements(By.xpath("//*[@id='list']/div[1]/div/table/tbody/tr")); 
		int i = 1;
		for(WebElement locatedElement: locatedElements)
		{	  
			WebElement innerAddressElement = driver.findElement(By.xpath("//*[@id='list']/div[1]/div/table/tbody/tr[" + i + "]/td[2]"));
			if(buildingName.contains(innerAddressElement.getText()))
			{
				driver.findElement(By.xpath("//*[@id='list']/div/div/table/tbody/tr[" + i + "]/td[1]/a")).click();
				break;
			}	
			i++;				  
		}
		
		Thread.sleep(1000);

		js.executeScript("window.scrollBy(0,-250)", "");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='button-building-delete']"))).click();
		Thread.sleep(1000);
		Alert alt=driver.switchTo().alert();
		alt.accept();
		Thread.sleep(2000);
		String toastMessage=driver.findElement(By.xpath(".//*[@id='toast-container']/div/div")).getText();
		System.out.println("Toast value is::"+toastMessage);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='toast-container']/div/div"))).click();
		
		if(toastMessage.toLowerCase().equals(buildingManage.getBuildingExistsInOtherModule().toLowerCase()))
		{
			Assert.assertEquals(toastMessage,buildingManage.getBuildingExistsInOtherModule());
		}
		else
		{
			Assert.assertEquals(toastMessage,buildingManage.getBuildingDelete());
		}
		Thread.sleep(2000);
		driver.close();
	}

}
