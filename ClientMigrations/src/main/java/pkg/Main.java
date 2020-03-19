package pkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.TestNG;
import org.testng.Assert;
import org.testng.Reporter;

public class Main {
	public static WebDriver driver = new ChromeDriver();
	public static WebDriverWait wait = new WebDriverWait(driver,10); //implicit wait

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { Main.class });
		testng.run();
	}
	
	public static String Environment() {
		String URL = "https://mdx-uat-bmis2.azurewebsites.net/";
		return URL;
	  }
	
	public static int GetClientID() {
		int ClientID = 67; 
		return ClientID;
	}
	
	public static void Logout() {
		WebElement ProfileIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[class='fa fa-user-circle']")));
		ProfileIcon.click();
		WebElement SignOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='sign-out']")));
		SignOut.click();
	  }
	
}