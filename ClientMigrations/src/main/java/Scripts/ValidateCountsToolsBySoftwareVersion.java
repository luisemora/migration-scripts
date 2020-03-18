package Scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pkg.CorporateDashboard;
import pkg.LoginPage;
import pkg.Main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ValidateCountsToolsBySoftwareVersion {
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
	  LoginPage.SuperAdminLogIn();
	  LoginPage.ChangeClient(LoginPage.GetClientID());
  }
  
  @Test (priority=3)
  public void CompareCountsTileOnTopVSBySoftwareVersion() throws InterruptedException {
	  int CountsBySoftwareVersion = CorporateDashboard.GetToolsBySoftwareVersion();
	  int TotalCountsSoftwareTile = CorporateDashboard.GetTotalToolsSoftwareUpdateTile();
	  Assert.assertEquals(CountsBySoftwareVersion,TotalCountsSoftwareTile);
  }
  
  @Test (priority=4)
  public void CloseBrowser() {
	  Main.Logout();
  }
}