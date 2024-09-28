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

public class DriverNameFieldIT extends DriverBase {
  private final Faker faker = new Faker();
  private CreateVehiclePage createVehiclePage;
  private ListVehiclePage listVehiclePage;

  @BeforeMethod
  public void setUp() throws Exception {
    getDriverLogin(CreateVehiclePage.PAGE_URL);
    createVehiclePage = new CreateVehiclePage();
    listVehiclePage = new ListVehiclePage();
  }

  @Test(groups = {"vehicle-create"}, priority = 1)
  public void testAddVehicleWithEmptyDriverName() throws Exception {
    listVehiclePage.clickAddBtn();
    RecordVideo.startRecord("Test empty driver name");
    ReportManager.startTest("Test empty driver name", "Verifying that the error message is displayed when the driver name is empty.");

    // Set driver name empty
    fillCommonVehicleDetails();
    createVehiclePage.enterDriverName("");
    ReportManager.captureScreenshot( "beforeInput");
    createVehiclePage.clickAddBtn();
    ReportManager.captureScreenshot( "afterClick");
    Assert.assertTrue(createVehiclePage.containsErrorMessage("Vui lòng nhập dữ liệu"), "Error message should be displayed.");

    RecordVideo.stopRecord();
    ReportManager.endTest();
  }

  @Test(groups = {"vehicle-create"}, priority = 2)
  public void testAddVehicleWithTooLongDriverName() throws Exception {
    listVehiclePage.clickAddBtn();
    RecordVideo.startRecord("Test driver name too long");
    ReportManager.startTest("Test driver name too long", "Verifying that the error message is displayed when the driver name exceeds maximum length.");

    // Enter a driver name that's too long
    fillCommonVehicleDetails();
    String longDriverName = faker.lorem().characters(51); // Generate a name longer than 50 characters
    ReportManager.captureScreenshot( "beforeInput");
    createVehiclePage.clickAddBtn();
    ReportManager.captureScreenshot( "afterClick");

    Assert.assertTrue(createVehiclePage.getDriverName().length() <= 50, "Error message should be displayed for long driver name.");

    RecordVideo.stopRecord();
    ReportManager.endTest();
  }

  @Test(groups = {"vehicle-create"}, priority = 3)
  public void testAddVehicleWithDriverNameContainingSpecialCharacters() throws Exception {
    listVehiclePage.clickAddBtn();
    RecordVideo.startRecord("Test driver name with special characters");
    ReportManager.startTest("Test driver name with special characters", "Verifying that the error message is displayed when the driver name contains special characters.");

    // Enter a driver name with special characters
    fillCommonVehicleDetails();
    createVehiclePage.enterDriverName(faker.name().fullName() + "#@!$%^&@");
    ReportManager.captureScreenshot( "beforeInput");
    createVehiclePage.clickAddBtn();
    ReportManager.captureScreenshot( "afterClick");
    Assert.assertTrue(createVehiclePage.containsErrorBackendMessage("Tên không được chứa ký tự đặc biệt"), "Error message should be displayed for special characters.");

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
