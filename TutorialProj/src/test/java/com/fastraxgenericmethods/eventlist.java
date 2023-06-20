package com.fastraxgenericmethods;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class eventlist implements ITestListener {
	public void onTestFailure(ITestResult result) {
		File src=((TakesScreenshot)Base1.driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("screenShot/;"+System.currentTimeMillis()+".png");
		try {
			FileUtils.copyFile(src, dest);
		}catch(IOException e) {
			e.printStackTrace();
		}
		}
	   }
	
