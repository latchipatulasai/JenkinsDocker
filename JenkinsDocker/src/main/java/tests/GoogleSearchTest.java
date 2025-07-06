package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GoogleSearchTest {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;

	@BeforeSuite
	public void setUpReport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		ChromeOptions options = new ChromeOptions();

		// Examples of useful options:
		options.addArguments("--start-maximized"); // Open maximized
		options.addArguments("--incognito"); // Open in incognito
		options.addArguments("--disable-notifications"); // Disable notifications
		options.addArguments("--enable-automation");
	}

	@Test
	public void searchTest() throws InterruptedException {
		test = extent.createTest("Google Search Test");

		driver.get("https://google.com");
		test.info("Opened Google");

		driver.findElement(By.name("q")).sendKeys("sailatchipatula", Keys.ENTER);
		test.pass("Search completed");
		Thread.sleep(5000);
		
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		test.info("Closed browser");
	}

	@AfterSuite
	public void flushReport() {
		extent.flush();
	}
}
