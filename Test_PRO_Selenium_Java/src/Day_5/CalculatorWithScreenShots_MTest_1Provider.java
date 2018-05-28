package Day_5;


import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CalculatorWithScreenShots_MTest_1Provider {
	WebDriver driver;

	//@Test
	public void testCalc01() throws InterruptedException {
		calculate("1", "+", "1");
		assertExpected("2");
	}

	@Test(dataProvider = "My data provider name")
	public void testCalcParametrized2(String in1, String op, String in2, String expected) {
		calculate(in1, op, in2);
		assertExpected(expected);
	}

	@Test(dataProvider = "My data provider name")
	public void testCalcParametrized(String in1, String op, String in2, String expected) {
		calculate(in1, op, in2);
		assertExpected(expected);
	}

	@DataProvider(name = "My data provider name")
	public Object[][] dataProvider(Method m) {

		String[][] data = { 
				{"1", "+","1","2" }, 
				{ "1", "-","1","0" },
				};
		String[][] data2 = { 
				{ "-1", "*","-1","1" },
				{ "1", "/","-1","-1" }
				};

		if(m.getName().equalsIgnoreCase("testCalcParametrized"))
			return data;
		else
			return data2;
	}


	
	
	

	public void assertExpected(String x) {
		WebDriverWait wait = new WebDriverWait(driver, 60, 100);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h2[contains(.,'" + x + "')]")));
	}

	public void calculate(String x, String opcode, String y) {
		driver.findElement(By.xpath("//input[@ng-model='first']")).clear();
		driver.findElement(By.xpath("//input[@ng-model='first']")).sendKeys(x);
		driver.findElement(By.xpath("//input[@ng-model='second']")).clear();
		driver.findElement(By.xpath("//input[@ng-model='second']")).sendKeys(y);
		WebElement opElement = driver.findElement(By.xpath("//select"));
		Select op = new Select(opElement);
		op.selectByVisibleText(opcode);

		driver.findElement(By.tagName("button")).click();
	}

	//Using optionl parameters
	@BeforeMethod
	@Parameters({"url","browser"})
	public void setup(@Optional("https://juliemr.github.io/protractor-demo/")String url,@Optional("chrome")String browser) {
		System.err.println("@BeforeMethod");
		if(browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("firefox"))
			driver=new FirefoxDriver();
		//"https://juliemr.github.io/protractor-demo/"
		driver.get(url);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		long timestamp = System.currentTimeMillis();
		if(result.isSuccess())
			utils.ScreenCapture.getScreenShot(driver, "./screenshots/myimg."+timestamp+".png");
		else
			utils.ScreenCapture.getScreenShot(driver, "./screenshots/myimg.failed."+timestamp+".png");
		System.err.println("@AfterMethod");
		driver.quit();
	}
}
