package pkg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SoftwareVersionStatusPage extends Main {

	public static int GetGridCounts() {
		  WebElement TotalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("recordCount")));
		  String TotalResults = TotalElement.getText();
		  int Total = Integer.parseInt(TotalResults);
		  return Total;
	  }
	
}
