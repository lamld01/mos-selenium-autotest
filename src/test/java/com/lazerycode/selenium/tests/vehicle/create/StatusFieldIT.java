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

public class StatusFieldIT extends DriverBase {
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

//  @Test(groups = {"vehicle-create"}, priority = 1)
//  public void testAddVehicleWithUncheckedStatus() throws Exception {
//    ListVehiclePage listVehiclePage = new ListVehiclePage();
//    listVehiclePage.clickAddBtn();
//    RecordVideo.startRecord("Test unchecked status");
//    ReportManager.startTest("Test unchecked status", "Verifying that the error message is displayed when the status is unchecked.");
//
//    createVehiclePage.enterDriverName("Valid Driver");
//    createVehiclePage.enterDriverCode("Valid Code");
//    createVehiclePage.enterPhoneNumber("0123456789");
//    createVehiclePage.selectVehicleType("Xe tải 2 tấn");
//    createVehiclePage.enterLicensePlate("123456");
//    createVehiclePage.enterNote("Valid Note");
//    createVehiclePage.setStatusCheckbox(false);
//    createVehiclePage.clickAddBtn();
//
//    Assert.assertTrue(createVehiclePage.containsErrorMessage("Status must be checked."), "Error message should be displayed.");
//
//    RecordVideo.stopRecord();
//    ReportManager.endTest();
//  }

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
