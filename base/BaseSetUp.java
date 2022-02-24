package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.LogInPage;
import pages.LogOutPage;

public class BaseSetUp {

	public WebDriver driver;
	public LogInPage loginPage;
	public LogOutPage logOutPage;
	public WebDriverWait wdwait;

	@BeforeClass

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		wdwait = new WebDriverWait(driver, 10);
		loginPage = new LogInPage(driver);
		logOutPage = new LogOutPage(driver);
	}

	@AfterClass
	public void TearDown() {
		driver.close();
		driver.quit();
	}
}
