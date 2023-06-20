package com.fastraxgenericmethods;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;





public class Base1 {
	
	public	static WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	public void loadPropertiesFile() {
		
		prop=new Properties();
		File propFile = new File("C:\\Users\\ZIBTEK\\eclipse-workspace\\TutorialProj\\src\\test\\java\\com\\fastrax\\propertiesfile\\config.properties");
                                  
		dataProp= new Properties();
		File dataPropFile = new File("C:\\Users\\ZIBTEK\\eclipse-workspace\\TutorialProj\\src\\test\\java\\com\\fastrax\\propertiesfile\\testdata.properties");
		
		try {
			FileInputStream	fis = new FileInputStream(dataPropFile);
			dataProp.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream	fis1 = new FileInputStream(propFile);
			prop.load(fis1);
		} catch (IOException e) { 
			e.printStackTrace();
		}

	}

	public WebDriver initializeAndOpenBrowser(String browserName) throws InterruptedException {

		ChromeOptions options= new ChromeOptions();
		FirefoxOptions options1 = new FirefoxOptions();
		InternetExplorerOptions options2 = new InternetExplorerOptions();
		options.addArguments("--remote-allow-origins=*");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(options);
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver(options1);
		}else if (browserName.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver(options2);	
		}
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(commonUtilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(commonUtilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));
		return driver;
	}
	

}


