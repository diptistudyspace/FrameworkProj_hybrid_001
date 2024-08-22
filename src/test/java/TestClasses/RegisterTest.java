package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import PageObject.RegisterPage;
import Resources.Base;

public class RegisterTest extends Base {

	public WebDriver driver;

	@Test
	public void register() throws IOException {

		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));

		RegisterPage registerPage = new RegisterPage(driver);

		registerPage.myAccountDropdown().click();
		registerPage.registerField().click();
		registerPage.firstName().sendKeys(prop.getProperty("firstName"));
		registerPage.lastName().sendKeys(prop.getProperty("lastName"));
		registerPage.emailField().sendKeys(prop.getProperty("emailReg"));
		registerPage.telePhone().sendKeys(prop.getProperty("telephone"));
		registerPage.passwordFieldOne().sendKeys(prop.getProperty("password"));
		registerPage.passwordFieldTwo().sendKeys(prop.getProperty("conformPassword"));
		registerPage.privacyPolicy().click();
		registerPage.continueField().click();
		registerPage.continueFieldTwo().click();
		registerPage.myAccountDropdownTwo().click();
		registerPage.logoutField().click();
		registerPage.continueToHome().click();

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
