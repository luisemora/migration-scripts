package pkg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EquipmentTrackingPage extends Main {

	public static String GetGridCounts() {
		  WebElement TotalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("equipment-grid-total")));
		  String TotalResults = TotalElement.getText();
		  return TotalResults;
	  }
	
}
  