package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.ConfigReader;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;

	@BeforeClass(groups = { "sanity", "regression", "master" })
	@Parameters("browser")
	public void setup(String browser) throws IOException {

		System.setProperty("log4j2.debug", "true");
		System.setProperty("log4j.configurationFile", "src/test/resources/log4j2.xml");

		String url = ConfigReader.getProperty("url");

		logger = LogManager.getLogger(this.getClass());

		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid Browser...");
			// logger.error("Invalid Browser");
			Assert.fail();
			return;
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);

	}

	@AfterClass(groups = { "sanity", "regression", "master" })
	public void tearDown() {
		driver.quit();
	}

	@SuppressWarnings("deprecation")
	public String randomString() {
		return RandomStringUtils.randomAlphabetic(5);

	}

	@SuppressWarnings("deprecation")
	public String randomNumber() {
		return RandomStringUtils.randomNumeric(10);
	}

	public String randomPassword() {
		@SuppressWarnings("deprecation")
		String password = RandomStringUtils.randomAlphabetic(5) + "$" + RandomStringUtils.randomNumeric(3);
		return password;
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}
}
