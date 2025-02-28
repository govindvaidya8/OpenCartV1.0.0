package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.ConfigReader;

public class TC_002_LogInTest extends BaseClass {

	@Test(groups = {"regression","master"})
	public void testLogin() {
		logger.info("******Starting TC_002_LogInTest*******");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			String username = ConfigReader.getProperty("username");
			String password = ConfigReader.getProperty("password");
			
			LogInPage lp = new LogInPage(driver);
			lp.setUserName(username);
			lp.setPassword(password);
			lp.clickLogIn();
			
			MyAccountPage macc = new MyAccountPage(driver);
			String act_myAccount = macc.getMyAccount();
			
			if (act_myAccount.equals("My Account")) {
				logger.info("Validation Success for LogIn Test");
				Assert.assertTrue(true);
			} else {
				logger.info("Validation Failed for LogIn Test");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("******Finished TC_002_LogInTest*******");
	}
}
