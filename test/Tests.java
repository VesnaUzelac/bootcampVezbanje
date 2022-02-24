package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseSetUp;

public class Tests extends BaseSetUp {

	@BeforeMethod

	public void pageSet() {

		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}

	@Test(priority = 10)
	public void SuccLogIn() {
		loginPage.InsertUsername("student");
		loginPage.InsertPassword("Password123");
		loginPage.SubmitClick();

		WebElement Message = driver.findElement(By.cssSelector(
				"#loop-container > div > article > div.post-content > p.has-text-align-center > strong"));
		String ExpectedMessage = ("Congratulations student. You successfully logged in!");
		String ActualMessage = Message.getText();
		Assert.assertEquals(ActualMessage, ExpectedMessage);
		System.out.println("Succesful login message: " + ActualMessage);
		Assert.assertTrue(logOutPage.getLogOut().isDisplayed());
		logOutPage.LogOutClick();
		WebElement LogOutMessage = driver.findElement(By.xpath("//h2[contains(text(),'Test login')]"));
		String ExpectedLOMessage = ("Test login");
		String ActualLOMessage = LogOutMessage.getText();
		Assert.assertEquals(ActualLOMessage, ExpectedLOMessage);
		System.out.println("Succesful logout message:" + ActualLOMessage);
	}
	

	@Test(priority = 20)
	public void IncUsername() throws InterruptedException {
		loginPage.InsertUsername("tudent");
		loginPage.InsertPassword("Password123");
		loginPage.SubmitClick();
	
		WebElement IncUserMessage = driver.findElement(By.cssSelector("#error"));
		
		String ActualMessage1 = IncUserMessage.getText();
		String ExpectedMessage1 = ("Your username is invalid!");
		Assert.assertEquals(ActualMessage1, ExpectedMessage1);
		System.out.println("Incorect username message: "+ActualMessage1);

	}
	

	@Test(priority = 30)
	public void IncPassword() throws InterruptedException {
		loginPage.InsertUsername("student");
		loginPage.InsertPassword("Pass123");
		loginPage.SubmitClick();
		

		WebElement IncPassMessage = driver.findElement(By.xpath("//div[@id='error']"));
		
		String ActualMessage2 = IncPassMessage.getText();
		String ExpectedMessage2 = ("Your password is invalid!");
		Assert.assertEquals(ActualMessage2, ExpectedMessage2);
		System.out.println("Incorect password message: "+ActualMessage2);
		
	}


	 
	@AfterMethod
	public void DeleteCockies() {
		driver.manage().deleteAllCookies();
	}
}
