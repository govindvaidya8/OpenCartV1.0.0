package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LogInTestDDT extends BaseClass {
	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class, groups = "dataDriven")
	public void testLoginDDT(String username, String password, String usecase) throws InterruptedException {
		logger.info("*****Starting TC_003_LogInTestDDT*****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LogInPage lp = new LogInPage(driver);
			lp.setUserName(username);
			lp.setPassword(password);
			lp.clickLogIn();

			MyAccountPage macc = new MyAccountPage(driver);
			boolean myAccountExists = macc.isMyAccountExists();
			if (usecase.equalsIgnoreCase("Valid")) {
				if (myAccountExists == true) {
					macc.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (usecase.equalsIgnoreCase("Invalid")) {
				if (myAccountExists == true) {
					macc.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
		logger.info("*****Finished TC_003_LogInTestDDT*****");

	}
}
