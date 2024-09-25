import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook_Login {
@Test
	public void test() throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abcd1234@#$");
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("123456789");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(5000);
		String actualMessage = driver.findElement(By.xpath("//a[contains(text(),'Find your account and log in.' )]")).getText();
		String expectedMessage="Find your account and log in.";
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actualMessage, expectedMessage);
		Thread.sleep(3000);
		driver.close();
		sa.assertAll();	
	}
}
