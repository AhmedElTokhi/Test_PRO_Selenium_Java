package Day_2;

/* Do Multiple select from Multiple select list use (select)selenum API 
 * ********************************************************************************
 * 	 in HTML Page inspect and you will fin tag witch include (Select) (multiple) attributes as following   
 *	<select name="cars" multiple="">
 *	so we will deal with select
 * ********************************************************************************
*/

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Les_06_Multiple_Select {

	static WebDriver driver = new ChromeDriver(); // Create_instance_from_WebDriver_to_current_machine

	@BeforeMethod
	public void setup() {

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple"); // Use_(get)function_of_new_instance_to_send_URL
	}

	@Test
	public void Multiselect() throws InterruptedException {
		
		driver.switchTo().frame("iframeResult");

		// WebElement selectElement = driver.findElement(By.tagName("select"));
		// Select carsSelect=new Select(selectElement);
		// OR
		Select Multiselect = new Select(driver.findElement(By.tagName("select")));

		Multiselect.selectByValue("opel");
		Thread.sleep(1000);

		Multiselect.selectByVisibleText("Audi");
		Thread.sleep(1000);

		Multiselect.selectByIndex(1);
		Thread.sleep(1000);

		// System.err.println(Multiselect.getFirstSelectedOption().getText());

		List<WebElement> all = Multiselect.getAllSelectedOptions(); // get all selected values in list.

		for (WebElement w : all) { // Enhanced for loop

		// OR
			// WebElement w;
			// for(int i =0;i<all.size();i++){
			// w= all.get(i);
			System.err.println(w.getAttribute("selected"));
			System.err.println("Selected:" + w.getText());
		}

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//this wait duration needed up to Web Page load (xpath) -that will used in in next step-
		Thread.sleep(700);	
//		String selected=driver.findElement(By.xpath("//div[@class='w3-container w3-large w3-border']")).getText();	//valid xpath value
//		String selected=driver.findElement(By.xpath("/html/body/div[1]")).getText();								//valid xpath value
//		String selected=driver.findElement(By.xpath("//body[@class='w3-container']/div[1]")).getText();				//valid xpath value
		String selected=driver.findElement(By.xpath("//div[contains(@class,'w3-container')]")).getText();			//valid xpath value
		
		Assert.assertTrue(selected.contains("audi")&&selected.contains("opel"));
	}

	@AfterMethod
	public void TearDown() {
		System.err.println("@AfterMethod");
		driver.quit();
	}

}