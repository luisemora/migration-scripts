package pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Main {

	  public static void Login(String Username, String Password) {
		  WebElement User = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
		  WebElement Pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Password")));
		  User.sendKeys(Username);
		  Pass.sendKeys(Password);
		  driver.findElement(By.cssSelector("input[id='loginBtn']")).click(); //click login btn
	  }
	  
	  public static void SuperAdminLogIn() {
		  WebElement User = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
		  WebElement Pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Password")));
		  User.sendKeys("luis.mora@gammapartners.com");
		  Pass.sendKeys("Lemc2568!");
		  driver.findElement(By.cssSelector("input[id='loginBtn']")).click(); //click login btn
	  }
	  
	  public static void ChangeClient(int ClientID) {
		  Main.driver.get(Main.Environment() + "/ClientManagement/ChangeClient/SelectClient?clientId=" + ClientID);
	  }
	  
	  public static void OpenBMIS() {
		  Main.driver.get(Main.Environment());
		  Main.driver.manage().window().maximize();
	  }
		
}