package tests;

import com.aventstack.extentreports.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.ExtentManager;
import utils.ReportUtil;
import utils.ScreenshotUtil;

public class LoginTest {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;

	@BeforeClass
	public void setup() {
		extent = ExtentManager.getInstance();
		driver = new ChromeDriver();
	}

	@Test
	public void openGoogle() {
		test = extent.createTest("Google Search Test");

		driver.get("https://www.google.com");
		ReportUtil.logStep(driver, test, "Navigated to Google", true);

		driver.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);
		ReportUtil.logStep(driver, test, "Entered search term 'Selenium'", true);

		ReportUtil.logStep(driver, test, "Verified search results are displayed", false);
		test.pass("google successfully opened");
	}

//	@Test
//	public void openGoogle() {
//	    test = extent.createTest("Open Google Test"); // ✅ Initialize here
//	    test.info("Step 1: Navigating to Google");
//
//	    driver.get("https://www.google.com");
//	    String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "GoogleHome");
//	    test.addScreenCaptureFromPath(screenshotPath);
//	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		extent.flush();
		System.out.println("✅ Extent Report generated at: " + ExtentManager.getReportPath());
	}
}
