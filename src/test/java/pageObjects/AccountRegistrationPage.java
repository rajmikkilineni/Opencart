package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationPage {
	
	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}

	@FindBy(id="input-firstname")
	WebElement txtFirstName;
	
	@FindBy(id="input-lastname")
	WebElement txtLastName;
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="telephone")
	WebElement txtTelephone;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="confirm")
	WebElement txtConfirmPassword;
	
	@FindBy(name="agree")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")////h1[normalize-space()='Your Account Has Been Created!']
	WebElement msgConfirmation;
	
	public void setFirstName(String fname) 
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setlastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelePhone(String tel)
	{
		txtTelephone.sendKeys(tel);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String cfpwd)
	{
		txtConfirmPassword.sendKeys(cfpwd);
	}
	
	public void setPrivacyPolicy()
	{
		chkdPolicy.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmationMsg() 
	{
		 try
	    {
	 	     return (msgConfirmation.getText());
	    }
		 
		 catch (Exception e)
		 {
			return (e.getMessage());
		 }
	
	}
}
