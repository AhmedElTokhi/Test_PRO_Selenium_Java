package Day_3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Les_1_loginInAmazon {

	static WebDriver driver = new ChromeDriver(); // Create_instance_from_WebDriver_to_current_machine

	@BeforeMethod
	public void setup() {

		driver.get("https://www.amazon.com/ref=nav_logo"); // Use_(get)function_of_new_instance_to_send_URL
	}

	@Test
	public void Findxpath() throws Exception {

		// 1- search with value "macbook pro"
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("macbook pro");
		
		// find with xpath contain and 
		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox' and @dir='auto']")).sendKeys("macbook pro");
		
		// 2- select 'Computers' from category list
//		Select selectFromList = new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
	//OR
		Select selectFromList = new Select(driver.findElement(By.xpath("//span[@class='icp-nav-link-inner']//span[@class='nav-icon nav-arrow']")));
		selectFromList.selectByVisibleText("Computers");

		// 3- click on search button
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		
		
//		scroll using javascript code up to defined value in WebElement variable
		WebElement element =driver.findElement(By.xpath("//*[@id='result_10']//div[2]//a/h2"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		

	}

	@AfterMethod
	public void TearDown() {
		System.err.println("@AfterMethod");
		driver.quit();
	}
}
