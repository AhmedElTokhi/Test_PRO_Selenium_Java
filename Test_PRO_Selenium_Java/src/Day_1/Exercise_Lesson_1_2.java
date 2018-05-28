package Day_1;
/* login with INVALID user and password*/


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Exercise_Lesson_1_2 {
		public static void main(String[] args) throws Exception {
			
			WebDriver driver= new ChromeDriver();						  //- Create instance from webDriver to current machine 

			driver.get("https://www.facebook.com/");                      // Use (get)function of new instance to send URL
			WebElement emailField= driver.findElement(By.id("email"));    // Create instance of (WebElement)and find (email id)
			emailField.sendKeys("wwww");				  				  // send invalid (email id) using (WebElement) instance
			
			driver.findElement(By.id("pass")).sendKeys("sssss");	  //find (Password id)and pass invalid value for it.
			
			driver.findElement(By.id("loginbutton")).click();             //find (Login)button and pass click action for it.
			

			//String errMSG = driver.findElement(By.className("._4rbf._53ij")).getText();
			String errMSG = driver.findElement(By.cssSelector("._4rbf._53ij")).getText();  //find (error Message) »«· ⁄ÊÌ“…. 
			
			System.out.println(errMSG);										//put (error Message)it in variable
			
			// compare message content
			if (errMSG.equals("The email address or phone number that you've entered doesn't match any account. Sign up for an account."))    
			System.out.println("Test case is pass");
			else{
				System.out.println("Test case is fail");
			}
			//Thread.sleep(10000);
			driver.quit();
		}
}
