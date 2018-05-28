package Day_1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Lesson_1 {
		public static void main(String[] args) throws Exception {
			System.out.println("Hellow Test Pro");
			
			System.setProperty("webdriver.chrome.driver", "./WebDriver/chromedriver.exe");
			//Or
			//System.setProperty("webdriver.gecko.driver", driverPath);
			
				/*
				 * - Set property for "webdriver.chrome.driver" with new directory -inside project-
				 * Instead of use find driver.exe directory in windows (system environment)-> path values.
				 * Note: per browser we have to edit WebDrive.exe name 
				 */
			
			//- Create instance from webDriver to current machine
			WebDriver driver= new ChromeDriver(); 

			//WebDriver driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.chrome());     
				//0- search for "selenium standalone url"  -> http://localhost:4444/wd/hub
				//1- Create instance from webDriver to remote host
				//2- Start standalone server as in snapshot.
				//3- run script   ......................... all steps as Appium workflow 

			driver.get("https://www.facebook.com/");                     // Use (get)function of new instance to send URL
			WebElement emailField= driver.findElement(By.id("email"));   // Create instance of (WebElement)and find (email id)
			emailField.sendKeys("ahmed_ocp1@hotmail.com");				 // c(email id)
			
			driver.findElement(By.id("pass")).sendKeys("123456789");	  //find (Password id)and pass value for it.
			
			driver.findElement(By.id("loginbutton")).click();             //find (Login)button and pass click action for it.
			
			//String errMSG = driver.findElement(By.className("._4rbf._53ij")).getText();
			String errMSG = driver.findElement(By.cssSelector("._4rbf._53ij")).getText();  //find (error Message) »«· ⁄ÊÌ“…. 
			
			System.out.println(errMSG);										//put (error Message)it in variable
			
			if (errMSG.equals("The password that you've entered is incorrect. Forgotten password?"))   // compare message content 
			System.out.println("Test case pass");
			else{
				System.out.println("Test case fail");
			}
			//Thread.sleep(10000);
			driver.quit();
		}
}
