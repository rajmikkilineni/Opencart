package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass {
	
	
	@Test(groups={"regression","master"})
	public void test_account_Registration()
	{
		try
		{
		
		logger.info("Starting TC_001_AccountRegistration");
		
		driver.get(rb.getString("appURL"));
		
		logger.info("Home Page displayed");
		driver.manage().window().maximize();
		logger.info("Browser maximized");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on My Account ");
		hp.clickRegister();
		logger.info("clicked on the Register link");
		
		AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
		
		regpage.setFirstName("phylp");
		logger.info("Provided First Name");
		regpage.setlastName("canedy");
		logger.info("Provided last Name");
		regpage.setEmail(randomstring()+"@gmail.com");
		logger.info("Provided email");
		regpage.setTelePhone("2534889452");
		logger.info("Provided Telephone number");
		regpage.setPassword("gbefsr");
		logger.info("Provided password");
		regpage.setConfirmPassword("gbefsr");
		logger.info("Provided confirmed password");
		regpage.setPrivacyPolicy();
		logger.info("checked Privacy Policy");
		regpage.clickContinue();
		logger.info("clicked on Continue button");
		
		String confmsg=regpage.getConfirmationMsg();
		//System.out.println(confmsg);
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Account Registration success");
			Assert.assertTrue(true);
			
		}
		
		else
		{
			logger.info("Account Registration failed");
			Assert.assertTrue(false);
		}
		
		}
		
		
		catch (Exception e)
		{
			logger.info("Account Registration failed");
			Assert.assertTrue(false);
		}
		
		logger.info("Finished TC_001_AccountRegistration");
	}
	
	
}
