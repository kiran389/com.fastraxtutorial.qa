package com.fastrax.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	//objects
	@FindBy(xpath="//button[text()='Create an Account']")
	private WebElement createnewacc;

	@FindBy(linkText ="Create motor carrier account")
	private WebElement tocheckmotor;

	@FindBy(linkText = "Create motor carrier account")
	private WebElement clickonmotoracc;

	@FindBy(css = "*[class='btn btn-primary nextBtn']")
	private WebElement clickonnextbutton;

	//company details
	@FindBy(xpath = "//input[@id='companyName']")
	private WebElement companyName;

	@FindBy(xpath = "//input[@id='dot']")
	private WebElement dotNumber;

	@FindBy(xpath = "//input[@id='address']")
	private WebElement companyaddress;

	@FindBy(xpath = "//input[@id='city']")
	private WebElement companycity;

	@FindBy(xpath = "//input[@id='state']")
	private WebElement companystate;

	@FindBy(xpath = "//input[@id='zipCode']")
	private WebElement companyzipcode;

	@FindBy(xpath = "//*[@type='submit']")
	private WebElement CompanyNextbutton;

	//user details
	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement userFirstName;

	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement userLastName;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement userEmail;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement userPassword;

	@FindBy(xpath = "//input[@id='confirmPassword']")
	private WebElement userConfirmPassword;

	@FindBy(xpath = "//button[text()='Continue to sign in']")
	private WebElement clickcontinutoSignin;




//this is only  for one page i.e HomePage.class
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	//actions
	public void clickonnewaccount() {
		createnewacc.click();
	}

	public void checkmototacc() {
		boolean motorDisplayed=	tocheckmotor.isDisplayed();
		System.out.println("Is motor account displayed? "+ motorDisplayed);
	}

	public void clickonmotoracc() {
		clickonmotoracc.click();
	}
	//to click on next button
	public void clickonnextbutton() {
		try {
			clickonnextbutton.click();
		}catch(Exception e) {
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].click();", clickonnextbutton);

		}

	}
	public void companyName(String company) {
		companyName.sendKeys(company);

	}
	public void dotNumber(String dotnumber) {
		dotNumber.sendKeys(dotnumber);
	}

	public void companyAddress(String address) {
		companyaddress.sendKeys(address);
	}
	public void companycity(String city) {
		companycity.sendKeys(city);
	}
	public void companystate(String state) {
		companystate.sendKeys(state);
	}
	public void companyzip(String zipcode) {
		companyzipcode.sendKeys(zipcode);
	}
	//to click on next button on create companydetails page
	public void clickNextOnCompanydetails() {
		try {
			CompanyNextbutton.sendKeys();
		}catch(Exception e) {
			JavascriptExecutor je= (JavascriptExecutor) driver;
			je.executeScript("arguments[0].click();", CompanyNextbutton);
		}	
	}
	public void UserFirstName(String firstnameUser) {
		userFirstName.sendKeys(firstnameUser);
	}

	public void UserLastName(String lastnameUser) {
		userLastName.sendKeys(lastnameUser);
	}
	public void UserEmail(String emailUser) {
		userEmail.sendKeys(emailUser);
	}
	public void UserPassword(String passwordUser) {
		userPassword.sendKeys(passwordUser);
	}
	public void UserConfirmPassword(String Confirmpassworduser) {
		userConfirmPassword.sendKeys(Confirmpassworduser);
	}
	public void clickContinuToSignin() {
		clickcontinutoSignin.click();
	}
	






}
