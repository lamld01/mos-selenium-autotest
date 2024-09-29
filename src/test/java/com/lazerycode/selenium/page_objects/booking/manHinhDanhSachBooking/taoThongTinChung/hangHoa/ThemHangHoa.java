package com.lazerycode.selenium.page_objects.booking.manHinhDanhSachBooking.taoThongTinChung.hangHoa;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.page_objects.BasePage;
import com.lazerycode.selenium.util.Query;
import com.lazerycode.selenium.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.lazerycode.selenium.util.AssignDriver.initQueryObjects;

public class ThemHangHoa extends BasePage {
  public static final String PAGE_URL = Constants.SMARTGATE_WIINVENT_TV + "/danhsachtokhai/tao";

  private final Query chuNguoiNhapKhau = new Query().defaultLocator(By.xpath("//label[@class='text-lg font-bold mb-4' and text() = 'Người nhập khẩu']"));
  private final Query oMaSoThueNNK = new Query().defaultLocator(By.xpath("//input[@type='text' and @id='importerTaxCode']"));
  private final Query oTenCongTyNNK = new Query().defaultLocator(By.xpath("//input[@type='text' and @id='importerName']"));
  private final Query oDiaChiNNK = new Query().defaultLocator(By.xpath("//input[@type='text' and @id='importerAddress']"));
  private final Query oSoDienThoaiNNK = new Query().defaultLocator(By.xpath("//input[@type='text' and @id='importerPhoneNumber']"));

  private final Query oMaSoThueNXK = new Query().defaultLocator(By.xpath("//input[@type='text' and @id='exporterTaxCode']"));
  private final Query oTenCongTyNXK = new Query().defaultLocator(By.xpath("//input[@type='text' and @id='exporterName']"));
  private final Query oDiaChiNXK = new Query().defaultLocator(By.xpath("//input[@type='text' and @id='exporterAddress']"));
  private final Query oSoDienThoaiNXK = new Query().defaultLocator(By.xpath("//input[@type='text' and @id='exporterPhoneNumber']"));

  private final Query tenHangHoa = new Query().defaultLocator(By.xpath("//input[@type='text' and @id='goodsName']"));
  private final Query trongLuongHangHoa = new Query().defaultLocator(By.xpath("//input[@type='number' and @id='weight']"));
  private final Query donViTrongLuong = new Query().defaultLocator(By.xpath("//select[@id='unitQuantityDetailCode']"));
  private final Query xuatXuHangHoa = new Query().defaultLocator(By.xpath("//input[@type='text' and @id='goodsOrigin']"));
  private final Query soLuongHangHoa = new Query().defaultLocator(By.xpath("//input[@type='number' and @id='quantity']"));
  private final Query donViSoLuongHangHoa = new Query().defaultLocator(By.xpath("//select[@id='measureUnitId']"));
  private final Query giaTriHangHoa = new Query().defaultLocator(By.xpath("//input[@type='number' and @id='commodityValue']"));

  private final WebDriverWait wait;

  public ThemHangHoa() throws Exception {
    initQueryObjects(this, DriverBase.getDriver());
    this.wait = new WebDriverWait(DriverBase.getDriver(), Duration.ofSeconds(15), Duration.ofMillis(5000));
  }

  public void nhapMaSoThueNNK(String maSoThue) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oMaSoThueNNK.by()));
    inputValueToElement(oMaSoThueNNK, maSoThue);
  }

  public void nhapTenCongTyNNK(String tenCongTy) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oTenCongTyNNK.by()));
    inputValueToElement(oTenCongTyNNK, tenCongTy);
  }

  public void nhapDiaChiNNK(String diaChi) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oDiaChiNNK.by()));
    inputValueToElement(oDiaChiNNK, diaChi);
  }

  public void nhapSoDienThoaiNNK(String soDienThoai) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oSoDienThoaiNNK.by()));
    inputValueToElement(oSoDienThoaiNNK, soDienThoai);
  }

  public void nhapMaSoThueNXK(String maSoThue) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oMaSoThueNXK.by()));
    inputValueToElement(oMaSoThueNXK, maSoThue);
  }

  public void nhapTenCongTyNXK(String tenCongTy) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oTenCongTyNXK.by()));
    inputValueToElement(oTenCongTyNXK, tenCongTy);
  }

  public void nhapDiaChiNXK(String diaChi) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oDiaChiNXK.by()));
    inputValueToElement(oDiaChiNXK, diaChi);
  }

  public void nhapSoDienThoaiNXK(String soDienThoai) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oSoDienThoaiNXK.by()));
    inputValueToElement(oSoDienThoaiNXK, soDienThoai);
  }

  public void nhapTenHangHoa(String tenHang) {
    wait.until(ExpectedConditions.presenceOfElementLocated(tenHangHoa.by()));
    inputValueToElement(tenHangHoa, tenHang);
  }

  public void nhapTrongLuongHangHoa(String trongLuong) {
    wait.until(ExpectedConditions.presenceOfElementLocated(trongLuongHangHoa.by()));
    inputValueToElement(trongLuongHangHoa, trongLuong);
  }

  public void chonDonViTrongLuong(String donVi) {
    wait.until(ExpectedConditions.presenceOfElementLocated(donViTrongLuong.by()));
    selectElementFromDropdown(donViTrongLuong, donVi);
  }

  public void chonDonViTrongLuong(int index) {
    wait.until(ExpectedConditions.presenceOfElementLocated(donViTrongLuong.by()));
    selectElementFromDropdown(donViTrongLuong, index);
  }

  public void nhapXuatXuHangHoa(String xuatXu) {
    wait.until(ExpectedConditions.presenceOfElementLocated(xuatXuHangHoa.by()));
    inputValueToElement(xuatXuHangHoa, xuatXu);
  }

  public void nhapSoLuongHangHoa(String soLuong) {
    wait.until(ExpectedConditions.presenceOfElementLocated(soLuongHangHoa.by()));
    inputValueToElement(soLuongHangHoa, soLuong);
  }

  public void chonDonViSoLuong(String donVi) {
    wait.until(ExpectedConditions.presenceOfElementLocated(donViSoLuongHangHoa.by()));
    selectElementFromDropdown(donViSoLuongHangHoa, donVi);
  }
  public void chonDonViSoLuong(int index) {
    wait.until(ExpectedConditions.presenceOfElementLocated(donViSoLuongHangHoa.by()));
    selectElementFromDropdown(donViSoLuongHangHoa, index);
  }

  public void nhapGiaTriHangHoa(String giaTri) {
    wait.until(ExpectedConditions.presenceOfElementLocated(giaTriHangHoa.by()));
    inputValueToElement(giaTriHangHoa, giaTri);
  }
}
