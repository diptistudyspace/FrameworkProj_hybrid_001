package TestClasses;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.AccountPage;
import PageObject.LandingPage;
import PageObject.LoginPage;
import Resources.Base;

public class LoginTestDataProvider extends Base {

	public WebDriver driver;

	@Test(dataProvider = "getLoginData")
	public void loginDataProvider(String email, String password, String expectedStatus) throws IOException {

		// Interact with the landing page
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		landingPage.loginOption().click();

		// Interact with the login page
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressField().sendKeys(email); // Corrected: Pass the email parameter
		loginPage.passwordField().sendKeys(password); // Corrected: Pass the password parameter
		loginPage.loginButton().click();

		// Initialize the AccountPage object
		AccountPage accountPage = new AccountPage(driver);

		String actualResult = null;
		try {
			// Check if the My Account section is displayed
			if (accountPage.MyAccount().isDisplayed()) {
				actualResult = "Successfull";
			}
		} catch (Exception e) {
			actualResult = "Failure";
		}

		// Assert the actual result matches the expected status
		Assert.assertEquals(actualResult, expectedStatus);
	}

	@BeforeMethod
	public void openApplication() throws IOException {
		// Initialize the browser and navigate to the URL
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));

	}

	@AfterMethod
	public void tearDown() {
		// Close the browser after each test method
		driver.close();
	}

	@DataProvider
	public Object[][] getLoginData() {
		// Provide test data for login tests
		Object[][] data = { { "studyspace0202@gmail.com", "Second@123", "Failure" },
				{ "dummy@test.com", "1234", "Failure" }, { "study@gmail.com", "12345", "Failure" } };
		return data; // Corrected: Return the data array
	}
}
