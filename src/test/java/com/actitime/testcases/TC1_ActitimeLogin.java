package com.actitime.testcases;

import java.io.IOException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.actitime.pages.LoginPage;
import com.actitime.utility.BaseTest;

@Listeners(com.actitime.utility.Screenshot.class)
public class TC1_ActitimeLogin extends BaseTest
{
	@Test
	public void login() throws IOException
	{
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginMethod();
	}
}