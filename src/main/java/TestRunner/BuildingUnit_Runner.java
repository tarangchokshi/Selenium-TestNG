package TestRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import Stepdefinations.Base;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features = {"src\\main\\java\\Feature\\BuildingUnit\\BuildingUnitContacts.feature",
				"src\\main\\java\\Feature\\BuildingUnit\\BuildingAddManual.feature",
				"src\\main\\java\\Feature\\BuildingUnit\\BuildingUnitDocument.feature",
				"src\\main\\java\\Feature\\BuildingUnit\\BuildingUnitElement.feature",
				"src\\main\\java\\Feature\\BuildingUnit\\BuildingUnitInvoiceAddress.feature",
				"src\\main\\java\\Feature\\BuildingUnit\\BuildingUnitKeyAddress.feature",
				"src\\main\\java\\Feature\\BuildingUnit\\BuildingUnitRoom.feature",
				"src\\main\\java\\Feature\\BuildingUnit\\BuildingUnitTenant.feature"
				},
		glue={"Stepdefinations.BuildingUnit"}, 
		format= {"pretty","html:test-outout", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, 
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/LoekAutomationReport.html"}
		)

public class BuildingUnit_Runner{
	@AfterClass
	public static void teardown() throws Throwable {
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("User", System.getProperty("user.name"));
		Reporter.setSystemInfo("OS", System.getProperty("os.name"));
		Reporter.setSystemInfo("version", System.getProperty("java.runtime.version"));
		Base.GenerateReport();
	}
}