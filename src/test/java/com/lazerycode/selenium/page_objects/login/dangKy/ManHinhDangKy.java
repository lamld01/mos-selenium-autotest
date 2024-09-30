package com.lazerycode.selenium.page_objects.login.dangKy;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.page_objects.BasePage;
import com.lazerycode.selenium.util.Query;
import com.lazerycode.selenium.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.lazerycode.selenium.util.AssignDriver.initQueryObjects;

public class ManHinhDangKy extends BasePage {
  public static final String PAGE_URL = Constants.SMARTGATE_WIINVENT_TV + "/auth/register";
  private final Query oEmail = new Query().defaultLocator(By.xpath("//div[@class='relative']/input[@id='email']"));
  private final Query oMatKhau = new Query().defaultLocator(By.xpath("//div[@class='flex items-center']/input[@id='password']"));
  private final Query oMaSoThue = new Query().defaultLocator(By.xpath("//div[@class='relative']/input[@id='taxcode']"));
  private final Query oTenDoanhNghiep = new Query().defaultLocator(By.xpath("//div[@class='relative']/input[@id='businessName']"));
  private final Query oHoTen = new Query().defaultLocator(By.xpath("//div[@class='relative']/input[@id='businessName']"));
  private final Query oDiaChi = new Query().defaultLocator(By.xpath("//div[@class='relative']/input[@id='address']"));
  private final Query oSoDienThoaiDoanhNghiep = new Query().defaultLocator(By.xpath("//div[@class='relative']/input[@id='businessPhoneNumber']"));
  private final Query oSoDienThoaiCaNhan = new Query().defaultLocator(By.xpath("//div[@class='relative']/input[@id='phoneNumber']"));
  private final Query nutDangKy = new Query().defaultLocator(By.xpath("//div/button[@type='submit' and text()='Đăng ký']"));
  private final Query nutQuayLai = new Query().defaultLocator(By.xpath("//a/button[text()='Quay lại']"));
  private final WebDriverWait wait;

  public ManHinhDangKy() throws Exception {
    initQueryObjects(this, DriverBase.getDriver());
    this.wait = new WebDriverWait(DriverBase.getDriver(), Duration.ofSeconds(15), Duration.ofMillis(5000));
  }

  public void nhapEmail(String email) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oEmail.by()));
    inputValueToElement(oEmail, email);
  }

  public String layEmail(){
    wait.until(ExpectedConditions.presenceOfElementLocated(oEmail.by()));
    return getValueFromElement(oEmail);
  }

  public void nhapMatKhau(String matKhau) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oMatKhau.by()));
    inputValueToElement(oMatKhau, matKhau);
  }

  public String layMatKhau() {
    wait.until(ExpectedConditions.presenceOfElementLocated(oMatKhau.by()));
    return getValueFromElement(oMatKhau);
  }

  public void nhapMaSoThue(String maSoThue) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oMaSoThue.by()));
    inputValueToElement(oMaSoThue, maSoThue);
  }

  public String layMaSoThue() {
    wait.until(ExpectedConditions.presenceOfElementLocated(oMaSoThue.by()));
    return getValueFromElement(oMaSoThue);
  }

  public void nhapTenDoanhNghiep(String tenDoanhNghiep) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oTenDoanhNghiep.by()));
    inputValueToElement(oTenDoanhNghiep, tenDoanhNghiep);
  }

  public String layTenDoanhNghiep() {
    wait.until(ExpectedConditions.presenceOfElementLocated(oTenDoanhNghiep.by()));
    return getValueFromElement(oTenDoanhNghiep);
  }

  public void nhapHoTen(String hoTen) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oHoTen.by()));
    inputValueToElement(oHoTen, hoTen);
  }

  public String layHoTen() {
    wait.until(ExpectedConditions.presenceOfElementLocated(oHoTen.by()));
    return getValueFromElement(oHoTen);
  }

  public void nhapDiaChi(String diaChi) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oDiaChi.by()));
    inputValueToElement(oDiaChi, diaChi);
  }

  public String layDiaChi() {
    wait.until(ExpectedConditions.presenceOfElementLocated(oDiaChi.by()));
    return getValueFromElement(oDiaChi);
  }

  public void nhapSoDienThoaiDoanhNghiep(String soDienThoaiDoanhNghiep) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oSoDienThoaiDoanhNghiep.by()));
    inputValueToElement(oSoDienThoaiDoanhNghiep, soDienThoaiDoanhNghiep);
  }

  public String laySoDienThoaiDoanhNghiep() {
    wait.until(ExpectedConditions.presenceOfElementLocated(oSoDienThoaiDoanhNghiep.by()));
    return getValueFromElement(oSoDienThoaiDoanhNghiep);
  }

  public void nhapSoDienThoaiCaNhan(String soDienThoaiCaNhan) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oSoDienThoaiCaNhan.by()));
    inputValueToElement(oSoDienThoaiCaNhan, soDienThoaiCaNhan);
  }

  public String laySoDienThoaiCaNhan() {
    wait.until(ExpectedConditions.presenceOfElementLocated(oSoDienThoaiCaNhan.by()));
    return getValueFromElement(oSoDienThoaiCaNhan);
  }

  public void clickNutDangKy() {
    wait.until(ExpectedConditions.elementToBeClickable(nutDangKy.by()));
    clickElement(nutDangKy);
  }

  public void clickNutQuayLai() {
    wait.until(ExpectedConditions.elementToBeClickable(nutQuayLai.by()));
    clickElement(nutQuayLai);
  }

}
