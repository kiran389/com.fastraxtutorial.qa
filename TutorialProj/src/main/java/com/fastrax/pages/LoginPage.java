package com.fastrax.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id=\"exampleInputEmail1\"]")
	private WebElement validEmail;
	
	@FindBy(xpath = "//input[@id=\"exampleInputPassword1\"]")
	private WebElement validPassword;
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
public void valEmail(String validemail) {
	validEmail.sendKeys(validemail);
}

	public void valPassword(String validpassword) {
		validPassword.sendKeys(validpassword);
	
	
}
}
