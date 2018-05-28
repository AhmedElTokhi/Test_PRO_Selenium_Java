package Day_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Les_2_CompoundAction {

	static WebDriver driver = new ChromeDriver(); // Create_instance_from_WebDriver_to_current_machine

	@BeforeMethod
	public void setup() {

		driver.get("https://jqueryui.com/menu/"); // Use_(get)function_of_new_instance_to_send_URL
	}

//====================== compound action need (need wait time)=====================
// https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/interactions/Actions.html

	@Test
	public void MouseHoverandClick() throws Exception {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));

		Actions maction = new Actions(driver);
// ===============================================================================================================================
//		maction.moveToElement(driver.findElement(By.id("ui-id-4"))).click(driver.findElement(By.id("ui-id-7"))).build().perform();
//		Thread.sleep(2000);
// ===============================================================================================================================		
// Previous code run (without fail) but it (not do the 2nd click).
// in current sample there are waiting time up to appear sup menu
// SO separate action in 2 step to add wait time in between.

		maction.moveToElement(driver.findElement(By.id("ui-id-4"))).build().perform();
		Thread.sleep(500);
// can do it by action click
		maction.click(driver.findElement(By.id("ui-id-7"))).click().perform();
// can do it with driver click
//		driver.findElement(By.id("ui-id-7")).click();
		Thread.sleep(3000);
	}

////=============(Use Explicit Wait element)=======================
//	@Test
	public void MouseHoverandClick_SmartWait () throws Exception {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));		
		
// Define wait element with configuration (driver, "Maximum wait time" second, "bulls" MS)
		WebDriverWait  wait= new WebDriverWait(driver, 60, 250);

// Define object from (Actions)
		Actions maction = new Actions(driver);
		maction.moveToElement(driver.findElement(By.id("ui-id-4"))).build().perform();
		
//Use defined wait element
//Note: NOT ALL "condition list" of (ExpectedConditions.)  is working.
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-id-4")));
		Thread.sleep(500);	//For tester "To see result"
//can do it by action click
		maction.click(driver.findElement(By.id("ui-id-7"))).perform();
//can do it with driver click
//		driver.findElement(By.id("ui-id-7")).click();
		Thread.sleep(3000);	//For tester "To see result"
	}

	
	@AfterMethod
	public void TearDown() {
		System.err.println("@AfterMethod");
		driver.quit();
	}
}
