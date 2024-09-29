package com.lazerycode.selenium.page_objects.booking.manHinhDanhSachBooking.taoThongTinChung.phuongTien;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.page_objects.BasePage;
import com.lazerycode.selenium.util.Query;
import com.lazerycode.selenium.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.lazerycode.selenium.util.AssignDriver.initQueryObjects;

public class ThemPhuongTien extends BasePage {
  public static final String PAGE_URL = Constants.SMARTGATE_WIINVENT_TV + "/danhsachtokhai/tao";

  private final Query chuXeVanChuyen = new Query().defaultLocator(By.xpath("//label[@class='text-lg font-bold mb-4' and text() = 'Xe vận chuyển']"));
  private final Query oNhapBienKiemSoat = new Query().defaultLocator(By.xpath("//input[@id='licensePlate']"));
  private final Query oChonLoaiPhuongTienVanTai = new Query().defaultLocator(By.xpath("//select[@id='vehicleType']"));
  private final Query oNhapSoMooc = new Query().defaultLocator(By.xpath("//input[@id='mooc']"));
  private final Query oNhapSoContainer = new Query().defaultLocator(By.xpath("//input[@id='containerNumber']"));
  private final Query oNhapSoDienThoaiLaiXe = new Query().defaultLocator(By.xpath("//input[@id='driverPhoneNumber']"));
  private final Query oNhapTenLaiXe = new Query().defaultLocator(By.xpath("//input[@id='driverName']"));
  private final Query oNhapCMNDLaiXe = new Query().defaultLocator(By.xpath("//input[@id='driverMsisdn']"));
  private final Query oNhapTenNguoiDiCung = new Query().defaultLocator(By.xpath("//input[@id='companiontName']"));
  private final Query oXuatXuPhuongTien = new Query().defaultLocator(By.xpath("//input[@id='vehicleComeFrom']"));
  private final Query oNhapSoSeal = new Query().defaultLocator(By.xpath("//input[@id='seal']"));
  private final Query oNhapTuTrong = new Query().defaultLocator(By.xpath("//input[@id='loadDueToOwnWeight']"));
  private final Query oNhapTongTrongLuongHangHoa = new Query().defaultLocator(By.xpath("//input[@id='productWeight']"));
  private final Query oChonNhomHangHoa = new Query().defaultLocator(By.xpath("//select[@id='goodsId']"));
  private final Query oChonTaiTrongXe = new Query().defaultLocator(By.xpath("//select[@id='vehicleLoadCapacityId']"));
  private final Query oNhapTaiGhiChu = new Query().defaultLocator(By.xpath("//input[@id='note']"));
  private final Query oCheckboxCoXeSangTai = new Query().defaultLocator(By.xpath("//input[@id='loadTransfer']"));
  private final Query nutThemXeSangTai = new Query().defaultLocator(By.xpath("//button[@class='btn btn-sm border-red-max text-red-max hover:bg-red-max hover:text-white mt-4' and text() = 'Thêm xe sang tải']"));
  private final Query nutBamLuuVaThemMoi = new Query().defaultLocator(By.xpath("//div[@class='flex justify-center items-center gap-2 p-4 border-t dark:border-slate-700']/button[text() = 'Lưu và thêm mới']"));
  private final Query nutBamLuuThongTinXe= new Query().defaultLocator(By.xpath("//div[@class='flex justify-center items-center gap-2 p-4 border-t dark:border-slate-700']/button[text() = 'Lưu thông tin xe']"));

  private final WebDriverWait wait;

  public ThemPhuongTien() throws Exception {
    initQueryObjects(this, DriverBase.getDriver());
    this.wait = new WebDriverWait(DriverBase.getDriver(), Duration.ofSeconds(15), Duration.ofMillis(5000));
  }

