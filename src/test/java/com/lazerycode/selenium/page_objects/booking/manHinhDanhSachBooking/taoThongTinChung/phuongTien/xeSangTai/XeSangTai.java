package com.lazerycode.selenium.page_objects.booking.manHinhDanhSachBooking.taoThongTinChung.phuongTien.xeSangTai;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.page_objects.BasePage;
import com.lazerycode.selenium.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class XeSangTai extends BasePage {
  public static final String PAGE_URL = Constants.SMARTGATE_WIINVENT_TV + "/danhsachtokhai/tao";
  private final WebDriverWait wait;

  public XeSangTai() throws Exception {
    this.wait = new WebDriverWait(DriverBase.getDriver(), Duration.ofSeconds(15), Duration.ofMillis(5000));
  }

  private WebElement getElement(String xpath) {
    return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
  }

  public void nhapBienKiemSoat(String bienKiemSoat, int index) {
    String xpath = String.format("//input[@type='text' and @id='vehicleLoadTransfers[%d].licensePlate']", index);
    WebElement inputElement = getElement(xpath);
    inputValueToElement(inputElement, bienKiemSoat); // Maintained original input method
  }

  public void chonLoaiPhuongTien(String loaiPhuongTien, int index) {
    String xpath = String.format("//input[@type='text' and @id='vehicleLoadTransfers[%d].vehicleType']", index);
    WebElement inputElement = getElement(xpath);
    inputValueToElement(inputElement, loaiPhuongTien); // Maintained original input method
  }

  public void chonLoaiPhuongTien(int loaiPhuongTienIndex, int index) {
    String xpath = String.format("//select[@id='vehicleLoadTransfers[%d].vehicleType']", index);
    WebElement inputElement = getElement(xpath);
    selectElementFromDropdown(inputElement, loaiPhuongTienIndex); // Implement this method accordingly
  }

  public void nhapSoMooc(String mooc, int index) {
    String xpath = String.format("//input[@type='text' and @id='vehicleLoadTransfers[%d].mooc']", index);
    WebElement inputElement = getElement(xpath);
    inputValueToElement(inputElement, mooc); // Maintained original input method
  }

  public void nhapSoContainer(String soContainer, int index) {
    String xpath = String.format("//input[@type='text' and @id='vehicleLoadTransfers[%d].containerNumber']", index);
    WebElement inputElement = getElement(xpath);
    inputValueToElement(inputElement, soContainer); // Maintained original input method
  }

  public void nhapDienThoaiLaiXe(String sdt, int index) {
    String xpath = String.format("//input[@type='text' and @id='vehicleLoadTransfers[%d].driverPhoneNumber']", index);
    WebElement inputElement = getElement(xpath);
    inputValueToElement(inputElement, sdt); // Maintained original input method
  }

  public void nhapTenLaiXe(String ten, int index) {
    String xpath = String.format("//input[@type='text' and @id='vehicleLoadTransfers[%d].driverName']", index);
    WebElement inputElement = getElement(xpath);
    inputValueToElement(inputElement, ten); // Maintained original input method
  }

  public void nhapSoCmnn(String cmnd, int index) {
    String xpath = String.format("//input[@type='text' and @id='vehicleLoadTransfers[%d].driverMsisdn']", index);
    WebElement inputElement = getElement(xpath);
    inputValueToElement(inputElement, cmnd); // Maintained original input method
  }

  public void nhapTuTrong(String tuTrong, int index) {
    String xpath = String.format("//input[@type='number' and @id='vehicleLoadTransfers[%d].loadDueToOwnWeight']", index);
    WebElement inputElement = getElement(xpath);
    inputValueToElement(inputElement, tuTrong); // Maintained original input method
  }

  public void chonTaiTrongXe(String taiTrongXe, int index) {
    String xpath = String.format("//select[@id='vehicleLoadTransfers[%d].vehicleLoadCapacityId']", index);
    WebElement inputElement = getElement(xpath);
    selectElementFromDropdown(inputElement, taiTrongXe); // Implement this method accordingly
  }

  public void chonTaiTrongXe(int taiTrongXeIndex, int index) {
    String xpath = String.format("//select[@id='vehicleLoadTransfers[%d].vehicleLoadCapacityId']", index);
    WebElement inputElement = getElement(xpath);
    selectElementFromDropdown(inputElement, taiTrongXeIndex); // Implement this method accordingly
  }

  public void nhapGhiChu(String ghiChu, int index) {
    String xpath = String.format("//input[@type='text' and @id='vehicleLoadTransfers[%d].note']", index);
    WebElement inputElement = getElement(xpath);
    inputValueToElement(inputElement, ghiChu); // Maintained original input method
  }


}
