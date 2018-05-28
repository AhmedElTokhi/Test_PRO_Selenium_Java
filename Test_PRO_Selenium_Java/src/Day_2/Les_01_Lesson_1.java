package Day_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Les_01_Lesson_1 {
	public static WebDriver driver;

	public static void Setup() {
		driver = new ChromeDriver(); // - Create_instance_from_webDriver to_current machine
		driver.get("https://www.facebook.com/"); // Use_(get)function_of_new_instance_to_send_URL
	}

	public static void TestCase1() {
		// === Enter Valid user and invalid Password ===
		// =========================Test Steps=======================
		WebElement emailField = driver.findElement(By.id("email")); // Create_instance_of_(WebElement)and_find_(email_id)
		emailField.sendKeys("ahmed_ocp1@hotmail.com"); // Send_(email id)

		driver.findElement(By.id("pass")).sendKeys("123456789"); // find_(Password_id)and_pass_value_for_it.

		driver.findElement(By.id("loginbutton")).click(); // find_(Login)button_and_pass_click_action_for_it.

		// String errMSG =driver.findElement(By.className("._4rbf._53ij")).getText();
		String errMSG = driver.findElement(By.cssSelector("._4rbf._53ij")).getText(); // find (error Message) »«· ⁄ÊÌ“….

		System.out.println(errMSG); // put (error Message)it in variable

		// =======================Assertion Point======================
		if (errMSG
				.equals("The password that you've entered is incorrect. Forgotten password?")) // compare_message_content
			System.out.println("Test case pass");
		else {
			System.out.println("Test case fail");
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void TestCase2() {
		// === Enter invalid user and invalid Password ===		
		// =========================Test Steps=======================
		WebElement emailField = driver.findElement(By.id("email")); // Create_instance_of_(WebElement)and_find_(email_id)
		emailField.sendKeys("wwww@wwww.com"); // Send_(email id)

		driver.findElement(By.id("pass")).sendKeys("1020304050"); // find_(Password_id)and_pass_value_for_it.

		driver.findElement(By.id("loginbutton")).click(); // find_(Login)button_and_pass_click_action_for_it.

		//String errMSG =
		//driver.findElement(By.className("._4rbf._53ij")).getText();
		String errMSG = driver.findElement(By.cssSelector("._4rbf._53ij")).getText(); // find_(error_Message)_»«· ⁄ÊÌ“….
		
		System.out.println(errMSG); // put (error Message)it in variable

		// =======================Assertion Point======================
		if (errMSG
				.equals("The password that you've entered is incorrect. Forgotten password?")) // compare_message_content
			System.out.println("Test case pass");
		else {
			System.out.println("Test case fail");
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void TestCase3() {
		// =========================Test Steps=======================
		WebElement emailField = driver.findElement(By.id("email")); // Create_instance_of_(WebElement)and_find_(email_id)
		emailField.sendKeys("ahmed_ocp1@hotmail.com"); // Send_(email id)

		driver.findElement(By.id("pass")).sendKeys("123456789"); // find_(Password_id)and_pass_value_for_it.

		driver.findElement(By.id("loginbutton")).click(); // find_(Login)button_and_pass_click_action_for_it.

		// String errMSG =
		// driver.findElement(By.className("._4rbf._53ij")).getText();
		String errMSG = driver.findElement(By.cssSelector("._4rbf._53ij")).getText(); // find (error Message) »«· ⁄ÊÌ“….

		System.out.println(errMSG); // put (error Message)it in variable

		// =======================Assertion Point======================
		if (errMSG
				.equals("The password that you've entered is incorrect. Forgotten password?")) // compare_message_content
			System.out.println("Test case pass");
		else {
			System.out.println("Test case fail");
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void TearDown() {
		driver.quit();
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Hellow Test Pro");

		// =========================Setup===========================
		Setup();
		// =========================TestSteps=======================
		TestCase1();
		// ========================TearDown=========================
		TearDown();

		// TestCase2
		Setup();
		TestCase2();
		TearDown();

		// TestCase3
		// Setup();
		// TestCase3();
		// TearDown();
	}
}
