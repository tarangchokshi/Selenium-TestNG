package Stepdefinations.Building;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Models.Building.BuildingSurfaceModel;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BuildingSurface extends Base {

    WebDriver driver;
    BuildingSurfaceModel modelBuildingSurface=new BuildingSurfaceModel();
    
    @Given("^Open the url and login with the valid data surface$")
	public void Open_the_url_and_login_with_the_valid_data_surface() throws Throwable {
    	
		SetProperty();
		driver = Login();
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
	}
    
    @When("^User click on the MyApplication > Building> select building surface$")
	public void User_click_on_the_MyApplication_Building_select_building_surface() throws Throwable {
    	
    	GoToModule(Module.Building,driver);	
		driver.get(BuildingDetailPath);
		Thread.sleep(2000);
	}
    
    @Then("^click on the surface from sidebar$")
	public void click_on_the_element_from_sidebar() throws Throwable {
    	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[1]/div/ul/li[5]/a")).click();
		Thread.sleep(3000);
	}
    
    @Then("^Check validation for Edit building surface$")
	public void Check_validation_for_Edit_building_surface() throws Throwable {
    	
		driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[1]/td[10]/a")).click();	
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Rentable']")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='Rentable']")).clear();
		driver.findElement(By.xpath("//*[@id='Rentable']")).sendKeys("text data");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[3]/input[2]")).click();
		Thread.sleep(2000);
		WebElement expected = driver.findElement(By.xpath(".//*[@id='validation-tooltip']/div[2]"));
		Assert.assertEquals(expected.getText(),modelBuildingSurface.getErrormessage());
		if(expected.getText().equals(modelBuildingSurface.getErrormessage()))
		{
			System.out.println("--------Validation Testcase Passed -------");
		}
		else
		{
			System.out.println("--------Validation Testcase failed -------");
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[3]/input[1]")).click();
		Thread.sleep(2000);
	}

	@Then("^Update and verify building surface$")
	public void Update_and_verify_building_surface() throws Throwable {
		
		//For building
		driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[1]/td[10]/a")).click();	
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Rentable']")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='Rentable']")).clear();
		driver.findElement(By.xpath("//*[@id='Office']")).clear();
		driver.findElement(By.xpath("//*[@id='Storage']")).clear();
		driver.findElement(By.xpath("//*[@id='Shop']")).clear();
		driver.findElement(By.xpath("//*[@id='Living']")).clear();
		driver.findElement(By.xpath("//*[@id='Parking']")).clear();
		driver.findElement(By.xpath("//*[@id='Other']")).clear();
		driver.findElement(By.xpath("//*[@id='Certified']")).clear();	
	
		driver.findElement(By.xpath("//*[@id='Rentable']")).sendKeys(modelBuildingSurface.getRentable());
		driver.findElement(By.xpath("//*[@id='Office']")).sendKeys(modelBuildingSurface.getOffice());
		driver.findElement(By.xpath("//*[@id='Storage']")).sendKeys(modelBuildingSurface.getStorage());
		driver.findElement(By.xpath("//*[@id='Shop']")).sendKeys(modelBuildingSurface.getShop());
		driver.findElement(By.xpath("//*[@id='Living']")).sendKeys(modelBuildingSurface.getLiving());
		driver.findElement(By.xpath("//*[@id='Parking']")).sendKeys(modelBuildingSurface.getParking());
		driver.findElement(By.xpath("//*[@id='Other']")).sendKeys(modelBuildingSurface.getOther());
		driver.findElement(By.xpath("//*[@id='Certified']")).sendKeys(modelBuildingSurface.getCertified());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[3]/input[2]")).click();
		Thread.sleep(8000);
		
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[1]/td[2]/font/font")).getText(),"5");
		if(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[1]/td[2]/font/font")).getText().equals("5"))
		{
			System.out.println("--------Validation Testcase Passed -------");
		}
		else
		{
			System.out.println("--------Validation Testcase failed -------");
		}
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[1]/td[3]/font/font")).getText(),"6");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[1]/td[4]/font/font")).getText(),"7");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[1]/td[5]/font/font")).getText(),"8");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[1]/td[6]/font/font")).getText(),"9");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[1]/td[7]/font/font")).getText(),"10");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[1]/td[8]/font/font")).getText(),"11");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[1]/td[9]/font/font")).getText(),"12");
		Thread.sleep(2000);
		
		//For first building unit	
		driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[2]/td[10]/a")).click();	
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Rentable']")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='Rentable']")).clear();
		driver.findElement(By.xpath("//*[@id='Office']")).clear();
		driver.findElement(By.xpath("//*[@id='Storage']")).clear();
		driver.findElement(By.xpath("//*[@id='Shop']")).clear();
		driver.findElement(By.xpath("//*[@id='Living']")).clear();
		driver.findElement(By.xpath("//*[@id='Parking']")).clear();
		driver.findElement(By.xpath("//*[@id='Other']")).clear();
		driver.findElement(By.xpath("//*[@id='Certified']")).clear();	
		
		driver.findElement(By.xpath("//*[@id='Rentable']")).sendKeys(modelBuildingSurface.getRentable1());
		driver.findElement(By.xpath("//*[@id='Office']")).sendKeys(modelBuildingSurface.getOffice1());
		driver.findElement(By.xpath("//*[@id='Storage']")).sendKeys(modelBuildingSurface.getStorage1());
		driver.findElement(By.xpath("//*[@id='Shop']")).sendKeys(modelBuildingSurface.getShop1());
		driver.findElement(By.xpath("//*[@id='Living']")).sendKeys(modelBuildingSurface.getLiving1());
		driver.findElement(By.xpath("//*[@id='Parking']")).sendKeys(modelBuildingSurface.getParking1());
		driver.findElement(By.xpath("//*[@id='Other']")).sendKeys(modelBuildingSurface.getOther1());
		driver.findElement(By.xpath("//*[@id='Certified']")).sendKeys(modelBuildingSurface.getCertified1());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[3]/input[2]")).click();
		Thread.sleep(8000);
		
		if(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[2]/td[2]/font/font")).getText().equals("1"))
		{
			System.out.println("--------Validation Testcase Passed -------");
		}
		else
		{
			System.out.println("--------Validation Testcase failed -------");
		}
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[2]/td[3]/font/font")).getText(),"1");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[2]/td[4]/font/font")).getText(),"1");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[2]/td[5]/font/font")).getText(),"1");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[2]/td[6]/font/font")).getText(),"1");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[2]/td[7]/font/font")).getText(),"1");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[2]/td[8]/font/font")).getText(),"1");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[2]/td[9]/font/font")).getText(),"1");
		Thread.sleep(2000);
		
		//For clear building surface	
		driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[1]/td[10]/a")).click();	
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Rentable']")));		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='Rentable']")).clear();
		driver.findElement(By.xpath("//*[@id='Office']")).clear();
		driver.findElement(By.xpath("//*[@id='Storage']")).clear();
		driver.findElement(By.xpath("//*[@id='Shop']")).clear();
		driver.findElement(By.xpath("//*[@id='Living']")).clear();
		driver.findElement(By.xpath("//*[@id='Parking']")).clear();
		driver.findElement(By.xpath("//*[@id='Other']")).clear();
		driver.findElement(By.xpath("//*[@id='Certified']")).clear();	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[3]/input[2]")).click();
		Thread.sleep(8000);
		
		if(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[1]/td[2]/font/font")).getText().equals("1"))
		{
			System.out.println("--------Validation Testcase Passed -------");
		}
		else
		{
			System.out.println("--------Validation Testcase failed -------");
		}
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[1]/td[3]/font/font")).getText(),"1");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[1]/td[4]/font/font")).getText(),"1");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[1]/td[5]/font/font")).getText(),"1");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[1]/td[6]/font/font")).getText(),"1");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[1]/td[7]/font/font")).getText(),"1");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[1]/td[8]/font/font")).getText(),"1");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[1]/td[9]/font/font")).getText(),"1");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr[2]/td[10]/a")).click();	
		OpenChildWindow(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Rentable']")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='Rentable']")).clear();
		driver.findElement(By.xpath("//*[@id='Office']")).clear();
		driver.findElement(By.xpath("//*[@id='Storage']")).clear();
		driver.findElement(By.xpath("//*[@id='Shop']")).clear();
		driver.findElement(By.xpath("//*[@id='Living']")).clear();
		driver.findElement(By.xpath("//*[@id='Parking']")).clear();
		driver.findElement(By.xpath("//*[@id='Other']")).clear();
		driver.findElement(By.xpath("//*[@id='Certified']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[3]/input[2]")).click();
		Thread.sleep(8000);
		driver.close();
	}	
}
