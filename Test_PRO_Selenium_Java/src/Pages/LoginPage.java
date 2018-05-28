package Pages;
/*WordPress LoginPage Object
 * that contain locator and business sections of "wordPress login page"*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

	protected WebDriver driver; 
	protected WebDriverWait wait;

	//Locator Section
	By textUserLogin = By.id("user_login");
	By textUserPass = By.id("user_pass");
	By textUserSubmit = By.id("wp-submit");
	By ErrorMessag = By.id("login_error");

	
	//Constructor  used to call this class from other scripts
	public LoginPage(WebDriver driver) {
		//super();
		this.driver = driver;
		wait= new WebDriverWait(driver, 10, 250);
	}


	
	//Business method
	public void loginSteps(String User, String Password) {
		driver.findElement(textUserLogin).sendKeys(User);
		driver.findElement(textUserPass).sendKeys(Password);
		driver.findElement(textUserSubmit).click();
		}

	public void assertError (){
		wait.until(ExpectedConditions.attributeContains(ErrorMessag, "innerText", "ERROR"));
	}	

	public void assertError (String error){
//		wait.until(ExpectedConditions.attributeContains(ErrorMessag,"innerText", error));
		
		assertError();
		String errMSG=(driver.findElement(ErrorMessag).getAttribute("innerText"));
		Assert.assertTrue(errMSG.contains("ERROR"));
	}
}
