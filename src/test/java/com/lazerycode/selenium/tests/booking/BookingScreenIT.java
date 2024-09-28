package com.lazerycode.selenium.tests.booking;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.config.RecordVideo;
import com.lazerycode.selenium.config.ReportManager;
import com.lazerycode.selenium.page_objects.booking.ListBookingPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BookingScreenIT extends DriverBase {

  @Test
  public void getListBooking() throws Exception {
    RecordVideo.startRecord("Test get list booking");
    ReportManager.startTest("Test get list booking", "Test get list booking");
    // Create a new WebDriver instance
    // Notice that the remainder of the code relies on the interface, not the implementation.
    WebDriver driver = getDriverLogin(ListBookingPage.PAGE_URL);
    ListBookingPage listBookingPage = new ListBookingPage();
    listBookingPage.getBookings();
    RecordVideo.stopRecord();
    ReportManager.endTest();
  }

}
