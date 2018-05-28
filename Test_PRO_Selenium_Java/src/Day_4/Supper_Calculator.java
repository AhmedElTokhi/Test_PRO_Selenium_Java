package Day_4;

// Calculator using DDT "Data Driven test" 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Supper_Calculator {

	
	private WebDriver driver; // Create_instance_from_WebDriver_to_current_machine

	
	@BeforeMethod (alwaysRun=true)
	@Parameters ({"url","browser"}) 
	public void setup(String url, String browser) {
		System.out.println("@BeforeMethod");

		if(browser.equalsIgnoreCase("chrome")){
		driver = new ChromeDriver();
		}else if 

		(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();

		driver.get(url); 

	}

	@AfterMethod(alwaysRun = true)
	public void TearDown() {
		System.out.println("@AfterMethod");
		driver.quit();
	}

	public void Calc(String x, String Opcode, String y) {
		driver.findElement(By.xpath("//input[1]")).clear();
		driver.findElement(By.xpath("//input[1]")).sendKeys(x);

		driver.findElement(By.xpath("//input[2]")).clear();
		driver.findElement(By.xpath("//input[2]")).sendKeys(y);

		Select operator = new Select(driver.findElement(By.xpath("//select")));
		operator.selectByVisibleText(Opcode);

		driver.findElement(By.id("gobutton")).click();

	}

	public void assertResult(String z) {
		WebDriverWait wait = new WebDriverWait(driver, 60, 250);
		wait.until(ExpectedConditions.textToBe(
				By.xpath("//h2[@class='ng-binding']"), z));
		// OR
		// wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h2[contains(.,'"
		// +z+ "')]")));

	}

	// ========= + operator====================
	@Test(groups= { "SmokeTest", "FullTest" })
	public void PlusOperator() throws Exception {
		Calc("5", "+", "5");
		assertResult("10");
	}

	// ========= - operator====================
	@Test(groups={"Minus","FullTest"})
	public void MinusOperator() throws Exception {
		Calc("10", "-", "3");
		assertResult("7");
	}

	// ========= * operator====================
	@Test(groups={"functional", "FullTest"})
	public void multiplyOperator() throws Exception {
		Calc("5", "*", "6");
		assertResult("30");
	}

	// ========= / operator====================
	@Test(groups={"SmokeTest","FullTest"})
	public void DeviationOperator() throws Exception {
		Calc("15", "/", "3");
		assertResult("5");
	}

}
