package Day_1;
/* login with VALID user and password*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Exercise_Lesson_1_1 {
		public static void main(String[] args) throws Exception {
			System.out.println("let us do it");
			
			WebDriver driver= new ChromeDriver();						  //- Create instance from webDriver to current machine 

			driver.get("https://www.facebook.com/");                      // Use (get)function of new instance to send URL WebDriver Instance
			WebElement emailField= driver.findElement(By.id("email"));    // Create instance of (WebElement)and find (email id)
			emailField.sendKeys("ahmed_ocp1@hotmail.com");				  // send (email id) using (WebElement) instance
			
			driver.findElement(By.id("pass")).sendKeys("sss");	  		  //find (Password id)using WebDriver Instance and pass value for it.
			
			driver.findElement(By.id("loginbutton")).click();             //find (Login)button WebDriver Instance and pass click action for it.
			
			Boolean xpathv = driver.findElement(By.xpath("//html[@id='facebook']//div[@id='u_0_a']//a[@title='Profile']//span[@class='_1vp5']")).isDisplayed();
			
			if (xpathv == true)   // compare message content 
			System.out.println("Test case is pass - user successfully login");
			else{
				System.out.println("Test case is fail - user can not login");
			}
			//Thread.sleep(10000);
			driver.quit();
		}
}
