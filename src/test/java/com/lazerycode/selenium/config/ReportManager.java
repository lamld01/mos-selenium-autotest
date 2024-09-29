package com.lazerycode.selenium.config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.lazerycode.selenium.DriverBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportManager {
  private static ExtentReports extent;
  private static ExtentTest test;

  private static final String ROOT_FOLDER = System.getProperty("user.dir") + "/"; // Root project directory
  // Path for the report and screenshots
  private static final String REPORT_PATH = "reports/report.html";
  private static final String SCREENSHOTS_FOLDER = "reports/screenshots/";

  public static void setUp() {
    // Set up the report path
    ExtentSparkReporter htmlReporter = new ExtentSparkReporter(REPORT_PATH);

    // Set up the report
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);

    // Configure the report
    htmlReporter.config().setDocumentTitle("Smarts Gate Report");
    htmlReporter.config().setReportName("Smarts Gate Report");
    htmlReporter.config().setTheme(Theme.STANDARD);
    htmlReporter.config().setEncoding("utf-8");

    // Adding system info
    extent.setSystemInfo("OS", System.getProperty("os.name"));
    extent.setSystemInfo("Java Version", System.getProperty("java.version"));
  }

  public static void startTest(String testName, String testDescription) {
    // Add timestamp to test name
    test = extent.createTest(testName + "/" + getTimeStamp(), testDescription);
  }

  public static void logInfo(String message) {
    test.info(message);
  }

  public static void logPass(String message) {
    test.pass(message);
  }

  public static void logFail(String message) {
    test.fail(message);
  }

  // Method to capture screenshots
  public static void captureScreenshot(String screenshotName) {
    try {
      WebDriver driver = DriverBase.getDriver();
      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

      // Create a folder for each test based on the test name and timestamp
      String testFolder = SCREENSHOTS_FOLDER + test.getModel().getName();
      File destFile = new File(testFolder);

      // Create the test-specific folder if it does not exist
      if (!destFile.exists() && !destFile.mkdirs()) {
        logFail("Failed to create directory for screenshots: " + testFolder);
        return;
      }

      // Save screenshot with a timestamp inside the test-specific folder
      String filePath = testFolder + "/" + getTimeStamp() + "-" + screenshotName + ".png";
      FileUtils.copyFile(screenshot, new File(filePath));

      String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

      // Attach screenshot as Base64 directly to the report
      test.addScreenCaptureFromBase64String(screenshotBase64, screenshotName);
    } catch (Exception e) {
      logFail("Failed to capture screenshot: " + e.getMessage());
    }
  }

  // Utility method to get current timestamp
  private static String getTimeStamp() {
    return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
  }

  public static void endTest() {
    extent.flush();
  }
}
