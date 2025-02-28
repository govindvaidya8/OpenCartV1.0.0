package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='content']/h2[1]")
	WebElement myAccount;

	@FindBy(xpath = "//aside[@id='column-right']//a[normalize-space()='Logout']")
	WebElement lnk_logout;

	@FindBy(xpath = "//a[normalize-space()='Continue']")
	WebElement btn_continue;

	public String getMyAccount() {
		String myaccount = myAccount.getText();
		return myaccount;
	}

	public void clickLogout() {
		lnk_logout.click();
	}

	public void clickContinue() {
		btn_continue.click();
	}

	public boolean isMyAccountExists() {
		try {
			boolean myaccount = myAccount.isDisplayed();
			return myaccount;
		} catch (Exception e) {
			return false;
		}

	}
}
