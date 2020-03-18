package pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CorporateDashboard extends Main {
	
	
	 public static int GetTotalToolsSoftwareUpdateTile() throws InterruptedException {
		 Thread.sleep(2000);
		 WebElement SUSV = Main.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[id='SUSDonutMaxValue']")));
		 String SoftwareUpdateCountsString = SUSV.getText();
		 int SoftwareUpdateCounts = Integer.parseInt(SoftwareUpdateCountsString);
		 return SoftwareUpdateCounts;
	 }
	 
	 public static int GetToolsOutOfDate() throws InterruptedException {
		 Thread.sleep(2000);
		 WebElement TotalTools = Main.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[id='SUSDonutMaxValue']")));
		 WebElement UpToDate = Main.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[id='SUSDonutMinValue']")));
		 String TotalToolsString = TotalTools.getText();
		 String UpToDateString = UpToDate.getText();
		 int TT = Integer.parseInt(TotalToolsString);
		 int UD = Integer.parseInt(UpToDateString);
		 int Total = TT-UD;
		 return Total;
	 }
	 
	 public static int GetTotalToolsToolCommunicationTile() throws InterruptedException {
		 Thread.sleep(2000);
		 WebElement TCSV = Main.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[id='CSDonutMaxValue']")));
		 String ToolCommunicationCountsString = TCSV.getText();
		 int ToolCommunicationCounts = Integer.parseInt(ToolCommunicationCountsString);
		 return ToolCommunicationCounts;
	 }
	 
	 public static int GetToolsNotCommunicating() throws InterruptedException {
		 Thread.sleep(2000);
		 WebElement TotalToolsNotCommunicating = Main.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[id='outOfDateTools']")));
		 String ToolsWithNoCommunication = TotalToolsNotCommunicating.getText();
		 int ToolsNotCommunicating = Integer.parseInt(ToolsWithNoCommunication);
		 return ToolsNotCommunicating;
	 }
	 
	 public static int GetToolsCommunicating() throws InterruptedException {
		 Thread.sleep(2000);
		 WebElement TotalToolsCommunicating = Main.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[id='CSDonutMinValue']")));
		 String ToolsWithCommunication = TotalToolsCommunicating.getText();
		 int ToolsCommunicating = Integer.parseInt(ToolsWithCommunication);
		 return ToolsCommunicating;
	 }
	 
	 public static int GetToolsBySoftwareVersion() throws InterruptedException {
		 Thread.sleep(2000);
		 int i,sum = 0;
		 int rowCount=driver.findElements(By.xpath("//*[@id=\"dealer_table\"]/div[2]/table/tbody/tr")).size();
		for (i=1;i<=rowCount;i++) {
			WebElement Check = Main.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dealer_table\"]/div[2]/table/tbody/tr["+i+"]/td[4]/a")));
			if(Check.isDisplayed()) {
				String CheckString = Check.getText();
				int CheckCount = Integer.parseInt(CheckString);
				sum=sum+CheckCount;
			}
			else {
			}
		}
		return sum;
		 }
	 
	 public static int GetToolsOutOfDateByLocation() throws InterruptedException {
		 Thread.sleep(2000);
		 int i,sum = 0;
		 int rowCount=driver.findElements(By.xpath("//*[@id=\"dealer_table2\"]/div[2]/table/tbody/tr")).size();
		for (i=1;i<=rowCount;i++) {
			WebElement Check = Main.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dealer_table2\"]/div[2]/table/tbody/tr["+i+"]/td[2]/a")));
			if(Check.isDisplayed()) {
				String CheckString = Check.getText();
				int CheckCount = Integer.parseInt(CheckString);
				sum=sum+CheckCount;
			}
			else {
			}
		}
		return sum;
		 }
			 
	 
	 public static WebElement ViewReportSoftwareUpdateStatus() throws InterruptedException {
		 Thread.sleep(2000);
		 WebElement SoftwareUpdateStatus = Main.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id='btnTodaysSUS']")));
		 return SoftwareUpdateStatus;
	 }
	 
	 public static WebElement ViewReportToolCommunicationStatus() throws InterruptedException {
		 Thread.sleep(2000);
		 WebElement SoftwareUpdateStatus = Main.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id='btnTodaysCS']")));
		 return SoftwareUpdateStatus;
	 }
	 
	 public static WebElement ViewReportBySoftwareVersion() throws InterruptedException {
		 Thread.sleep(2000);
		 WebElement SoftwareUpdateStatus = Main.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id='btnBySoftwareVersion']")));
		 return SoftwareUpdateStatus;
	 }
	 
	 public static WebElement ViewReportByToolsNotCommunicating() throws InterruptedException {
		 Thread.sleep(2000);
		 WebElement SoftwareUpdateStatus = Main.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id='btnOutOfDateTools']")));
		 return SoftwareUpdateStatus;
	 }
	 
	 public static WebElement ViewReportOutOfDateByLocation() throws InterruptedException {
		 Thread.sleep(2000);
		 WebElement SoftwareUpdateStatus = Main.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id='btnSoftwareUpdateStatus']")));
		 return SoftwareUpdateStatus;
	 }

}