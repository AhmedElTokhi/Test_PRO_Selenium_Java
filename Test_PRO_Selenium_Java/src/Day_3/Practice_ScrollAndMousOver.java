package Day_3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice_ScrollAndMousOver {

	static WebDriver driver = new ChromeDriver(); // Create_instance_from_WebDriver_to_current_machine

	@BeforeMethod
	public void setup() {

		driver.get("https://www.amazon.com/ref=nav_logo"); // Use_(get)function_of_new_instance_to_send_URL
		driver.manage().window().maximize();
	}

/*::Reference:: ***********"check reference document in project"***********
	 
::Note:: (java script) 
 * 1- We can search for java script command search keyword(how to get element by id in javascript). like click on page button (Department)(document.getElementById("nav-link-shopall").click();)
 * 2- We can check java script code in web page (console)by click (Ctrl+Shift+j).... Because actually selenium deal with page Data Object Model (DOM). 
 * 3- but this JS in selenium object (JavascriptExecutor) as following:
 */	
	@Test
	public void Findxpath() throws Exception {

		// practice for (Mouse hover action)
		Actions maction = new Actions(driver);
		maction.moveToElement(driver.findElement(By.xpath("//*[@id='nav-link-shopall']/span[2]/span"))).build().perform();
		maction.moveToElement(driver.findElement(By.cssSelector("#nav-link-shopall > span.nav-line-2 > span"))).build().perform();
		maction.moveToElement(driver.findElement(By.cssSelector("#nav-flyout-shopAll > div.nav-template.nav-flyout-content.nav-tpl-itemList > span:nth-child(11) > span"))).build().perform();

		driver.findElement(By.cssSelector("#nav-flyout-shopAll > div.nav-subcats > div:nth-child(10) > div.nav-column.nav-column-notfirst.nav-column-break > div > a:nth-child(2) > span")).click();
		Thread.sleep(2000);

		// scroll using java script code up to defined value in WebElement
		WebElement element = driver.findElement(By.xpath("//*[@id='sort_by_text']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
	}

	@AfterMethod
	public void TearDown() {
		System.err.println("@AfterMethod");
		driver.quit();
	}
}
