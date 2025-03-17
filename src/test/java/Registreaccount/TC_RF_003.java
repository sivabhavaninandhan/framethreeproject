package Registreaccount;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_003 {
	
	@Test
	public void verifyRegisterWithAllFields()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
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
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		String ExpectedProperdetailsone="Your Account Has Been Created";
		String ExpectedProperdetailstwo="Congratulations! Your new account has been successfully created!";
		String ExpectedProperdetailsthree="You can now take advantage of member privileges to enhance your online shopping experience with us.";
		
		String ExpectedProperdetailsfour="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		
		String ExpectedProperdetailsfive="contact us.";
		
		String ActProperdetails=driver.findElement(By.id("content")).getText();
		
		Assert.assertTrue(ActProperdetails.contains(ExpectedProperdetailsone));
		Assert.assertTrue(ActProperdetails.contains(ExpectedProperdetailstwo));
		Assert.assertTrue(ActProperdetails.contains(ExpectedProperdetailsthree));
		Assert.assertTrue(ActProperdetails.contains(ExpectedProperdetailsfour));
		Assert.assertTrue(ActProperdetails.contains(ExpectedProperdetailsfive));
		
		driver.findElement(By.linkText("Continue")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();
	}
	
    public String getCurrentdate()
    {
    	Date dt=new Date();
    	
    	String timestamp=dt.toString().replace(":","_").replace(" ", "")+"@gmail.com";
    	return timestamp;
    	
    }
}
