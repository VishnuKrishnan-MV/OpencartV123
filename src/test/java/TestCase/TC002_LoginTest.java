package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.MyAccountPage;
import TestBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups = {"sanity","master"})
	public void verify_login() throws InterruptedException
	{
		logger.info("*****Started login test******");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		logger.info("****enter credentials to login page***");
		LoginPage lg= new LoginPage(driver);
		lg.setEmail(p.getProperty("email"));
		lg.setPassword(p.getProperty("password"));
		Thread.sleep(3000);
		lg.clickLogin();
		
		
		logger.info("**verify if myaccount page is displayed***");
		MyAccountPage mg=new MyAccountPage(driver);
		if(mg.isMyAccountpageExist()==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
		
		 
		
	}

}
