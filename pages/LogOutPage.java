package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogOutPage {

	WebDriver driver;
	public WebElement LogOut;
	public WebElement SuccessfullyMsg;

	
	public LogOutPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public WebElement getLogOut() {
	return 	driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
	//	return driver.findElement(By.cssSelector("body.page-template-default.page.page-id-257.wp-custom-logo.full-post:nth-child(2) div.overflow-container:nth-child(2) div.max-width section.main-container div.loop-container div.post-257.page.type-page.status-publish.hentry.entry div.post-content div.wp-container-61f680f917e85.wp-block-group:nth-child(2) div.wp-block-group__inner-container div.wp-block-button.aligncenter.is-style-fill > a.wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color"));	
	}
	public WebElement getSuccessfullyMsg() {
		return driver.findElement(By.cssSelector("#loop-container > div > article > div.post-header > h1"));
	}

	public void LogOutClick() {
		this.getLogOut().click();
	}
}
