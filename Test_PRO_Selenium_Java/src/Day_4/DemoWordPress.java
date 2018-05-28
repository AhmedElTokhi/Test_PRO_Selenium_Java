package Day_4;

/*
 *  1- Login using admin/ pass
 *  2- Assert home page/Dashboard
 *	3- Add new post with title and save
 *	4- Assert home page.*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class DemoWordPress {

	/*protected: Who "use class" by create object, can NOT use it.
	 * 			 Who "inherit class" can use it.
	 */
	protected WebDriver driver; // Create_instance_from_WebDriver_to_current_machine
	protected WebDriverWait wait;

	// Locator Section
	By textUserLogin = By.id("user_login");
	By textUserPass = By.id("user_pass");
	By textUserSubmit = By.id("wp-submit");
	By ErrorMessage = By.xpath("//*[@id='login_error']");
	By WelcomeMessage = By.xpath("//*[@id='welcome-panel']/div/h2");

	// Business section
	//Private: Who ("use class" by create object ,"inherit class") can NOT use it -Only for class internal use-
	private void loginSteps(String User, String pass) {
		driver.findElement(textUserLogin).sendKeys(User);
		driver.findElement(textUserPass).sendKeys(pass);
		driver.findElement(textUserSubmit).click();
	}

	@BeforeMethod
	//public: (Who "use class" , "inherit class") can use it.
	public void setup() {
		System.out.println("@BeforeMethod");

		driver = new ChromeDriver();
		driver.get("https://demos1.softaculous.com/WordPress/wp-login.php"); // Use_(get)function_of_new_instance_to_send_URL
		wait = new WebDriverWait(driver, 10, 250);
	}

	@AfterMethod
	public void TearDown() {
		System.out.println("@AfterMethod");
		driver.quit();
	}

	@Test
	public void demoLoginPass() throws Exception {

		loginSteps("admin", "pass");

		wait.until(ExpectedConditions.attributeContains(WelcomeMessage,"innerText", "Welcome to WordPress!"));
		// in (ExpectedConditions.attributeContains) in attribute is "innerText"

		Thread.sleep(700); // to see result only
	}

	@Test
	public void demoLogininvalidUser() {
		
		loginSteps("Ahmed", "pass");
		
		wait.until(ExpectedConditions.attributeContains(ErrorMessage,"innerText", "ERROR"));
	//OR	
//		String current = driver.findElement(By.xpath("//*[@id='welcome-panel']//h2")).getText();	
//		Assert.assertTrue(current.contains("Welcome to WordPress!"));		
//		System.out.println("We are in home page:"+ current);
		
	}

	@Test
	public void demoLogininvalidPass() throws Exception {

		loginSteps("Admin", "Pa$$");

		wait.until(ExpectedConditions.attributeContains(ErrorMessage,"innerText", "The password you entered for the username"));
		// in (ExpectedConditions.attributeContains) in attribute is "innerText"
		Thread.sleep(700); // to see result only
	}

}
