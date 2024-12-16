package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.MyAccountPage;
import TestBase.BaseClass;
import Utilities.DataProviders;

public class TC003_LoginTestDDT extends BaseClass {
	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups = {"dataproviders","master"})
	public void verify_loginDDT(String email,String pwd,String ExpRes) throws InterruptedException
	{
		logger.info("*****Started login test******");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		logger.info("****enter credentials to login page***");
		LoginPage lg= new LoginPage(driver);
		lg.setEmail(email);
		lg.setPassword(pwd);
		Thread.sleep(3000);
		lg.clickLogin();
		
		
		
		logger.info("**verify if myaccount page is displayed***");
		MyAccountPage mg=new MyAccountPage(driver);
		boolean targetPage=mg.isMyAccountpageExist();
		
		//if data is valid and login is success -pass -logout
		//if data is valid and login is unsuccessful -fail
		//if data is invalid and login is successful - fail - logout
		//if data is invalid and login is unsuccessful-pass
		// we need to logout each time in DDT to start entering data from the starting
		
		if(ExpRes.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
				mg.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			
			
		}
		if(ExpRes.equalsIgnoreCase("invalid"))
		{
			if(targetPage==true)
			{
				mg.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		logger.info("**finished***");
		
	}
}
		 
		


