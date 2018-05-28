package Day_3;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Les_4_ScrollToElement {

	static WebDriver driver = new ChromeDriver(); // Create_instance_from_WebDriver_to_current_machine

	@BeforeMethod
	public void setup() {

		driver.get("https://www.amazon.com/ref=nav_logo"); // Use_(get)function_of_new_instance_to_send_URL
	}

	@Test
	public void ScrollByJavascript () throws Exception {


//#Issue can not find element when site use "Dynamic grid" but manually i found it
//	WebElement elme= driver.findElement(By.xpath("//div[@id='main-content-top']//img[@alt='Little Moments of Love']"));
WebElement elme= driver.findElement(By.xpath("//*[@id='uber-widget-ns_QXR4GMKYQGYJXJ7WK44Q_1463_']/div[2]/div"));

	//so can use fixed component  like dynamic image container or scroll with X and y

	
	
	// we have to check action in selenium if action not exist search for JavaScript and inject it as following
	JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
	javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",elme);
//	javascriptExecutor.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", elme);
//OR
	
//	javascriptExecutor.executeScript("window.scrollBy(0, 500)");	//valid
//	javascriptExecutor.executeScript("window.scrollTo(0, 500);");	//valid
	

	Thread.sleep(5000);
	
	}

	@AfterMethod
	public void TearDown() {
		System.err.println("@AfterMethod");
		driver.quit();
	}
}