
package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
	private static ExtentReports extent;
	private static String reportPath;

	public static ExtentReports getInstance() {
		if (extent == null) {
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			reportPath = "ExtentReports/ExtentReport_" + timestamp + ".html";

			ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
			reporter.config().setReportName("Automation Test Report");
			reporter.config().setDocumentTitle("Extent Report");

			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Sai Latchipatula");
		}
		return extent;
	}

	public static String getReportPath() {

		String path = System.getProperty("user.dir") + "/" + reportPath;
		return path;
	}
}

//----------------------------------old
//package utils;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//
//public class ExtentManager {
//	private static ExtentReports extent;
//
//	public static ExtentReports getInstance() {
//		if (extent == null) {
//			ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
//			reporter.config().setReportName("Automation Test Report");
//			reporter.config().setDocumentTitle("Extent Report Demo");
//
//			extent = new ExtentReports();
//			extent.attachReporter(reporter);
//			extent.setSystemInfo("Tester", "Sai Latchipatula");
//		}
//		return extent;
//	}
//}
