package com.demo.qa.testcase;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.fastrax.pages.RegisterPage;
import com.fastraxgenericmethods.Base1;
import com.fastraxgenericmethods.eventlist;
@Listeners(eventlist.class)
public class RegisterPagetest extends Base1{
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
	public void registerPage() throws InterruptedException {
		RegisterPage homepage =  new RegisterPage(driver);
		homepage.clickonnewaccount();
		homepage.checkmototacc();
		Thread.sleep(4000);
		homepage.clickonmotoracc();
		Thread.sleep(2000);
		homepage.clickonnextbutton();
		Thread.sleep(3000);
		homepage.companyName(dataProp.getProperty("companyname"));
		Thread.sleep(3000);
		homepage.dotNumber(dataProp.getProperty("dotnumber"));
		Thread.sleep(3000);
		homepage.companyAddress(dataProp.getProperty("address"));
		Thread.sleep(3000);
		homepage.companycity(dataProp.getProperty("city"));
		Thread.sleep(3000);
		homepage.companystate(dataProp.getProperty("state"));
		Thread.sleep(3000);
		homepage.companyzip(dataProp.getProperty("zipcode"));
		Thread.sleep(3000);
		homepage.clickNextOnCompanydetails();
		System.out.println("Company Details filled succefully");
		Thread.sleep(3000);
		homepage.UserFirstName(dataProp.getProperty("userfirstname"));
		Thread.sleep(3000);
		homepage.UserLastName(dataProp.getProperty("userlastname"));
		Thread.sleep(3000);
		homepage.UserEmail(dataProp.getProperty("email"));
		Thread.sleep(3000);
		homepage.UserPassword(dataProp.getProperty("password"));
		Thread.sleep(3000);
		homepage.UserConfirmPassword(dataProp.getProperty("confirmpassword"));
		Thread.sleep(3000);
		homepage.clickContinuToSignin();
		Thread.sleep(3000);
		System.out.println("User Details filled successfully");
		Thread.sleep(3000);
		System.out.println("Register is Done ----> PASSED ");
	}
}
