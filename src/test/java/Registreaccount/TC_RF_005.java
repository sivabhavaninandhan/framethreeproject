package Registreaccount;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_005 {
	
	@Test
	public void VerifyRegisteringAccountBySubscribingToNewSletter()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://tutorialsninja.com/demo/index.php?");
		
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("ganga");
		driver.findElement(By.id("input-lastname")).sendKeys("bhavani");
		driver.findElement(By.id("input-email")).sendKeys("ganga"+getCurrentdate());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value=1]")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		driver.findElement(By.linkText("Continue")).click();
		
		driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//li[3]")).isDisplayed());
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).isSelected());
		
		driver.quit();
		
	
	}
	public String getCurrentdate()
    {
    	Date dt=new Date();
    	
    	String timestamp=dt.toString().replace(":","_").replace(" ", "")+"@gmail.com";
    	return timestamp;
    	
    }
}
