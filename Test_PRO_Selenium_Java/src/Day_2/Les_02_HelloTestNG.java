package Day_2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Les_02_HelloTestNG {

	@BeforeMethod									//TestNG annotation/ markers (run before method)
 public void setup(){
	System.err.println("@BeforeMethod");
 }	
	@Test											//TestNG annotation/ markers (Run in between of Before & After)
 public static void TestCase1(){
		System.err.println("@test:TestCase1");
 }
	@Test											//TestNG annotation/ markers (Run in between of Before & After)
	public static void TestCase2(){
		System.err.println("@test:TestCase2");
 }

	public static void TestCase3(){					// This will not executed ?! because it have not (annotation/ marker)
		System.err.println("@test:TestCase3");
 }
	
	@AfterMethod									//TestNG annotation/ markers   (run after method)
 public static void TearDown(){
		System.err.println("@AfterMethod");
 }
}
