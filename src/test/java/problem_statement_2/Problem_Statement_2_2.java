package problem_statement_2;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Problem_Statement_2_2 {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//Single File Upload
		driver.findElement(By.xpath("//input[@name='filesToUpload']")).sendKeys("C:\\Users\\SOMSUVRO\\Desktop\\Rough\\Test1.txt");
	    
		//Validation
		if(driver.findElement(By.xpath("//ul[@id='fileList']/li")).getText().contains("Test1"))
		{
			System.out.println("File is backed up succesfully");
		}
		else
		{
			System.out.println("Unable to backup data");
		}
		Thread.sleep(3000);
		driver.close();
		}
}

