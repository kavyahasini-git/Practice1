package TestPackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGAnnotation {
	
	@Test
	public void ts1() {
		System.out.println("This is Test Scenario");
	}
	
	@Test @Ignore  // To ignore the rest case and execute the rest
	public void ts2() {
		System.out.println("This is Test Scenario two");
	}
	
	@Test
	public void ts3() {
		System.out.println("This is Test Scenario three");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is Before Method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("This is After Method");
	}

}
