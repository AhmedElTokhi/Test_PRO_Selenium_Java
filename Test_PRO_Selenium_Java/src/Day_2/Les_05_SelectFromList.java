package Day_2;

/* *Write test script using TestNG approach
 * use Chrome web driver to do 1 select from list from created local HTML page
 * use (select)java API */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Les_05_SelectFromList {
	static WebDriver driver = new ChromeDriver(); // Create_instance_from_WebDriver_to_current_machine

	@BeforeMethod
	public void setup() {

		driver.get("file:///D:/Eclips_Source/eclipse_luna_WorkSpace/Test_PRO_Selenium_Java/HTML_Samples/HTML_selectList.html"); // Use_(get)function_of_new_instance_to_send_URL
	}

	@Test
	public void testselect() throws InterruptedException {

		// === Define Selector =================================
		// WebElement selectElement = driver.findElement(By.tagName("select"));
		// Select carselect = new Select(selectElement);

		// OR
		Select careselect = new Select(driver.findElement(By.tagName("select")));

		// === Select from list ================================
				
		String Val=careselect.getFirstSelectedOption().getText();	  // Get default selection value. 
		System.out.println("The default selection value is: "+Val);
		
		//OR
		System.out.println("The default selection value is: "+careselect.getFirstSelectedOption().getText());
		
		
		careselect.selectByValue("opel");		  // select by attribute name (Value) witch its value = opel.
		Thread.sleep(1000);

		careselect.selectByVisibleText("Audi");   // Visible text but not usable for (multi-Language)sites.
												  // can use it and test against specific language (English) and other languages checked manually.
		Thread.sleep(1000);

		careselect.selectByIndex(1);			  // select by list value index = (1).
		Thread.sleep(1000);

	}

	@AfterMethod
	// TestNG markers
	public static void TearDown() {
		System.err.println("@AfterMethod");
		driver.quit();
	}

}
