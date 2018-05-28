package Day_2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise_2_1 {
	static WebDriver driver = new ChromeDriver(); // Create_instance_from_WebDriver_to_current_machine

	@BeforeMethod
	public void setup() {

		driver.get("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_tabs"); // Use_(get)function_of_new_instance_to_send_URL
	}

	@Test
	public void selecttabs() throws InterruptedException {
	
		driver.switchTo().frame("iframeResult");

		driver.findElement(By.cssSelector(".tab .tablinks:nth-of-type(2)")).click();
		Thread.sleep(2000);
		
		String message= driver.findElement(By.xpath("//div[@id='Paris']/p[.='Paris is the capital of France.']")).getText();
		System.out.println(message);	// Validation_step_for tester
		Assert.assertEquals("Paris is the capital of France.",message,"Not Receive expected MSG");

		
		driver.findElement(By.cssSelector(".tab .tablinks:nth-of-type(3)")).click();
		Thread.sleep(2000);

		message= driver.findElement(By.xpath("//div[@id='Tokyo']/p[.='Tokyo is the capital of Japan.']")).getText();
		System.out.println(message);	// Validation_step_for tester
		Assert.assertEquals("Tokyo is the capital of Japan.",message,"Not Receive expected MSG");

		driver.findElement(By.cssSelector(".tab .tablinks:nth-of-type(1)")).click();
		Thread.sleep(2000);

		message= driver.findElement(By.xpath("//div[@id='London']/p[.='London is the capital city of England.']")).getText();
		System.out.println(message);	// Validation_step_for tester
		Assert.assertEquals("London is the capital city of England.",message,"Not Receive expected MSG");

	}
	
	@AfterMethod
	public void TearDown() {
		System.err.println("@AfterMethod");
		driver.quit();
	}
}
