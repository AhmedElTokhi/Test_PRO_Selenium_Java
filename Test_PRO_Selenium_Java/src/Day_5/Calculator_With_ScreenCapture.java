package Day_5;

// Calculator using DDT "Data Driven test" 

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

public class Calculator_With_ScreenCapture {

	static WebDriver driver; // Create_instance_from_WebDriver_to_current_machine
	
	@BeforeMethod
	@Parameters({"url","browser"})
	
//=============== @optional define "default value" in case of not pass value from xml ============================
	public void setup(@Optional("https:juliemr.github.io/protractor-demo/") String url,@ Optional ("chrome") String browser) {
		System.err.println("@BeforeMethod");
		if(browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("firefox"))
			driver=new FirefoxDriver();
		//"https://juliemr.github.io/protractor-demo/"
		driver.get(url);
	}
	
	
	@AfterMethod
	
// ====================define (result) from (ITestResult)to used by testGN to store test result in it, and i will use it============
	public void TearDown(ITestResult result) throws IOException {
		System.out.println("@AfterMethod");

// ====================here add time stamp=================================
		long TimeStamp = System.currentTimeMillis();
// ====================here add take Screen capture in case of============= 

// ***** use custom package (utils)to be able to execute ****
		
		if(result.isSuccess())
			utils.ScreenCapture.getScreenShot(driver, "./ScreenShoot/myImage"+TimeStamp+".png");
		else
			utils.ScreenCapture.getScreenShot(driver, "./ScreenShoot/MyFailImage"+TimeStamp+".png");

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
		wait.until(ExpectedConditions.textToBe(By.xpath("//h2[@class='ng-binding']"), z));
		}
	
// ==== Create TestNG (DataProvider)=====================
	@DataProvider (name= "My data provider")
	public Object[][] dataProvider(){
		String [][] data={
				{" ","+"," ","2"}
				};
		return data;
	}
	
// ==== Fill data using TestNG (DataProvider)============		
	@Test (dataProvider= "My data provider")
	public void TestCalcParamitarized(String in1,String Op, String in2,String Expec){
		Calc(in1, Op, in2);
		assertResult(Expec);
		
	}
	
}
