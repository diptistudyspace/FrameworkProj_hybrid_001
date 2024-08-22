package TestClasses;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import PageObject.AccountPage;
import PageObject.LandingPage;
import PageObject.LoginPage;
import Resources.Base;

public class LoginTest extends Base {

	public WebDriver driver;

	@Test
	public void login() throws IOException {

		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));

		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		landingPage.loginOption().click();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressField().sendKeys(prop.getProperty("email"));
		loginPage.passwordField().sendKeys(prop.getProperty("password"));
		loginPage.loginButton().click();

		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.MyAccount().isDisplayed());
		
		 
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
