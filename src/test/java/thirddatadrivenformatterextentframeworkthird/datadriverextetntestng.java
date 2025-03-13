package thirddatadrivenformatterextentframeworkthird;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class datadriverextetntestng extends BaseClassExtent{
	
	@Test(testName="TestORNGHRM",dataProvider="verification",dataProviderClass=datadrivenExtentTest.class)
	
	public void testOrangeHRMone(String usnm,String pswd)
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys(usnm);
		driver.findElement(By.name("password")).sendKeys(pswd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']/child::img")).click();
		driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]")).click();
	}
	
	 @Test(testName="TestGoogle",groups= {"smoke","regression"})
		public void testgooglee()
		{
		driver.get("https://www.google.co.in/");
		extentTest.info("navigate to browser");
		driver.findElement(By.name("q")).sendKeys("Hyderabad");
	  String exptitle="Google";
		String acttitle=driver.getTitle();
		Assert.assertEquals(exptitle,acttitle);
		extentTest.pass("Assertion is passed for webpage title");
		}
	 
		@Test(testName="TestFaceBook",groups= {"sanity"})
		public void testfacebooks()
		{
			driver.get("https://www.facebook.com/");
			extentTest.info("navigate to URL");
			String exptitle="Facebooku – log in or sign up";
			String acttitle=driver.getTitle();
		Assert.assertEquals(acttitle,exptitle);
		extentTest.info("Assertion is failed for webpage title verfication");
			
		}

}
