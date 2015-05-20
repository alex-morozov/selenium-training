package ru.st.selenium.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.st.selenium.applogic.ApplicationManager;
import ru.st.selenium.applogic2.ApplicationManager2;
import training.util.Browser;
import training.util.PropertyLoader;
import training.webdriver.WebDriverFactory;

/*
 * Base class for all the test classes
 * 
 * @author Sebastiano Armeli-Battana
 */

public class TestBase {
	private static final String SCREENSHOT_FOLDER = "target/screenshots/";
	private static final String SCREENSHOT_FORMAT = ".png";
	
	protected ApplicationManager app;	
	protected static WebDriver driver;
	protected String gridHubUrl;
	protected static String baseUrl;
	protected Browser browser;
	protected StringBuffer verificationErrors = new StringBuffer();

	@BeforeSuite
	public void init() {
		baseUrl = PropertyLoader.loadProperty("site.url");
		gridHubUrl = PropertyLoader.loadProperty("grid2.hub");
		app = new ApplicationManager2();
		browser = new Browser();
		browser.setName(PropertyLoader.loadProperty("browser.name"));
		browser.setVersion(PropertyLoader.loadProperty("browser.version"));
		browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

		String username = PropertyLoader.loadProperty("user.username");
		String password = PropertyLoader.loadProperty("user.password");
		
		driver = WebDriverFactory.getInstance(gridHubUrl, browser, username,
				password);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterSuite
	public void stop() {
	  app.stop();
	}	

/*	@AfterMethod
	public void setScreenshot(ITestResult result) {
		if (!result.isSuccess()) {
			try {
				WebDriver returned = new Augmenter().augment(driver);
				if (returned != null) {
					File f = ((TakesScreenshot) returned)
							.getScreenshotAs(OutputType.FILE);
					try {
						FileUtils.copyFile(f, new File(SCREENSHOT_FOLDER
								+ result.getName() + SCREENSHOT_FORMAT));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (ScreenshotException se) {
				se.printStackTrace();
			}
		}
	}  */
}