  public void nhapBienKiemSoat(String bienKiemSoat) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oNhapBienKiemSoat.by()));
    inputValueToElement(oNhapBienKiemSoat, bienKiemSoat);
  }

  public void chonLoaiPhuongTienVanTai(String loaiPhuongTien) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oChonLoaiPhuongTienVanTai.by()));
    selectElementFromDropdown(oChonLoaiPhuongTienVanTai, loaiPhuongTien);
  }

  public void chonLoaiPhuongTienVanTai(int index) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oChonLoaiPhuongTienVanTai.by()));
    selectElementFromDropdown(oChonLoaiPhuongTienVanTai, index);
  }

  public void nhapSoMooc(String soMooc) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oNhapSoMooc.by()));
    inputValueToElement(oNhapSoMooc, soMooc);
  }

  public void nhapSoContainer(String soContainer) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oNhapSoContainer.by()));
    inputValueToElement(oNhapSoContainer, soContainer);
  }

  public void nhapSoDienThoaiLaiXe(String soDienThoai) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oNhapSoDienThoaiLaiXe.by()));
    inputValueToElement(oNhapSoDienThoaiLaiXe, soDienThoai);
  }

  public void nhapTenLaiXe(String tenLaiXe) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oNhapTenLaiXe.by()));
    inputValueToElement(oNhapTenLaiXe, tenLaiXe);
  }

  public void nhapCMNDLaiXe(String cmndLaiXe) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oNhapCMNDLaiXe.by()));
    inputValueToElement(oNhapCMNDLaiXe, cmndLaiXe);
  }

  public void nhapTenNguoiDiCung(String tenNguoiDiCung) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oNhapTenNguoiDiCung.by()));
    inputValueToElement(oNhapTenNguoiDiCung, tenNguoiDiCung);
  }

  public void nhapXuatXuPhuongTien(String xuatXuPhuongTien) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oXuatXuPhuongTien.by()));
    inputValueToElement(oXuatXuPhuongTien, xuatXuPhuongTien);
  }

  public void nhapSoSeal(String soSeal) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oNhapSoSeal.by()));
    inputValueToElement(oNhapSoSeal, soSeal);
  }

  public void nhapTuTrong(String tuTrong) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oNhapTuTrong.by()));
    inputValueToElement(oNhapTuTrong, tuTrong);
  }

  public void nhapTongTrongLuongHangHoa(String tongTrongLuong) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oNhapTongTrongLuongHangHoa.by()));
    inputValueToElement(oNhapTongTrongLuongHangHoa, tongTrongLuong);
  }

  public void chonNhomHangHoa(String nhomHangHoa) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oChonNhomHangHoa.by()));
    selectElementFromDropdown(oChonNhomHangHoa, nhomHangHoa);
  }

  public void chonNhomHangHoa(int index) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oChonNhomHangHoa.by()));
    selectElementFromDropdown(oChonNhomHangHoa, index);
  }

  public void chonTaiTrongXe(String taiTrong) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oChonTaiTrongXe.by()));
    selectElementFromDropdown(oChonTaiTrongXe, taiTrong);
  }

  public void chonTaiTrongXe(int index) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oChonTaiTrongXe.by()));
    selectElementFromDropdown(oChonTaiTrongXe, index);
  }

  public void nhapTaiGhiChu(String ghiChu) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oNhapTaiGhiChu.by()));
    inputValueToElement(oNhapTaiGhiChu, ghiChu);
  }

  public void checkboxCoXeSangTai(boolean coXeSangTai) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oCheckboxCoXeSangTai.by()));
    clickCheckBox(oCheckboxCoXeSangTai, coXeSangTai);
  }

  public void bamLuuVaThemMoi() {
    wait.until(ExpectedConditions.elementToBeClickable(nutBamLuuVaThemMoi.by()));
    clickElement(nutBamLuuVaThemMoi);
  }

  public void bamLuuThongTinXe() {
    wait.until(ExpectedConditions.elementToBeClickable(nutBamLuuThongTinXe.by()));
    clickElement(nutBamLuuThongTinXe);
  }

  public void bamThemXeSangTai() {
    wait.until(ExpectedConditions.elementToBeClickable(nutThemXeSangTai.by()));
    clickElement(nutThemXeSangTai);
  }
}

