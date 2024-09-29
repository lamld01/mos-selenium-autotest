package com.lazerycode.selenium.tests.booking;

import com.github.javafaker.Faker;
import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.config.RecordVideo;
import com.lazerycode.selenium.config.ReportManager;
import com.lazerycode.selenium.page_objects.booking.manHinhDanhSachBooking.ManHinhDanhSachBooking;
import com.lazerycode.selenium.page_objects.doanhNghiepHangHoa.ManHinhThemMoi;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BookingScreenIT extends DriverBase {

  private final Faker faker = new Faker();
  private ManHinhDanhSachBooking manHinhDanhSachBooking;
  private ManHinhThemMoi manHinhThemMoi;
  @BeforeMethod
  public void setup() throws Exception {
    RecordVideo.startRecord("Test get list booking");
    getDriverLogin(ManHinhDanhSachBooking.PAGE_URL);
    manHinhDanhSachBooking = new ManHinhDanhSachBooking();
    manHinhThemMoi = new ManHinhThemMoi();
  }

  @AfterMethod
  public void tearDown() throws Exception {
    RecordVideo.stopRecord();
  }

  @Test
  public void getListBooking() throws Exception {
    ReportManager.startTest("Test get list booking", "Test get list booking");
    manHinhDanhSachBooking.getBookings();
    ReportManager.endTest();
  }



}
