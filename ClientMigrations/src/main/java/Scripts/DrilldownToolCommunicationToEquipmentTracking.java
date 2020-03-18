package Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pkg.CorporateDashboard;
import pkg.EquipmentTrackingPage;
import pkg.LoginPage;
import pkg.Main;

public class DrilldownToolCommunicationToEquipmentTracking {
	private WebDriver driver;
	  @BeforeClass
		public void beforeClass() {
		  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		  driver = new ChromeDriver();
	  }
		  
	  @AfterClass
		public void afterClass() {
		  driver.close();
		  driver.quit(); 
	  }
	  @Test (priority=1)
	  public void OpenWebsite() {
		LoginPage.OpenBMIS();
	  }
	  
	  @Test (priority=2)
	  public void Login() {
		  LoginPage.AutomatedLogIn();
		  LoginPage.ChangeClient(LoginPage.GetClientID());
	  }
	  
	  @Test (priority=3)
	  public void DrilldownToET() throws InterruptedException {
		  int ToolCommunicationTotalTools = CorporateDashboard.GetToolsCommunicating();
		  Thread.sleep(1000);
		  CorporateDashboard.ViewReportToolCommunicationStatus().click();
		  String EquipmentTrackingCounts = EquipmentTrackingPage.GetGridCounts();
		  Assert.assertEquals("Total Records:"+ToolCommunicationTotalTools,EquipmentTrackingCounts);
	  }
	  
	  @Test (priority=4)
	  public void CloseBrowser() {
		  Main.Logout();
	  }
	
}