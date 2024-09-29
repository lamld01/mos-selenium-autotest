package com.lazerycode.selenium.page_objects.booking.manHinhDanhSachBooking.taoThongTinChung;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.page_objects.BasePage;
import com.lazerycode.selenium.page_objects.booking.base.ThongTinXe;
import com.lazerycode.selenium.util.Query;
import com.lazerycode.selenium.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.lazerycode.selenium.util.AssignDriver.initQueryObjects;

public class TaoThongTinChung extends BasePage {

  public static final String PAGE_URL = Constants.SMARTGATE_WIINVENT_TV + "/danhsachtokhai/tao";

  private final Query oNhapMaSoThue = new Query().defaultLocator(By.xpath("//input[@type='text' and @id='feePayingCompanyTaxCode']"));
  private final Query oNhapTenToChucCaNhan = new Query().defaultLocator(By.xpath("//input[@type='text' and @id='feePayingCompanyName']"));
  private final Query oNhapDiaChi = new Query().defaultLocator(By.xpath("//input[@type='text' and @id='feePayingCompanyAddress']"));
  private final Query oNhapSoDienThoai = new Query().defaultLocator(By.xpath("//input[@type='text' and @id='feePayingCompanyPhoneNumber']"));
  private final Query oChonNgayDenDuKien = new Query().defaultLocator(By.xpath("//input[@type='text' and @class='form-control form-input form-input-sm ' and @placeholder='Chọn ngày']"));
  private final Query oChonGioDenDuKien = new Query().defaultLocator(By.xpath("//input[@placeholder='Chọn giờ' and @type='text']"));
  private final Query oChonBaiThongQuan = new Query().defaultLocator(By.xpath("//select[@id='customsClearanceArea']"));
  private final Query oChonLoaiHinhHangHoa = new Query().defaultLocator(By.xpath("//select[@id='goodsTypeId']"));
  private final Query oChonLoaiLoHangXuatNhapKhau = new Query().defaultLocator(By.xpath("//select[@id='importExportShipmentType']"));
  private final Query oNhapNguoiLamThuTuc = new Query().defaultLocator(By.xpath("//input[@id='procedureOfficerName']"));
  private final Query oNhapSoDienThoaiNguoiLamThuTuc = new Query().defaultLocator(By.xpath("//input[@id='procedureOfficerPhoneNumber']"));
  private final Query oCheckboxHangThuongMaiDienTu = new Query().defaultLocator(By.xpath("//input[@id='isECommerceGoods']"));
  private final Query nutThemPhuongTien = new Query().defaultLocator(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/main/div/div/div/div[1]/div[3]/button"));
  private final Query nutThemHangHoa = new Query().defaultLocator(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/main/div/div/div/div[1]/div[5]/button"));
  private final Query nutTiepTheoButton = new Query().defaultLocator(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/main/div/div/div/div[2]/button"));
  private final WebDriverWait wait;

  public TaoThongTinChung() throws Exception {
    initQueryObjects(this, DriverBase.getDriver());
    this.wait = new WebDriverWait(DriverBase.getDriver(), Duration.ofSeconds(15), Duration.ofMillis(5000));
  }

  public void nhapMaSoThue(String maSoThue) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oNhapMaSoThue.by()));
    inputValueToElement(oNhapMaSoThue, maSoThue);
  }

  public void nhapTenToChucCaNhan(String tenToChucCaNhan) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oNhapTenToChucCaNhan.by()));
    inputValueToElement(oNhapTenToChucCaNhan, tenToChucCaNhan);
  }

  public void nhapDiaChi(String diaChi) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oNhapDiaChi.by()));
    inputValueToElement(oNhapDiaChi, diaChi);
  }

  public void nhapSoDienThoai(String soDienThoai) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oNhapSoDienThoai.by()));
    inputValueToElement(oNhapSoDienThoai, soDienThoai);
  }

  public void chonNgayDenDuKien(String ngayDen) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oChonNgayDenDuKien.by()));
    inputValueToElement(oChonNgayDenDuKien, ngayDen);
  }

  public void chonGioDenDuKien(String gioDen) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oChonGioDenDuKien.by()));
    inputValueToElement(oChonGioDenDuKien, gioDen);
  }

  public void chonBaiThongQuan(String baiThongQuan) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oChonBaiThongQuan.by()));
    selectElementFromDropdown(oChonBaiThongQuan, baiThongQuan);
  }

  public void chonBaiThongQuan(int index) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oChonBaiThongQuan.by()));
    selectElementFromDropdown(oChonBaiThongQuan, index);
  }

  public void chonLoaiHinhHangHoa(String loaiHinh) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oChonLoaiHinhHangHoa.by()));
    selectElementFromDropdown(oChonLoaiHinhHangHoa, loaiHinh);
  }

  public void chonLoaiHinhHangHoa(int index) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oChonLoaiHinhHangHoa.by()));
    selectElementFromDropdown(oChonLoaiHinhHangHoa, index);
  }

  public void chonLoaiLoHangXuatNhapKhau(String loaiLoHang) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oChonLoaiLoHangXuatNhapKhau.by()));
    selectElementFromDropdown(oChonLoaiLoHangXuatNhapKhau, loaiLoHang);
  }

  public void nhapNguoiLamThuTuc(String nguoiLamThuTuc) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oNhapNguoiLamThuTuc.by()));
    inputValueToElement(oNhapNguoiLamThuTuc, nguoiLamThuTuc);
  }

  public void nhapSoDienThoaiNguoiLamThuTuc(String soDienThoaiNguoiLamThuTuc) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oNhapSoDienThoaiNguoiLamThuTuc.by()));
    inputValueToElement(oNhapSoDienThoaiNguoiLamThuTuc, soDienThoaiNguoiLamThuTuc);
  }

  public void checkHangThuongMaiDienTu(boolean check) {
    wait.until(ExpectedConditions.presenceOfElementLocated(oCheckboxHangThuongMaiDienTu.by()));
    clickCheckBox(oCheckboxHangThuongMaiDienTu, check);
  }

  public void chonThemPhuongTien() {
    wait.until(ExpectedConditions.presenceOfElementLocated(nutThemPhuongTien.by()));
    clickElement(nutThemPhuongTien);
  }

  public void chonThemHangHoa() {
    wait.until(ExpectedConditions.presenceOfElementLocated(nutThemHangHoa.by()));
    clickElement(nutThemHangHoa);
  }

  public void chonTiepTheo() {
    wait.until(ExpectedConditions.presenceOfElementLocated(nutTiepTheoButton.by()));
    clickElement(nutTiepTheoButton);
  }

  public List<ThongTinXe> layThongTinXe() {
    return null;
  }
}
