package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountDropdown;

	public WebElement myAccountDropdown() {
		return myAccountDropdown;
	}

	@FindBy(xpath = "//a[normalize-space()='Register']")
	private WebElement registerField;

	public WebElement registerField() {
		return registerField;
	}

	@FindBy(id = "input-firstname")
	private WebElement firstName;

	public WebElement firstName() {
		return firstName;
	}
	
	@FindBy(id = "input-lastname")
	private WebElement lastName;

	public WebElement lastName() {
		return lastName;
	}
	
	@FindBy(id = "input-email")
	private WebElement emailField;

	public WebElement emailField() {
		return emailField;
	}

	@FindBy(id = "input-telephone")
	private WebElement telePhone;

	public WebElement telePhone() {
		return telePhone;
	}
	
	@FindBy(id = "input-password")
	private WebElement passwordFieldOne;

	public WebElement passwordFieldOne() {
		return passwordFieldOne;
	}
	
	@FindBy(id = "input-confirm")
	private WebElement passwordFieldTwo;

	public WebElement passwordFieldTwo() {
		return passwordFieldTwo;
	}
	
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicy;

	public WebElement privacyPolicy() {
		return privacyPolicy;
	}
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueField;

	public WebElement continueField() {
		return continueField;
	}
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement continueFieldTwo;

	public WebElement continueFieldTwo() {
		return continueFieldTwo;
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountDropdownTwo;

	public WebElement myAccountDropdownTwo() {
		return myAccountDropdownTwo;
	}
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	private WebElement logoutField;

	public WebElement logoutField() {
		return logoutField;
	}
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement continueToHome;

	public WebElement continueToHome() {
		return continueToHome;
	}
}		
