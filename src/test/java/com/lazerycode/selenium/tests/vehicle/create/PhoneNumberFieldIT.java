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

public class PhoneNumberFieldIT extends DriverBase {
  private final Faker faker = new Faker();
  private CreateVehiclePage createVehiclePage;
  private ListVehiclePage listVehiclePage;
  private WebDriver driver;

  @BeforeMethod
  public void setUp() throws Exception {
    driver = getDriverLogin(CreateVehiclePage.PAGE_URL);
    createVehiclePage = new CreateVehiclePage();
    listVehiclePage = new ListVehiclePage();
  }

  @Test(groups = {"vehicle-create"}, priority = 1)
  public void testAddVehicleWithEmptyPhoneNumber() throws Exception {
    listVehiclePage.clickAddBtn();
    RecordVideo.startRecord("Test empty phone number");
    ReportManager.startTest("Test empty phone number", "Verifying that the error message is displayed when the phone number is empty.");

    fillCommonVehicleDetails();
    createVehiclePage.enterPhoneNumber(""); // Set phone number to empty
    ReportManager.captureScreenshot( "beforeInput");
    createVehiclePage.clickAddBtn();
    ReportManager.captureScreenshot( "afterClick");

    Assert.assertTrue(createVehiclePage.containsErrorMessage("Vui lòng nhập dữ liệu"), "Error message should be displayed.");

    RecordVideo.stopRecord();
    ReportManager.endTest();
  }

  @Test(groups = {"vehicle-create"}, priority = 2)
  public void testAddVehicleWithInvalidPhoneNumber() throws Exception {
    listVehiclePage.clickAddBtn();
    RecordVideo.startRecord("Test invalid phone number");
    ReportManager.startTest("Test invalid phone number", "Verifying that the error message is displayed when the phone number is invalid.");

    fillCommonVehicleDetails();
    createVehiclePage.enterPhoneNumber("89" + faker.phoneNumber().subscriberNumber(7)); // Set phone number to invalid
    ReportManager.captureScreenshot( "beforeInput");
    createVehiclePage.clickAddBtn();
    ReportManager.captureScreenshot( "afterClick");

    Assert.assertTrue(createVehiclePage.containsErrorMessage("Dữ liệu không hợp lệ"), "Error message should be displayed.");

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
