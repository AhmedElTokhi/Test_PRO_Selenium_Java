
	//upload file
	/*https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_fileupload_get

	1-  try to use send key by directory

	2- 	using library in java (java aut robot)
		A- "copy" file path in clipord  ----------------using Eng.Mahmoud Utils package
		B- click open file
		c- "past" value -file directory-  ----------------using Eng.Mahmoud Utils package
		D- click enter
		
		
		
		note in case of multi execution
	*/
package Day_5;


import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Assert;

public class UploadFileDemo {
	private WebDriver driver;

//======= simple Steps ============== www.w3schools.com ===============================	
	@Test
	public void uploadW3schools() throws InterruptedException, AWTException{
			driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_fileupload_get");
			driver.switchTo().frame("iframeResult");			
			driver.findElement(By.id("myFile")).click();
			Thread.sleep(1000);
			utils.ClipBoard.copy("D:\\Sally\\1.jpg");
			Thread.sleep(1000);
			utils.ClipBoard.paste();
			utils.NativKeyHelper.hitEnter();
			Thread.sleep(3000);
		
	}
	
//======= Find + SendKey ============== www.w3schools.com ===============================	
//	@Test
	public void uploadW3schools_sendKeys() throws InterruptedException, AWTException{
			driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_fileupload_get");
			driver.switchTo().frame("iframeResult");			
			//driver.findElement(By.id("myFile")).click();/
			Thread.sleep(1000);
			driver.findElement(By.id("myFile")).sendKeys("D:\\Sally\\1.jpg");
//			utils.ClipBoard.copy("C:\\Temp\\Quality.jpg");
//			Thread.sleep(1000);
//			utils.ClipBoard.paste();
//			utils.NativKeyHelper.hitEnter();
			Thread.sleep(3000);
		
	}
//======= Simple Steps ============== www.zamzar.com ===============================
//	@Test
	public void simpleUpload() throws InterruptedException {
		driver.get("http://www.zamzar.com/");
		Thread.sleep(30000);
		driver.findElement(By.id("inputFile")).click();
		Thread.sleep(1000);
		utils.ClipBoard.copy("D:\\Sally\\1.jpg");
		Thread.sleep(1000);

			
		try {
			utils.ClipBoard.paste();
			utils.NativKeyHelper.hitEnter();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		Thread.sleep(2000);
		//== Assert for imported file ==
		WebElement e=driver.findElement(By.xpath("//tr/td[@class='name first']"));
		Assert.assertTrue(e.getText().equalsIgnoreCase("Quality.jpg"),"Not found");
		
	}

//======= Find + SendKey ============== www.zamzar.com ===============================	
//	@Test
	public void simpleUploadUsingSelenium() throws InterruptedException {
		driver.get("http://www.zamzar.com/");
		//driver.findElement(By.id("inputFile")).click();
		driver.findElement(By.id("p1bmp68a2i1q1m1qkpt3016u91jcg0_html5")).sendKeys("D:\\Sally\\1.jpg");
				//By.xpath("//*[@id='fileInputElementParent']//input[@type='file']")).sendKeys("C:\\Temp\\Quality.jpg");
		Thread.sleep(1000);
		//utils.ClipBoard.copy("C:\\Temp\\Quality.jpg");
		Thread.sleep(1000);		
		
		//== Assert for imported file ==
		WebElement e=driver.findElement(By.xpath("//tr/td[@class='name first']"));
		Assert.assertTrue(e.getText().equalsIgnoreCase("1.jpg"),"Not Found");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}

	@AfterSuite
	public void afterSuite() {
		
		driver.quit();
	}
	
}
