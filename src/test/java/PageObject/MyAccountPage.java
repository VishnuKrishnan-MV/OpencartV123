package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btnLogout;
	
	
	//action methods
	// we need to validate whtr my account is valid or not
	public boolean isMyAccountpageExist()
	{
		try {
		boolean msg=msgHeading.isDisplayed();
		return msg;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	public void clickLogout()
	{
		btnLogout.click();
	}

}
