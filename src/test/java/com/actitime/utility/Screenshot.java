package com.actitime.utility;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Screenshot implements ITestListener
{
	@Override
	public void onTestFailure(ITestResult result) 
	{
		TakesScreenshot ts=(TakesScreenshot)BaseTest.driver;
		File scrFile=ts.getScreenshotAs(OutputType.FILE);
		if(result.getStatus()==2)
			Reporter.log(result.getName() + " test case is failed");
		String methodName = result.getName();
		Date date=Calendar.getInstance().getTime();
		String today=date.toString().replaceAll(":", "-");
		try 
		{
			FileHandler.copy(scrFile, new File("./failedscreenshot/" +methodName +today +".png"));
		} 
		catch (IOException e) 
		{
			Reporter.log("check the format" , true);
			System.out.println(e.getMessage());
		}
	}
}