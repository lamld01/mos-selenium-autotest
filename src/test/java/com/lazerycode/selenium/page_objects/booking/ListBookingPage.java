package com.lazerycode.selenium.page_objects.booking;

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

public class ListBookingPage extends BasePage {
  public static final String PAGE_URL = Constants.SMARTGATE_WIINVENT_TV + "/danhsachtokhai";
  private final Query bookingRow = new Query().defaultLocator(By.cssSelector("tbody.divide-y > tr"));
  private final WebDriverWait wait;

  public ListBookingPage() throws Exception {
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
      String prefix = "./td";
      // Sử dụng hàm getColumnValue với chỉ số cột, id booking và số hàng
      int id = Integer.parseInt(getColumnValue(row, prefix, "", 1, -1, i + 1)); // -1 cho id tạm thời
      String bookingNumber = getColumnValue(row, prefix, "", 2, id, i + 1);
      String timestamp = getColumnValue(row, prefix, "", 3, id, i + 1);
      String vehicleId = getColumnValue(row, prefix, "", 4, id, i + 1);
      String moocId = getColumnValue(row, prefix, "", 5, id, i + 1);
      String transferId = getColumnValue(row, prefix, "", 6, id, i + 1);
      String companyName = getColumnValue(row, prefix, "", 7, id, i + 1);
      String inOut = getColumnValue(row, prefix, "", 8, id, i + 1);

      // Lấy giá trị status và paymentStatus từ <span> trong các cột tương ứng
      String status = getColumnValue(row, prefix, "/span", 9, id, i + 1);
      String paymentStatus = getColumnValue(row, prefix, "/span", 10, id, i + 1);

      // Tạo đối tượng Booking và thêm vào danh sách
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

  public void waitForUrl() {
    wait.until(ExpectedConditions.urlContains(PAGE_URL));
  }
}
