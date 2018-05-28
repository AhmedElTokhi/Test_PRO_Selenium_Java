package Day_4;

/*
 *  "WordPress login" test script using POM Page Object Model"
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class DemoLoginUsingPOM {

	protected WebDriver driver; // Create_instance_from_WebDriver_to_current_machine
	protected WebDriverWait wait;

	@BeforeMethod
	public void setup() {
		System.out.println("@BeforeMethod");

		driver = new ChromeDriver();
		driver.get("https://demos1.softaculous.com/WordPress/wp-login.php"); // Use_(get)function_of_new_instance_to_send_URL
	}

	@Test
	public void testLoginPass() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.loginSteps("demo", "pass");
	}

	@Test
	public void testInvalidPassword() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.loginSteps("demo", "Pa$$");
		login.assertError("ssss");
	}

	@Test
	public void testInvalidUser() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.loginSteps("Ahmed", "pass");
		login.assertError();
	}

	@AfterMethod
	public void TearDown() {
		System.out.println("@AfterMethod");
		driver.quit();
	}
}
