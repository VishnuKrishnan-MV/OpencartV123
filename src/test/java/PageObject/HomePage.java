package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		
		super(driver);
		// this will invoke parent class constructor
	}
	
	//locators
    @FindBy(xpath = "//a[@title='My Account']")
    WebElement lnkMyAccount;
	
    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement lnkregister;
    
    @FindBy(xpath = "//a[normalize-space()='Login']")// created in 51th session 
    WebElement lnkLogin;
    
    //action class
    public void clickMyAccount()
    {
    	lnkMyAccount.click();
    }
	
    public void clickRegister()
    {
    	lnkregister.click();
    }
	
    public void clickLogin()
    {
    	lnkLogin.click();
    }
	

}
