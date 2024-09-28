package com.lazerycode.selenium.page_objects.vehice;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.config.ReportManager;
import com.lazerycode.selenium.page_objects.BasePage;
import com.lazerycode.selenium.util.Query;
import com.lazerycode.selenium.utils.Constants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.lazerycode.selenium.util.AssignDriver.initQueryObjects;

@Log4j2
public class CreateVehiclePage extends BasePage {
  public static final String PAGE_URL = Constants.SMARTGATE_WIINVENT_TV + "/phuongtienvalaixe";

  protected final Query errorMessage = new Query().defaultLocator(By.xpath("//p[contains(@class, 'text-xs') and contains(@class, 'text-red-600') and contains(@class, 'mt-0')]"));
  protected final Query errorBackendMessage = new Query().defaultLocator(By.xpath("//div[contains(@class, 'Toastify__toast') and contains(@class, 'Toastify__toast-theme--light')]"));

  private final Query addBtn = new Query().defaultLocator(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div/div/div/form/div[2]/button"));
  private final Query driverNameInput = new Query().defaultLocator(By.xpath("//input[@id='name']"));
  private final Query driverCodeInput = new Query().defaultLocator(By.xpath("//input[@id='code']"));
  private final Query phoneNumberInput = new Query().defaultLocator(By.xpath("//input[@id='phoneNumber']"));
  private final Query vehicleTypeSelect = new Query().defaultLocator(By.xpath("//select[@id='vehicleTypeId']"));
  private final Query licensePlateInput = new Query().defaultLocator(By.xpath("//input[@id='licensePlate']"));
  private final Query noteInput = new Query().defaultLocator(By.xpath("//input[@id='note']"));
  private final Query statusCheckbox = new Query().defaultLocator(By.xpath("//input[@id='switch']"));

  private final WebDriverWait wait;

  public CreateVehiclePage() throws Exception {
    this.wait = new WebDriverWait(DriverBase.getDriver(), Duration.ofSeconds(10), Duration.ofMillis(2000));
    initQueryObjects(this, DriverBase.getDriver());
  }

  // Click the Add button
  public void clickAddBtn() {
    wait.until(ExpectedConditions.presenceOfElementLocated(addBtn.by()));
    addBtn.findWebElement().click();
    waitAction(1000);
  }

  // Fill the driver's name
  public void enterDriverName(String driverName) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(driverNameInput.by()));
    WebElement nameField = driverNameInput.findWebElement();
    inputValueToElement(nameField, driverName);
    waitAction();
  }

  public String getDriverName() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(driverNameInput.by()));
    WebElement nameField = driverNameInput.findWebElement();
    return getValueFromElement(nameField);
  }

  // Fill the driver's code
  public void enterDriverCode(String driverCode) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(driverCodeInput.by()));
    WebElement codeField = driverCodeInput.findWebElement();
    inputValueToElement(codeField, driverCode);
    waitAction();
  }

  public String getDriverCode() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(driverCodeInput.by()));
    WebElement codeField = driverCodeInput.findWebElement();
    return getValueFromElement(codeField);
  }

  // Fill the phone number
  public void enterPhoneNumber(String phoneNumber) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberInput.by()));
    WebElement phoneField = phoneNumberInput.findWebElement();
    inputValueToElement(phoneField, phoneNumber);
    waitAction();
  }

  public String getPhoneNumber() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberInput.by()));
    WebElement phoneField = phoneNumberInput.findWebElement();
    return getValueFromElement(phoneField);
  }

  // Select vehicle type
  public void selectVehicleType(String vehicleType) {
    wait.until(ExpectedConditions.elementToBeClickable(vehicleTypeSelect.by()));
    Select dropdown = new Select(vehicleTypeSelect.findWebElement());
    dropdown.selectByVisibleText(vehicleType);
    ReportManager.logInfo("Selecting vehicle type: " + vehicleType);
    waitAction();
  }

  // Select vehicle type
  public void selectVehicleType(int index) {
    wait.until(ExpectedConditions.elementToBeClickable(vehicleTypeSelect.by()));
    Select dropdown = new Select(vehicleTypeSelect.findWebElement());
    dropdown.selectByIndex(index);
    ReportManager.logInfo("Selecting vehicle type: " + getSelectedVehicleType());
    waitAction();
  }

  public String getSelectedVehicleType() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(vehicleTypeSelect.by()));
    Select dropdown = new Select(vehicleTypeSelect.findWebElement());
    return dropdown.getFirstSelectedOption().getText();
  }

  // Fill the license plate
  public void enterLicensePlate(String licensePlate) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(licensePlateInput.by()));
    WebElement licenseField = licensePlateInput.findWebElement();
    inputValueToElement(licenseField, licensePlate);
    waitAction();
  }

  public String getLicensePlate() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(licensePlateInput.by()));
    WebElement licenseField = licensePlateInput.findWebElement();
    return getValueFromElement(licenseField);
  }

  // Fill the notes
  public void enterNote(String note) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(noteInput.by()));
    WebElement noteField = noteInput.findWebElement();
    inputValueToElement(noteField, note);
    waitAction();
  }

  public String getNote() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(noteInput.by()));
    WebElement noteField = noteInput.findWebElement();
    return getValueFromElement(noteField);
  }

  // Check or uncheck the status checkbox
  public void setStatusCheckbox(boolean isChecked) {
    wait.until(ExpectedConditions.elementToBeClickable(statusCheckbox.by()));
    WebElement checkbox = statusCheckbox.findWebElement();
    if (checkbox.isSelected() != isChecked) {
      checkbox.click(); // Click to check or uncheck the checkbox
    }
    ReportManager.logInfo("Checking or unchecking status checkbox: " + isChecked);
    waitAction();
  }

  public boolean isStatusChecked() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(statusCheckbox.by()));
    WebElement checkbox = statusCheckbox.findWebElement();
    return checkbox.isSelected();
  }

  public boolean containsErrorMessage(String message) {
    boolean isContain = false;
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage.by()));
      String formText = errorMessage.findWebElement().getText().toLowerCase();
      isContain = formText.contains(message.toLowerCase());
    } catch (Exception e) {
      ReportManager.logFail("Element not found: " + message);
    }

    if (isContain) {
      ReportManager.logPass("Contain message: " + message);
    } else {
      ReportManager.logFail("Not contain message: " + message);
    }
    return isContain;
  }

  // Check if the form contains a specific message
  public boolean containsErrorBackendMessage(String message) {
    boolean isContain = false;
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(errorBackendMessage.by()));
      String formText = errorBackendMessage.findWebElement().getText().toLowerCase();
      isContain = formText.contains(message.toLowerCase());
    } catch (Exception e) {
      log.debug("containsErrorBackendMessage: {}", e.getMessage());
      ReportManager.logFail("Element not found: " + message);
    }

    if (isContain) {
      ReportManager.logPass("Contain message: " + message);
    } else {
      ReportManager.logFail("Not contain message: " + message);
    }
    return isContain;
  }

  public boolean notContainsError() {
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage.by()));
      String formText = errorMessage.findWebElement().getText().toLowerCase();
      ReportManager.logFail("Contain error: " + formText);
      return false;
    } catch (Exception e) {
      ReportManager.logPass("not contain error");
      return true;
    }
  }
}
