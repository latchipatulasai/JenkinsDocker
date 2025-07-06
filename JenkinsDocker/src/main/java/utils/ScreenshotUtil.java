package utils;

import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {
	public static String captureScreenshot(WebDriver driver, String screenshotName) {
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String dest = "ExtentReports/screenshots/" + screenshotName + ".png";
			FileUtils.copyFile(src, new File(dest));
			return "./screenshots/" + screenshotName + ".png"; // Relative path for report
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
//--------------------------------
//package utils;
//
//import org.openqa.selenium.*;
//import org.apache.commons.io.FileUtils;
//
//import java.io.File;
//import java.io.IOException;
//
//public class ScreenshotUtil {
//
//    public static String captureScreenshot(WebDriver driver, String screenshotName) {
//        try {
//            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            String path = "test-output/screenshots/" + screenshotName + ".png";
//            FileUtils.copyFile(src, new File(path));
//            return "./screenshots/" + screenshotName + ".png"; // Relative path for Extent Report
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}
