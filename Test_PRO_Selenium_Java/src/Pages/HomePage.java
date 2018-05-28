package Pages;

/*WordPress LoginPage Object
 * that contain locator and business sections of "wordPress login page"*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	protected WebDriver driver;
	protected WebDriverWait wait;

	By welcome = By.xpath("//*[@id='welcome-panel']/div/h2");
	By menuPosts = By.xpath("//li[@id='menu-posts']//div[.='Posts']");
	// By.menuPosts = By.xpath("//*[@id='menu-posts']/a/div[3]");

	//Constructor  used to call this class from other scripts
	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, 60, 250);
	}

	public void navigateToPost() {
		driver.findElement(menuPosts).click();
	}

	public void AssertHomePageLoaded() {
		wait.until(ExpectedConditions.attributeContains(welcome, "innerText",
				"Welcome to WordPress!"));
	}
}
