package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeBrowser() throws IOException {

		// Initialize the Properties object
		prop = new Properties();
		String propPath = System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\data.properties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();

		return driver;
	}

// Method to take a screenshot
	public String takeScreenshot(String testName, WebDriver driver) throws IOException {
		// Convert WebDriver object to TakesScreenshot
		TakesScreenshot ts = (TakesScreenshot) driver;

		// Capture screenshot as an image file
		File source = ts.getScreenshotAs(OutputType.FILE);

		// Define destination path for the screenshot
		String destinationPath = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
		File destination = new File(destinationPath);

		// Copy the screenshot to the destination
		FileUtils.copyFile(source, destination);

		System.out.println("Screenshot taken for test: " + testName);

		// Return the screenshot file path
		return destinationPath;
	}

}