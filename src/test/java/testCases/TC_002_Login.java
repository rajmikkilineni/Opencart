package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass {
	
	@Test(groups={"sanity","master"})
	public void test_login()
	{
		logger.info("Starting TC_002_Login");
		
		try
		{
			driver.get(rb.getString("appURL"));
			logger.info("Home Page displayed");
			
			driver.manage().window().maximize();
			
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account");
			
			hp.clickLogin();
			logger.info("Clicked on Login");
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(rb.getString("email"));
			logger.info("Provided email");
			
			lp.setPassword(rb.getString("password"));
			logger.info("Provided Password");
			
			lp.clickLogin();
			logger.info("clicked on login button");
			
			boolean targetpage=lp.isMyAccountPageExists();
			if(targetpage)
			{
				logger.info("Login Success");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("login failed");
				captureScreen(driver,"test_login");//capturing Screenshot
				Assert.assertTrue(false);			
			}
			
		}
		catch(Exception e)
		{
			logger.fatal("Login Failed");
			Assert.fail();
		}
		
		logger.info(" Finished TC_002_Login");
		
		
	}

}
