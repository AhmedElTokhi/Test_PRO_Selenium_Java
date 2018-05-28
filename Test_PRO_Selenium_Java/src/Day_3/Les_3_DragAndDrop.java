package Day_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Les_3_DragAndDrop {

	static WebDriver driver = new ChromeDriver(); // Create_instance_from_WebDriver_to_current_machine

	@BeforeMethod
	public void setup() {

		driver.get("https://jqueryui.com/droppable/"); // Use_(get)function_of_new_instance_to_send_URL
	}
	
// Compound Action: 
//(click-and-hold, double-click, contextClick, drag-and-drop, drag-and-drop-by, key-down, key-up, move-by-offset, move-to-element, release)
//===============
//::Reference:: ***********"check reference document in project"***********
		
/* ::Note:: 
 * 1- All Actions must end with .perform(); to be executed.
 * 2- build() method is used compile all the listed actions into a single step. 
 * We use build() when we are performing sequence of operations and (no need) to use if we are performing (single action).*/
	
	

	@Test
	public void DragAndDrop() throws Exception {

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));

		Actions DragAction = new Actions(driver);
		
//		DragAction.dragAndDrop(source, target)
		DragAction.dragAndDrop(driver.findElement(By.id("draggable")),(driver.findElement(By.id("droppable")))).perform();

		Thread.sleep(2000);

//==== Assert =========== 		
		String confirmationText= driver.findElement(By.xpath("//*[@id='droppable']/p")).getText();
//		Assert.assertEquals("Dropped!",confirmationText,"Image not draged");
//		System.out.println("1st assert is done");
//OR
		Assert.assertTrue(confirmationText.contains("Dropped"));
		System.out.println("2nd assert is done");
	}

	@AfterMethod
	public void TearDown() {
		System.err.println("@AfterMethod");
		driver.quit();
	}
}