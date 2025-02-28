package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txt_firstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txt_lastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_email;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txt_phone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_password;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txt_confirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chk_policy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btn_continue;

	@FindBy(xpath = "//div[@id='content']/h1")
	WebElement msg_confirmation;

	public void setFirstName(String firstName) {
		txt_firstName.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		txt_lastName.sendKeys(lastName);
	}

	public void setEmail(String email) {
		txt_email.sendKeys(email);
	}

	public void setPhone(String phone) {
		txt_phone.sendKeys(phone);
	}

	public void setPassword(String password) {
		txt_password.sendKeys(password);
	}

	public void setConfirmPassword(String password) {
		txt_confirmPassword.sendKeys(password);
	}

	public void clickPolicy() {
		chk_policy.click();
	}

	public void clickContinue() {
		btn_continue.submit();
	}

	public String getConfirmationMessage() {
		String confirmationMessage = msg_confirmation.getText();
		return confirmationMessage;
	}
}
