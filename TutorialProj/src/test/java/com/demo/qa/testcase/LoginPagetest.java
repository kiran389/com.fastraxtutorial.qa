package com.demo.qa.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fastrax.pages.LoginPage;
import com.fastraxgenericmethods.Base1;

public class LoginPagetest extends Base1 {
	WebDriver driver;
	
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
	@Test
	public void loginpage() throws InterruptedException {
		LoginPage login=new LoginPage(driver);
		login.valEmail(prop.getProperty("validemail"));
		Thread.sleep(3000);
		login.valPassword(prop.getProperty("validpassword"));
		Thread.sleep(3000);
	}

}
