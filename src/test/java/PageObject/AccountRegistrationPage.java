package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		
		super(driver);
		
	}
	//locators
	@FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txt_firstname;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txt_lastname;
	
	@FindBy(xpath = "//input[@id='input-email']")
    WebElement txt_email;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
    WebElement txt_telephone;
	
	@FindBy(xpath = "//input[@id='input-password']")
    WebElement txt_password;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
    WebElement txt_confirmPwd;
	
	@FindBy(xpath = "//input[@value='0']")
    WebElement rdo_subscribe;
	
	@FindBy(xpath = "//input[@name='agree']")
    WebElement chk_policy;
	
	@FindBy(xpath = "//input[@value='Continue']")
    WebElement btn_Continue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msg_confrimation;
	
	
	//action methods
	
	
	public void setFirstname(String name)
	{
		txt_firstname.sendKeys(name);
	}
	
	public void setLastname(String Lname)
	{
		txt_lastname.sendKeys(Lname);
	}
	
	public void Email(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void telephone(String phn)
	{
		txt_telephone.sendKeys(phn);
	}
	
	public void Password(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	
	public void ConfirmPassword(String pwd)
	{
		txt_confirmPwd.sendKeys(pwd);
	}
	
	public void subscribe_button()
	{
		rdo_subscribe.click();
	}
	
	public void Chk_policy()
	{
		chk_policy.click();
	}
	
	public void clickContinue()
	{
		btn_Continue.click();
		
		/*btn_Continue.submit();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argument[0].click()", btn_Continue);
		
		btn_Continue.sendKeys(Keys.RETURN);
		
		WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(5));
		mywait.until(ExpectedConditions.elementToBeClickable(btn_Continue)).click();
		
		Actions act= new Actions(driver);
		act.moveToElement(btn_Continue).click().perform();
		
		*/
	}
	//we don't do validation here but we capture the confirmation msg and validate in test method
	public String getConfrimationMsg()
	{
		try {
		String msg=msg_confrimation.getText();
		return msg;
		}
		
		catch (Exception e) {
			return (e.getMessage());
		}
		//if in any stage of execution fails and this msg is not obtained there is
		// chance of returning exception the our code may not work so we will add a try 
	}
	
	

	
	

	
	
	
	
}
