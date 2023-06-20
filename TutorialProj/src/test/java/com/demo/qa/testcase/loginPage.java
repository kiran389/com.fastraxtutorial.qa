package com.demo.qa.testcase;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fastraxgenericmethods.Base1;



public class loginPage extends Base1{
	WebDriver driver;

	//	Initialize below code anywhere in the script
	
	@BeforeMethod
	public void browsersetup() throws InterruptedException {
		loadPropertiesFile();

		driver = initializeAndOpenBrowser(prop.getProperty("browser"));
	}

	@AfterMethod
	public void quitt() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}


	@Test(priority = 1)
	public void loginwithValidCredential() throws InterruptedException {

		//		Don't initialize below code in all bowser,if u initialize in all classesS it won't quit the browser 
		String currenturl=driver.getCurrentUrl();
		System.out.println("The current URL is:" +currenturl);

		String title=driver.getTitle();
		System.out.println("The Project title is:" +title);
		WebElement username=driver.findElement(By.xpath("//input[@id=\"exampleInputEmail1\"]"));
		username.sendKeys(prop.getProperty("validemail"));

		WebElement password = driver.findElement(By.xpath("//input[@id=\"exampleInputPassword1\"]"));
		password.sendKeys(prop.getProperty("validpassword"));
		Thread.sleep(2000);

		WebElement checkbox =driver.findElement(By.xpath("//input[@id='exampleCheck1']"));
		checkbox.click();
		WebElement continuee = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		continuee.click();
		System.out.println("Successfully clicked on continue button");
		System.out.println("User is logged in successfully");
		Thread.sleep(3000);
		System.out.println("loginwithValidCredential ----> PASSED");
	}

	@Test(priority = 2)
	public void loginwithInValidEmail() throws InterruptedException {
		WebElement username=driver.findElement(By.xpath("//input[@id=\"exampleInputEmail1\"]"));
		username.sendKeys("kiran1@zibtek.in");
		WebElement password = driver.findElement(By.xpath("//input[@id=\"exampleInputPassword1\"]"));
		password.sendKeys("123456");
		WebElement checkbox =driver.findElement(By.xpath("//input[@id='exampleCheck1']"));
		checkbox.click();
		WebElement continuee = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		continuee.click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Entered email id does not exists')][@class='warning-msg']")).isDisplayed(),"Validation is not displayed");
		String actualResult= driver.findElement(By.xpath("//div[contains(text(),'Entered email id does not exists')]")).getText();
		System.out.println("Login Page Validation for Email is ->"+actualResult);
		String expectedResult = "Entered email id does not exists";
		Assert.assertEquals(actualResult, expectedResult, "Validation Not Found");
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void loginwithInvalidPassword() throws InterruptedException {
		WebElement username=driver.findElement(By.xpath("//input[@id=\"exampleInputEmail1\"]"));
		username.sendKeys("kiran@zibtek.in");
		WebElement password = driver.findElement(By.xpath("//input[@id=\"exampleInputPassword1\"]"));
		password.sendKeys("1234567");
		WebElement checkbox =driver.findElement(By.xpath("//input[@id='exampleCheck1']"));
		checkbox.click();
		WebElement continuee = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		continuee.click();
		Thread.sleep(3000);
		String actualresult1 =	driver.findElement(By.xpath("//div[contains(text(),'Entered password is wrong')]")).getText();
		System.out.println("Validation for Login Password is -> "+actualresult1);
		String expectedresult = "Entered password is wrong";
		Assert.assertEquals(actualresult1, expectedresult, "Phone validation not found");
		Thread.sleep(2000);
	}
	@Test(priority = 4)
	public void loginwithbothInvalidEmailPass()throws Exception {
		//		driver = initializeAndOpenBrowser("chrome");
		WebElement username=driver.findElement(By.xpath("//input[@id=\"exampleInputEmail1\"]"));
		username.sendKeys("kiran@zibtek@");
		WebElement password = driver.findElement(By.xpath("//input[@id=\"exampleInputPassword1\"]"));
		password.sendKeys("123456");
		WebElement checkbox =driver.findElement(By.xpath("//input[@id='exampleCheck1']"));
		checkbox.click();
		WebElement continuee = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		continuee.click();
		String actualresult2	=	driver.findElement(By.xpath("//div[contains(text(),'*Email is invalid')]")).getText();
		System.out.println("Validation for invalid Email is ->"+actualresult2);
		String expectedresult2="*Email is invalid";
		Assert.assertEquals(actualresult2, expectedresult2,"Validation for invalid Email is not match");
		Thread.sleep(3000);
	}

	@Test(priority =5)
	public void loginwithemptyemail()throws Exception {
		WebElement username=driver.findElement(By.xpath("//input[@id=\"exampleInputEmail1\"]"));
		username.sendKeys(" ");
		WebElement password = driver.findElement(By.xpath("//input[@id=\"exampleInputPassword1\"]"));
		password.sendKeys("123456");
		WebElement checkbox =driver.findElement(By.xpath("//input[@id='exampleCheck1']"));
		checkbox.click();
		WebElement continuee = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		continuee.click();
		String actualresult3	=	driver.findElement(By.xpath("//div[contains(text(),'*Email is required')]")).getText();
		System.out.println("Validation for invalid Email is ->"+actualresult3);
		String expectedresult3="*Email is required";
		Assert.assertEquals(actualresult3, expectedresult3,"Validation for empty Email is not match");
		Thread.sleep(3000);
	}

	@Test(priority =6)
	public void loginwithemptypassword()throws Exception {
		WebElement username=driver.findElement(By.xpath("//input[@id=\"exampleInputEmail1\"]"));
		username.sendKeys("kiran@zibtek.in");
		WebElement password = driver.findElement(By.xpath("//input[@id=\"exampleInputPassword1\"]"));
		password.sendKeys("");
		WebElement checkbox =driver.findElement(By.xpath("//input[@id='exampleCheck1']"));
		checkbox.click();
		WebElement continuee = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		continuee.click();
		String actualresult4	=	driver.findElement(By.xpath("//div[contains(text(),'*Password is required')]")).getText();
		System.out.println("Validation for invalid Email is ->"+actualresult4);
		String expectedresult4="*Password is required";
		Assert.assertEquals(actualresult4, expectedresult4,"Validation for empty Password is not match");
		Thread.sleep(3000);

	}	

	@Test(priority =7)
	public void loginwithlessdigitPassword()throws Exception {
		WebElement username=driver.findElement(By.xpath("//input[@id=\"exampleInputEmail1\"]"));
		username.sendKeys("kiran@zibtek.in");
		Thread.sleep(2000);
		WebElement password = driver.findElement(By.xpath("//input[@id=\"exampleInputPassword1\"]"));
		password.sendKeys("12");
		WebElement checkbox =driver.findElement(By.xpath("//input[@id='exampleCheck1']"));
		checkbox.click();
		WebElement continuee = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		continuee.click();
		Thread.sleep(2000);
		String actualresult5 =	driver.findElement(By.xpath("//div[contains(text(),'*Password must be at least 6 Characters')]")).getText();
		System.out.println("Validation for invalid Email is ->"+actualresult5);
		String expectedresult5= "*Password must be at least 6 Characters";
		Thread.sleep(2000);
		Assert.assertEquals(actualresult5, expectedresult5,"Validation for Less Digit Password is not match");
		Thread.sleep(3000);

	}


	@Test(priority = 8)
	public void ValidEmailandPassword() throws InterruptedException {
		WebElement username=driver.findElement(By.xpath("//input[@id=\"exampleInputEmail1\"]"));
		username.sendKeys("kiran@zibtek.in");
		WebElement password = driver.findElement(By.xpath("//input[@id=\"exampleInputPassword1\"]"));
		password.sendKeys("123456");
		WebElement checkbox =driver.findElement(By.xpath("//input[@id='exampleCheck1']"));
		checkbox.click();
		WebElement continuee = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		continuee.click();
		Thread.sleep(3000);


	}


}
