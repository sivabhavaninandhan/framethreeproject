package Registreaccount;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_004 {
	
	@Test
	
	public void VerifyRegisterAccountWithoutFillFields()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://tutorialsninja.com/demo/index.php?");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String ExpectedFirstNameWarning="First Name must be between 1 and 32 characters!";
		String ExpectedLastNameWarning="Last Name must be between 1 and 32 characters!";
		String ExpectedEmailWarning="E-Mail Address does not appear to be valid!";
		String ExpectedTelephoneWarning="Telephone must be between 3 and 32 characters!";
		String ExpectedPasswordWarning="Password must be between 4 and 20 characters!";
		String ExpectedPrivacyWarning="Warning: You must agree to the Privacy Policy!";
		
		
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(),ExpectedFirstNameWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(),ExpectedLastNameWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(),ExpectedEmailWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),ExpectedTelephoneWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),ExpectedPasswordWarning );
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),ExpectedPrivacyWarning);
		
		driver.quit();
		
	}

}