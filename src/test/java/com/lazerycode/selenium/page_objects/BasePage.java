package com.lazerycode.selenium.page_objects;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.config.ReportManager;
import com.lazerycode.selenium.util.Query;
import com.lazerycode.selenium.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

  protected String getColumnValue(WebElement row,String prefix, String suffix, int columnIndex, int id, int rowNumber) {
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

  public String getValueFromElement(WebElement webElement) {
    return webElement.getText();
  }


}
