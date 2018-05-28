package Day_2;
/*
 *  1- Login using admin/ pass
 *  2- Assert home page/Dashboard
 *	3- Add new post with title and save
 *	4- Assert home page.*/

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Excercise_2_2_WordPressPost {

	static WebDriver driver = new ChromeDriver(); // Create_instance_from_WebDriver_to_current_machine

	@BeforeMethod
	public void setup() {

		driver.get("https://demos1.softaculous.com/WordPress/wp-login.php"); // Use_(get)function_of_new_instance_to_send_URL
	}

	@Test
	public void loginWordPress() throws Exception {

		// 1- Login using admin/ pass
		driver.findElement(By.id("user_login")).sendKeys("admin");
		driver.findElement(By.id("user_pass")).sendKeys("pass");
		driver.findElement(By.id("wp-submit")).click();

		Thread.sleep(5000);
		// Get_and_print_current_value_for_tester_validation
		String current = driver.findElement(By.xpath("//div[@id='wpbody-content']//h1[.='Dashboard']")).getText();
		
		// may need to wait if script execution faster that web response
		Thread.sleep(2000);		
		System.out.println(current);

		// Assert_for login_by_current_position
		Assert.assertEquals("Dashboard", current, "don't know current session");

//// =============== Click "New Post" by click (Add New) page button =================================				
//		//2-Click Post tab in menu
//		driver.findElement(By.cssSelector("#menu-posts .wp-menu-name")).click();
//			
//		Thread.sleep(1000);
//		// Find element by xpath in page. and click New Post Button
//		driver.findElement(By.xpath("//div[@id='wpbody-content']//a[@href='https://demos1.softaculous.com/WordPress/wp-admin/post-new.php']")).click();
//		Thread.sleep(5000);


////OR ============= Click "New Post" From sub menu ..... Using (Actions) =================================		
//		// Get linktext by "Ranorex Selocity" chrome tool and find by it.
//		Actions NewPost = new Actions(driver);
//		NewPost.moveToElement(driver.findElement(By.cssSelector("#menu-posts .wp-menu-name"))).perform();
//		Thread.sleep(1000);
//		
//		NewPost.moveToElement(driver.findElement(By.linkText("Add New"))).click().perform();

		
//OR ============= Click "New Post" From sub menu =================================				
		// 2-Click Post tab in menu
		driver.findElement(By.cssSelector("#menu-posts .wp-menu-name")).click();
				
		//Find element by linktext in sub menu. using "Ranorex Selocity" chrome tool.
		driver.findElement(By.linkText("Add New")).click();
		
// ================================================		
		//Enter title value
		driver.findElement(By.id("title")).clear();
		driver.findElement(By.id("title")).sendKeys("Welcom automation test");
		Thread.sleep(5000);

		// Enter value in text area useing_sendKeys(Keys.TAB + "text value");
		driver.findElement(By.id("title")).sendKeys(Keys.TAB +"Welcome to automation test by selenium java");
		Thread.sleep(5000);
		 
		 
		//click save Draft button
		driver.findElement(By.id("save-post")).click();
		Thread.sleep(5000);
		
		// Assert_for_save action
		String save= driver.findElement(By.xpath("//div[@id='message']/p")).getText();
		Assert.assertTrue(save.contains("Post draft updated"));
		System.out.println("The new post saved successfully");
	}

	@AfterMethod
	public void TearDown() {
		System.err.println("@AfterMethod");
		driver.quit();
	}
}
