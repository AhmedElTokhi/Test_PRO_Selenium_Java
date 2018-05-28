package Day_2;

/* *Write test script using TestNG approach
 * use Chrome web driver to select radio button
 * use (swichto)& xpath*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Les_04_RadioBotton {

	static WebDriver driver = new ChromeDriver(); // Create_instance_from_WebDriver_to_current_machine

	@BeforeMethod
	public void setup() {

		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_radio"); // Use_(get)function_of_new_instance_to_send_URL
	}

	@Test
	public void TestRadioButtons() throws InterruptedException {

		// WebElement myFrame = driver.findElement(By.id("iframeResult"));
		// driver.switchTo().frame(myFrame);

		// OR
		//Thread.sleep(500);
		driver.switchTo().frame("iframeResult");
		
		// Need to use (xpath)because HTML page have the same Tag for (all radio buttons)as following
		// <input type="radio" name="gender" ...>
		driver.findElement(By.xpath("//*[@value='other']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@value='male']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@value='female']")).click();
		Thread.sleep(500);
	}

	@AfterMethod
	public void TearDown() {
		System.err.println("@AfterMethod");
		driver.quit();
	}

}