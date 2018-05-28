package Day_2;
/* *Write test script using TestNG approach and check report*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Les_03_TestNGSelenium {

 public static WebDriver driver;
		
	@BeforeMethod									//TestNG markers
 public void setup(){

	System.err.println("@BeforeMethod");
	driver= new ChromeDriver();						//- Create instance from webDriver to current machine  
	driver.get("https://www.facebook.com/");        // Use (get)function of new instance to send URL
 }	
	
	@Test											//TestNG markers
 public static void TestCase1(){
		System.err.println("@test:TestCase1");
		//=========================Test Steps=======================
		WebElement emailField= driver.findElement(By.id("email"));   // Create instance of (WebElement)and find (email id)
		emailField.sendKeys("ahmed_ocp1@hotmail.com");				 // Send_(email id)
		
		driver.findElement(By.id("pass")).sendKeys("123456789");	 //find (Password id)and pass value for it.
		
		driver.findElement(By.id("loginbutton")).click();            //find (Login)button and pass click action for it.
		
		//String errMSG = driver.findElement(By.className("._4rbf._53ij")).getText();
		String errMSG = driver.findElement(By.cssSelector("._4rbf._53ij")).getText();  //find (error Message) »«· ⁄ÊÌ“… and put (error Message)it in variable 
		
		System.out.println(errMSG);										// Print error message
		Assert.assertEquals("The password that you've entered is incorrect. Forgotten password?",errMSG ,"Error message note as expected");
 }
 @Test											//TestNG markers
 public static void TestCase2(){
		System.err.println("@test:TestCase2");
		//=========================Test Steps=======================
		WebElement emailField= driver.findElement(By.id("email"));    // Create instance of (WebElement)and find (email id)
		emailField.sendKeys("ahmed_ocp1@hotmail.com");				  // Send_(email id)
		
		driver.findElement(By.id("pass")).sendKeys("123456789");	  //find (Password id)and pass value for it.
		
		driver.findElement(By.id("loginbutton")).click();             //find (Login)button and pass click action for it.
			

		String errMSG = driver.findElement(By.cssSelector("._4rbf._53ij")).getText();  //find (error Message) »«· ⁄ÊÌ“… and put (error Message)it in variable 
			
		System.out.println(errMSG);										// Print error message
			
		Assert.assertEquals("The password that you've entered is incorrect.",errMSG ,"Error message note as expected");
																			// will fail because expected message not as message in (errMSG) variable.
		}

 public static void TestCase3(){					// This will not executed ?! because it have not (annotation/ marker)
		System.err.println("@test:TestCase3");
		//=========================Test Steps=======================
		WebElement emailField= driver.findElement(By.id("email"));   // Create instance of (WebElement)and find (email id)
		emailField.sendKeys("ahmed_ocp1@hotmail.com");				 // Send (email id)
		
		driver.findElement(By.id("pass")).sendKeys("123456789");	  //find (Password id)and pass value for it.
		
		driver.findElement(By.id("loginbutton")).click();             //find (Login)button and pass click action for it.
		
		String errMSG = driver.findElement(By.cssSelector("._4rbf._53ij")).getText();  //find (error Message) »«· ⁄ÊÌ“… and put (error Message)it in variable. 
		
		System.out.println(errMSG);										// Print error message
		
		//=======================Assertion Point======================
		if (errMSG.equals("The password that you've entered is incorrect. Forgotten password?"))   // compare message content 
		System.out.println("Test case pass");
		else{
			System.out.println("Test case fail");
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	@AfterMethod									//TestNG markers
 public static void TearDown(){
		System.err.println("@AfterMethod");
		driver.quit();
	}
}
