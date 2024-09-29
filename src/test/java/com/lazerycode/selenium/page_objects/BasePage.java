package com.lazerycode.selenium.page_objects;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.config.ReportManager;
import com.lazerycode.selenium.util.Query;
import com.lazerycode.selenium.utils.Constants;
import com.lazerycode.selenium.utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.lazerycode.selenium.util.AssignDriver.initQueryObjects;

public class BasePage {

  public void waitAction() {
    try {
      // Thời gian chờ giữa các lần nhập (1 giây)
      Thread.sleep(Constants.DELAY_ACTION); // Thay đổi giá trị này nếu cần
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void waitAction(int timeout) {
    try {
      Thread.sleep(timeout); // Thay đổi giá trị này nếu cần
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void waitForElement(WebDriverWait wait) {
    wait.pollingEvery(Duration.ofMillis(2000));
  }

  public String getValue(WebElement webElement) {
    return webElement.getAttribute("value");
  }

  protected String getColumnValue(WebElement row, String prefix, String suffix, int columnIndex, int id, int rowNumber) {
    try {
      // Tìm phần tử <td> tại vị trí chỉ định và lấy giá trị văn bản
      return row.findElement(By.xpath(prefix +'[' + columnIndex + ']' + suffix)).getText().trim();
    } catch (NoSuchElementException e) {
      return "";
    }
  }

  protected void inputValueToElement(WebElement webElement, String value) {
    webElement.sendKeys(Keys.CONTROL + "a");
    webElement.sendKeys(Keys.DELETE);
    webElement.sendKeys(value);
    ReportManager.logInfo("-------Input value: " + value);
  }

  protected void inputValueToElement(Query query, String value) {
    WebElement webElement = query.findWebElement();
    webElement.sendKeys(Keys.CONTROL + "a");
    webElement.sendKeys(Keys.DELETE);
    webElement.sendKeys(value);
    ReportManager.logInfo("Nhap giá trị: " + value + " trong phần tử có locator: " + query.by().toString());
//    ReportManager.captureScreenshot(Helper.getTimeStamp());
  }

  public String getValueFromElement(WebElement webElement) {
    return webElement.getText();
  }

  protected String getValueFromElement(Query query) {
    WebElement webElement = query.findWebElement();
    return webElement.getText();
  }

  public void clickElement(Query query) {
    WebElement webElement = query.findWebElement();
    webElement.click();
    ReportManager.logInfo("Click phần tử có locator: " + query.by().toString());
//    ReportManager.captureScreenshot(Helper.getTimeStamp());
  }


  public void selectElementFromDropdown(Query query, String value) {
    WebElement webElement = query.findWebElement();
    Select dropdown = new Select(webElement);
    dropdown.selectByVisibleText(value);
    ReportManager.logInfo("Chọn giá trị: " + value + " trong dropdown có locator: " + query.by().toString());
//    ReportManager.captureScreenshot(Helper.getTimeStamp());

  }

  public void selectElementFromDropdown(Query query, Integer index) {
    WebElement webElement = query.findWebElement();
    Select dropdown = new Select(webElement);
    dropdown.selectByIndex(index);
    ReportManager.logInfo("Chọn giá trị tại vị trí: " + index + " trong dropdown có locator: " + query.by().toString());
//    ReportManager.captureScreenshot(Helper.getTimeStamp());

  }

  public void clickCheckBox(Query query, boolean isChecked) {
    WebElement checkbox = query.findWebElement();
    if (checkbox.isSelected() != isChecked) {
      checkbox.click(); // Click to check or uncheck the checkbox
    }
    ReportManager.logInfo("Chọn checkbox: " + isChecked + " trong phần tử có locator: " + query.by().toString());
//    ReportManager.captureScreenshot(Helper.getTimeStamp());
  }
}
