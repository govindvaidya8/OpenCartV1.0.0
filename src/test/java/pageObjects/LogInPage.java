package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {

	public LogInPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_username;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btn_login;

	public void setUserName(String username) {
		txt_username.sendKeys(username);
	}

	public void setPassword(String password) {
		txt_password.sendKeys(password);
	}

	public void clickLogIn() {
		btn_login.click();
	}

}
