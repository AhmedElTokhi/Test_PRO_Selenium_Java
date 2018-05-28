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

public class A_1_loginInAmazon {
	WebDriver driver=new ChromeDriver();

	@BeforeMethod
	public void setup() {
		System.out.println("BeforeMethod");
		driver.get("https://www.amazon.com/ref=nav_logo");
		driver.manage().window().maximize();
	}
	
	@Test
	public void LoginToAmazon () throws Exception{
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("macbook pro");
		
		Select S1= new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
		S1.selectByValue("search-alias=computers");
		
		driver.findElement(By.cssSelector("[accept-charset] [type='submit']")).click();
		Thread.sleep(1000);
		
		
		WebElement element=driver.findElement(By.xpath("//*[@id='result_10']//div[2]//a/h2"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(3000);
		
	}
	
	@AfterMethod
	public void Teardown(){
		System.out.println("AfterMethod");
		driver.quit();
	}
}
