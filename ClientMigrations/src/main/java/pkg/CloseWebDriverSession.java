package pkg;
import org.testng.annotations.Test;

public class CloseWebDriverSession {
  @Test
  public void CloseWebDriverSession() {
	Main.driver.close();
	Main.driver.quit();
  }

}
