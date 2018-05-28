package Day_3;

// login to (https://juliemr.github.io/protractor-demo/) and do 4 math operation (+, -, *, /)

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise_3_1_SupperCalculator {

	static WebDriver driver = new ChromeDriver(); // Create_instance_from_WebDriver_to_current_machine

	@BeforeMethod
	public void setup() {

		driver.get("https://juliemr.github.io/protractor-demo/"); // Use_(get)function_of_new_instance_to_send_URL
	}

	@Test
	public void SupperCalculator () throws Exception {
	
	Select operator =new Select(driver.findElement(By.xpath("//select")));	
	WebDriverWait wait= new WebDriverWait(driver,60,250);	
		
//========= + operator====================
	driver.findElement(By.xpath("//input[1]")).clear();
	driver.findElement(By.xpath("//input[1]")).sendKeys("1");
	
	driver.findElement(By.xpath("//input[2]")).clear();
	driver.findElement(By.xpath("//input[2]")).sendKeys("3");
	
	operator.selectByVisibleText("+");
	
	driver.findElement(By.id("gobutton")).click();
	
	
	wait.until(ExpectedConditions.textToBe(By.xpath("//h2[@class='ng-binding']"), "4"));
//OR
//	wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2[@class='ng-binding']"), "4"));

// Eng.Mahaoud approach	
//	int x=4;
//	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html//form/h2(.,+x+)")));

//Assert
	String Result= driver.findElement(By.xpath("//h2[@class='ng-binding']")).getText();
	Assert.assertTrue(Result.contains("4"));
	String table= driver.findElement(By.xpath("//tr/td[3]")).getText();
	Assert.assertTrue(table.contains("4"));
	
//========= - operator====================
	driver.findElement(By.xpath("//input[1]")).clear();
	driver.findElement(By.xpath("//input[1]")).sendKeys("10");
	
	driver.findElement(By.xpath("//input[2]")).clear();
	driver.findElement(By.xpath("//input[2]")).sendKeys("3");
	
	operator.selectByVisibleText("-");
	
	driver.findElement(By.id("gobutton")).click();

	wait.until(ExpectedConditions.textToBe(By.xpath("//h2[@class='ng-binding']"), "7"));
//OR
//	wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2[@class='ng-binding']"), "7"));

//Assert
	Result= driver.findElement(By.xpath("//h2[@class='ng-binding']")).getText();
	Assert.assertTrue(Result.contains("7"));
	table= driver.findElement(By.xpath("//tr/td[3]")).getText();
	Assert.assertTrue(table.contains("7"));
	
//========= / operator====================
	driver.findElement(By.xpath("//input[1]")).clear();
	driver.findElement(By.xpath("//input[1]")).sendKeys("10");
	
	driver.findElement(By.xpath("//input[2]")).clear();
	driver.findElement(By.xpath("//input[2]")).sendKeys("2");
		
	operator.selectByVisibleText("/");
	
	driver.findElement(By.id("gobutton")).click();

	wait.until(ExpectedConditions.textToBe(By.xpath("//h2[@class='ng-binding']"), "5"));
//OR
//	wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2[@class='ng-binding']"), "5"));

//Assert
	Result= driver.findElement(By.xpath("//h2[@class='ng-binding']")).getText();
	Assert.assertTrue(Result.contains("5"));
	table= driver.findElement(By.xpath("//tr/td[3]")).getText();
	Assert.assertTrue(table.contains("5"));	

	
//========= * operator====================
	driver.findElement(By.xpath("//input[1]")).clear();
	driver.findElement(By.xpath("//input[1]")).sendKeys("2");
	
	driver.findElement(By.xpath("//input[2]")).clear();
	driver.findElement(By.xpath("//input[2]")).sendKeys("5");
			
	operator.selectByVisibleText("*");
		
	driver.findElement(By.id("gobutton")).click();

	wait.until(ExpectedConditions.textToBe(By.xpath("//h2[@class='ng-binding']"), "10"));
//OR
//	wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2[@class='ng-binding']"), "10"));

//Assert
	Result= driver.findElement(By.xpath("//h2[@class='ng-binding']")).getText();
	Assert.assertTrue(Result.contains("10"));
	table= driver.findElement(By.xpath("//tr/td[3]")).getText();
	Assert.assertTrue(table.contains("10"));	

	Thread.sleep(5000);
	
	
	}
	
	@AfterMethod
	public void TearDown() {
		System.err.println("@AfterMethod");
		driver.quit();
	}
}
