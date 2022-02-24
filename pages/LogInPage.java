package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {

	public WebDriver driver;
	WebElement username;
	WebElement password;
	WebElement submitButton;

	// Konstruktor za drajver

	public LogInPage(WebDriver driver) {
		this.driver = driver;
	}

	//Geteri za elemente
	public WebElement getUsername() {
		return driver.findElement(By.id("username"));
	}

	public WebElement getPassword() {
		return driver.findElement(By.id("password"));
	}

	public WebElement getSubmitButton() {
		return driver.findElement(By.id("submit"));
	}

	//Metode
	public void InsertUsername(String UsernameData) {
		this.getUsername().clear();
		this.getUsername().sendKeys(UsernameData);
	}

	public void InsertPassword(String PasswordData) {
		this.getPassword().clear();
		this.getPassword().sendKeys(PasswordData);
	}

	public void SubmitClick() {
		this.getSubmitButton().click();
	}
	
	
}
