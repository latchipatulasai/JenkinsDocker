package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;

public class ReportUtil {

	public static void logStep(WebDriver driver, ExtentTest test, String message, boolean captureScreenshot) {
		try {
			if (captureScreenshot) {
				String screenshotPath = ScreenshotUtil.captureScreenshot(driver,
						message.replaceAll("[^a-zA-Z0-9]", "_"));
				test.info(message, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				test.info(message);
			}
		} catch (Exception e) {
			test.warning("Failed to log step or capture screenshot: " + e.getMessage());
		}
	}
}
