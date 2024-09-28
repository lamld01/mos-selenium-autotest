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

public class VehicleTypeFieldIT extends DriverBase {
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
  public void testAddVehicleWithEmptyVehicleType() throws Exception {
    listVehiclePage.clickAddBtn();
    RecordVideo.startRecord("Test empty vehicle type");
    ReportManager.startTest("Test empty vehicle type", "Verifying that the error message is displayed when the vehicle type is empty.");

    fillCommonVehicleDetails(); // Fill common details
    createVehiclePage.selectVehicleType("Chọn"); // Set vehicle type to empty
    ReportManager.captureScreenshot( "beforeInput");
    createVehiclePage.clickAddBtn();
    ReportManager.captureScreenshot( "afterClick");

    Assert.assertTrue(createVehiclePage.containsErrorMessage("Vui lòng chọn dữ liệu"), "Error message should be displayed.");

    RecordVideo.stopRecord();
    ReportManager.endTest();
  }

  // Additional test methods for other validation cases can be added here

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
