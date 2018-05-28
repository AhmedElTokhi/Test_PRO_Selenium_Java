package Day_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class New_Window {
	
	public static WebDriver driver;

	@Test
	public void verifySearchInNewWindow() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.navigate().to("http://linkedin.com/");
		driver.manage().window().maximize();
		String mainHandle = driver.getWindowHandle();
		
		
		
		// Need some steps to find "Help Center" link
		
		
		
		//Wait for the element to be present
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cust-svc-link")));
		driver.findElement(By.linkText("Help Center")).click();
		
		//Switch to new window and verify the title
		utils.NewWindow.waitForNewWindowAndSwitchToIt(driver);
		String newTitle = utils.NewWindow.getCurrentWindowTitle(driver);
		Assert.assertEquals(newTitle, "LinkedIn Help Center", "New window title is not matching");
		
		//Verify the text present on the page
		String textOnpage=driver.findElement(By.cssSelector(".welcome")).getText().trim();
		Assert.assertEquals(textOnpage, "Welcome!");
		
		//Verify search text on the page
		String searchText="Frequently Asked Questions";
		WebElement searchInputBox=driver.findElement(By.id("kw"));
		searchInputBox.sendKeys(searchText);
		
		WebElement searchButton = driver.findElement(By.cssSelector(".button.leftnoround.blue"));
		searchButton.click();
		
		WebElement resultedElement = driver.findElement(By.cssSelector(".rn_Element2"));
		String resultedText = resultedElement.getText().trim();
		System.out.println(resultedText);
		Assert.assertTrue(resultedText.contains(searchText), "Search successfull");
		
		utils.NewWindow.closeAllOtherWindows(driver, mainHandle);
	}
}
