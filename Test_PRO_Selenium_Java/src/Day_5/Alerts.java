package Day_5;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Alerts {
	private WebDriver driver;
//	@Test
	public void simpleAlert() throws InterruptedException {
		driver.get("http://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button")).click();
		Thread.sleep(3000); 								// for tester to check
	//Try using accept
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000); 								// for tester to check
	}
	//
	
//	@Test
	public void confirmAlert() throws InterruptedException {
		driver.get("http://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button")).click();
		Thread.sleep(1000); 								// for tester to check
		driver.switchTo().alert().accept();
		Thread.sleep(1000); 								// for tester to check
	}
	
	@Test
	public void confirmAlertWithType() throws InterruptedException {
		driver.get("http://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button")).click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(" Ahmed ");
		Thread.sleep(3000);									// for tester to check
		alert.accept();
		Thread.sleep(3000);									// for tester to check
	}


	@BeforeMethod
	public void beforeMethod() {
		//???
		if(System.getProperties().containsKey("param1")) 
			System.out.println("\n=============\n"+System.getProperty("param1"));
		driver = new ChromeDriver();

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
