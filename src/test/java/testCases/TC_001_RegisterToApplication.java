package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC_001_RegisterToApplication extends BaseClass {

	@Test(groups = {"sanity","master"})
	public void testRegister() {
		try {
			logger.info("******Starting TC_001_RegisterToApplication*******");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();
			RegisterPage rp = new RegisterPage(driver);
			rp.setFirstName(randomString());
			rp.setLastName(randomString());
			rp.setEmail(randomString() + "@gmail.com");
			rp.setPhone(randomNumber());
			String password = randomPassword();
			rp.setPassword(password);
			rp.setConfirmPassword(password);
			rp.clickPolicy();
			rp.clickContinue();
			String confirmationMessage = rp.getConfirmationMessage();
			Assert.assertEquals(confirmationMessage, "Your Account Has Been Created!");
			if (confirmationMessage.equals("Your Account Has Been Created!")) {
				logger.info("Validation Passed for Registration");
				Assert.assertTrue(true);
				
			} else {
				logger.info("Validation failed for Registration");
				Assert.assertTrue(false);
				
			}
			Thread.sleep(3000);

		} catch (Exception e) {

			Assert.fail(e.getMessage());
		}

		logger.info("*****Finished TC_001_RegisterToApplication*****");
	}

}
