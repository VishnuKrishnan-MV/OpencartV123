package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AccountRegistrationPage;
import PageObject.HomePage;
import TestBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	
	//public WebDriver driver;
	
	@Test(groups = {"regression","master"})
	void Verify_account_registration()
	{
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on my account link");
		
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		logger.info("Providing customer details");
		AccountRegistrationPage ac=new AccountRegistrationPage(driver);
		ac.setFirstname(randomeString().toUpperCase());
		ac.setLastname(randomeString().toUpperCase());
		ac.Email(randomeString()+"@gmail.com");
		ac.telephone(randomeNumber());
		
		String pwd=randomeAlphaNumeric();
				
		ac.Password(pwd);
		ac.ConfirmPassword(pwd);
		
		ac.subscribe_button();
		
		ac.Chk_policy();
		ac.clickContinue();
		
		if(ac.getConfrimationMsg().equals( "Your Account Has Been Created!"))
		{
			logger.info("****validating expected message*****");
		    Assert.assertTrue(true);
		}
		else
		{logger.debug("****the validation is failed****");
		 logger.error("****error logs*****");
		
		Assert.assertTrue(false);
		
		}
		
		logger.info("*****the test is finnished*****");
		
		
		
		
	}
	
	
	

}
