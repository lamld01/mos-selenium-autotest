package com.lazerycode.selenium.page_objects.vehice;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.config.ReportManager;
import com.lazerycode.selenium.page_objects.BasePage;
import com.lazerycode.selenium.page_objects.vehice.base.VehicleDriver;
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

public class ListVehiclePage extends BasePage {
  public static final String PAGE_URL = Constants.SMARTGATE_WIINVENT_TV + "/phuongtienvalaixe";
  private final Query title = new Query().defaultLocator(By.xpath("//h3[text()='Phương tiện và lái xe']"));
  private final Query toastText = new Query().defaultLocator(By.className("Toastify"));
  private final Query driverRow = new Query().defaultLocator(By.xpath("/html/body/div[1]/div[1]/div[2]/main/div/div/div[2]/div/div[1]/div/div/table/tbody/tr"));
  private final Query addBtn = new Query().defaultLocator(By.xpath("/html/body/div[1]/div[1]/div[2]/main/div/div/div[1]/button"));
  private final WebDriverWait wait;

  public ListVehiclePage() throws Exception {
    initQueryObjects(this, DriverBase.getDriver());
    this.wait = new WebDriverWait(DriverBase.getDriver(), Duration.ofSeconds(15), Duration.ofMillis(5000));
    waitForTitle();
  }

  public void clickAddBtn() {
    wait.until(ExpectedConditions.elementToBeClickable(addBtn.by()));
    addBtn.findWebElement().click();
    waitAction(1000);
  }

  public List<VehicleDriver> getDriver() {
    wait.until(ExpectedConditions.presenceOfElementLocated(driverRow.by()));
    List<WebElement> rows = driverRow.findWebElements();
    List<VehicleDriver> vehicleDrivers = new ArrayList<>();
    ReportManager.logInfo("Number of drivers: " + rows.size());
    for (int i = 0; i < rows.size(); i++) {
      WebElement row = rows.get(i);
      String prefix = "./td";

      // Use the getColumnValue method with the appropriate parameters
      String driverName = getColumnValue(row, 1);
      String phoneNumber = getColumnValue(row, 2);
      String driverCode = getColumnValue(row, 3);
      String vehicleType = getColumnValue(row, 4);
      String licensePlate = getColumnValue(row, 5);
      String status = getColumnValue(row, 6);
      String creationDate = getColumnValue(row, 7);
      String updateDate = getColumnValue(row, 8);
      String description = getColumnValue(row, 9);

      // Create VehicleDriver object
      VehicleDriver driver = new VehicleDriver(driverName, phoneNumber, driverCode,
          vehicleType, licensePlate,
          status, creationDate,
          updateDate, description);
      vehicleDrivers.add(driver);
    }
    return vehicleDrivers;
  }

  public boolean containToastMessage(String message) {
    return toastText.findWebElement().getText().contains(message);
  }

  public void waitForUrl() {
    wait.until(ExpectedConditions.urlContains(PAGE_URL));
  }
  public void waitForTitle() {
    wait.until(ExpectedConditions.presenceOfElementLocated(title.by()));
  }
}
