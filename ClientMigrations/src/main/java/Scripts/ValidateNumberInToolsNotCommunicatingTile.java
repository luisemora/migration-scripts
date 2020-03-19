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

public class ValidateNumberInToolsNotCommunicatingTile {
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
  public void ValidateToolsNotCommunicatingCount() throws InterruptedException {
	  int ToolCommunicationTotalTools = CorporateDashboard.GetTotalToolsToolCommunicationTile();
	  int ToolsCommunicating = CorporateDashboard.GetToolsCommunicating();
	  int ToolsNotCommunicatingTile = CorporateDashboard.GetToolsNotCommunicating();
	  int ToolsNotCommunicatingCount = ToolCommunicationTotalTools - ToolsCommunicating;
	  Assert.assertEquals(ToolsNotCommunicatingCount,ToolsNotCommunicatingTile);
  }
  
  @Test (priority=4)
  public void CloseBrowser() {
	  Main.Logout();
  }
}