package com.lazerycode.selenium.tests.vehicle.create;

import com.github.javafaker.Faker;
import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.config.RecordVideo;
import com.lazerycode.selenium.config.ReportManager;
import com.lazerycode.selenium.page_objects.vehice.CreateVehiclePage;
import com.lazerycode.selenium.page_objects.vehice.ListVehiclePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LicensePlateFieldIT extends DriverBase {
  private final Faker faker = new Faker();
  private CreateVehiclePage createVehiclePage;
  private ListVehiclePage listVehiclePage;
  WebDriver driver;

  @BeforeMethod
  public void setUp() throws Exception {
    driver = getDriverLogin(CreateVehiclePage.PAGE_URL);
    createVehiclePage = new CreateVehiclePage();
    listVehiclePage = new ListVehiclePage();
  }

  @Test(groups = {"vehicle-create"}, priority = 1)
  public void testAddVehicleWithEmptyLicensePlate() throws Exception {
    listVehiclePage.clickAddBtn();
    RecordVideo.startRecord("Test empty license plate");
    ReportManager.startTest("Test empty license plate", "Verifying that the error message is displayed when the license plate is empty.");

    fillCommonVehicleDetails();
    createVehiclePage.enterLicensePlate(""); // Set license plate to empty
    ReportManager.captureScreenshot( "beforeInput");
    createVehiclePage.clickAddBtn();
    ReportManager.captureScreenshot( "afterClick");

    Assert.assertTrue(createVehiclePage.containsErrorMessage("Vui lòng nhập dữ liệu"), "Error message should be displayed.");

    RecordVideo.stopRecord();
    ReportManager.endTest();
  }

  @Test(groups = {"vehicle-create"}, priority = 2)
  public void testAddVehicleWithInvalidLicensePlate() throws Exception {
    listVehiclePage.clickAddBtn();
    RecordVideo.startRecord("Test invalid license plate");
    ReportManager.startTest("Test invalid license plate", "Verifying that the error message is displayed when the license plate is invalid.");

    fillCommonVehicleDetails();
    createVehiclePage.enterLicensePlate("!@#$%"); // Set license plate to invalid value
    ReportManager.captureScreenshot( "beforeInput");
    createVehiclePage.clickAddBtn();
    ReportManager.captureScreenshot( "afterClick");

    Assert.assertTrue(createVehiclePage.containsErrorMessage("Vui lòng nhập dữ liệu"), "Error message should be displayed.");

    RecordVideo.stopRecord();
    ReportManager.endTest();
  }

  @Test(groups = {"vehicle-create"}, priority = 3)
  public void testAddVehicleWithTooLongLicensePlate() throws Exception {
    listVehiclePage.clickAddBtn();
    RecordVideo.startRecord("Test license plate too long");
    ReportManager.startTest("Test license plate too long", "Verifying that the error message is displayed when the license plate exceeds maximum length.");

    fillCommonVehicleDetails();
    String longLicensePlate = faker.lorem().characters(26); // Generate a license plate longer than 10 characters
    createVehiclePage.enterLicensePlate(longLicensePlate); // Set license plate to long value
//    createVehiclePage.clickAddBtn();

    Assert.assertTrue(createVehiclePage.getLicensePlate().length() <= 25, "Error message should be displayed for long license plate.");

    RecordVideo.stopRecord();
    ReportManager.endTest();
  }

  private void fillCommonVehicleDetails() {
    createVehiclePage.enterDriverName(faker.name().fullName());
    createVehiclePage.enterDriverCode(faker.code().asin());
    createVehiclePage.enterPhoneNumber("0" + faker.phoneNumber().subscriberNumber(8));
    createVehiclePage.selectVehicleType(1);
    createVehiclePage.enterLicensePlate(faker.code().ean8());
    createVehiclePage.enterNote(faker.lorem().sentence());
    createVehiclePage.setStatusCheckbox(true);
  }
}
