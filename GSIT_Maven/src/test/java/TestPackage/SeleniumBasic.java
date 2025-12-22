package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasic {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.id("email")).sendKeys("KavyaHasini");
		Thread.sleep(2000);
		driver.findElement(By.id("pass")).sendKeys("Kavya@123");
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		Thread.sleep(2000);
		
		driver.close();

	}

}
