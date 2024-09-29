package com.lazerycode.selenium.page_objects.booking.manHinhDanhSachBooking;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.helpers.CustomExpectedConditions;
import com.lazerycode.selenium.page_objects.BasePage;
import com.lazerycode.selenium.page_objects.booking.base.Booking;
import com.lazerycode.selenium.util.Query;
import com.lazerycode.selenium.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.lazerycode.selenium.util.AssignDriver.initQueryObjects;

public class ManHinhDanhSachBooking extends BasePage {
  public static final String PAGE_URL = Constants.SMARTGATE_WIINVENT_TV + "/danhsachtokhai";
  private final Query bookingRow = new Query().defaultLocator(By.cssSelector("tbody.divide-y > tr"));
  private final Query nutThemMoi = new Query().defaultLocator(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/main/div/div/div[1]/a/button"));
  private final WebDriverWait wait;

  public ManHinhDanhSachBooking() throws Exception {
    initQueryObjects(this, DriverBase.getDriver());
    this.wait = new WebDriverWait(DriverBase.getDriver(), Duration.ofSeconds(15), Duration.ofMillis(5000));
  }

  // Method to get all booking rows as Booking objects
  public List<Booking> getBookings() {
    wait.until(ExpectedConditions.presenceOfElementLocated(bookingRow.by()));
    List<WebElement> rows = bookingRow.findWebElements();
    List<Booking> bookings = new ArrayList<>();

    for (int i = 0; i < rows.size(); i++) {
      WebElement row = rows.get(i);
      int id = Integer.parseInt(getColumnValue(row, 1));
      String bookingNumber = getColumnValue(row, 2);
      String timestamp = getColumnValue(row, 3);
      String vehicleId = getColumnValue(row, 4);
      String moocId = getColumnValue(row, 5);
      String transferId = getColumnValue(row, 6);
      String companyName = getColumnValue(row, 7);
      String inOut = getColumnValue(row, 8);
      String status = getColumnValue(row, 9);
      String paymentStatus = getColumnValue(row, 10);

      Booking booking = new Booking(id, bookingNumber, timestamp, vehicleId, moocId,
          transferId, companyName, inOut, status, paymentStatus);
      bookings.add(booking);
    }
    return bookings;
  }


  public boolean pageUrlContain(String subsUrl) {
    wait.until(CustomExpectedConditions.pageUrlContain(subsUrl));
    String currentUrl = null;
    try {
      currentUrl = DriverBase.getDriver().getCurrentUrl();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return currentUrl.contains(subsUrl);
  }

  public void nhanNutThemMoi() {
    wait.until(ExpectedConditions.elementToBeClickable(nutThemMoi.by()));
    clickElement(nutThemMoi);
  }
  public void waitForUrl() {
    wait.until(ExpectedConditions.urlContains(PAGE_URL));
  }
}
