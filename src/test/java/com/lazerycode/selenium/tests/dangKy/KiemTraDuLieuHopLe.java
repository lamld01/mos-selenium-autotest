package com.lazerycode.selenium.tests.dangKy;

import com.github.javafaker.Faker;
import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.config.RecordVideo;
import com.lazerycode.selenium.config.ReportManager;
import com.lazerycode.selenium.page_objects.booking.manHinhDanhSachBooking.ManHinhDanhSachBooking;
import com.lazerycode.selenium.page_objects.doanhNghiepHangHoa.ManHinhThemMoi;
import com.lazerycode.selenium.page_objects.login.dangKy.ManHinhDangKy;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

public class KiemTraDuLieuHopLe extends DriverBase {
  private final Faker faker = new Faker();
  WebDriver driver;
  private ManHinhDangKy manHinhDangKy;

  @BeforeMethod
  public void setup() throws Exception {
    RecordVideo.startRecord("Test kiem tra du lieu hop le");
    driver = getDriver();
    manHinhDangKy = new ManHinhDangKy();
  }

  @DataProvider
  public String[][] duLieuTestThongBaoLoiTruongEmail() {
    return new String[][]{
        {"De trong truong email", "Khong duoc de trong truong email", "", "FE", "Please enter Email"},
        {"Email sai dinh dang", "Email khong dung dinh dang", faker.name().name(), "FE", "Email không đúng định dạng"},
    };
  }

  @Test(dataProvider = "duLieuTestThongBaoLoiTruongEmail")
  public void kiemTraThongBaoLoiTruongEmail(String tenTestCase, String moTa, String duLieuTest, String loiPhia, String noiDungLoi) {
    boolean caseDung = true;
    driver.navigate().to(ManHinhDangKy.PAGE_URL);
    ReportManager.startTest(tenTestCase, moTa);
    taoDuLieuDung();
    manHinhDangKy.nhapEmail(duLieuTest);
    manHinhDangKy.clickNutDangKy();
    String loi;
    if (Objects.equals(loiPhia, "BE")) {
      loi = manHinhDangKy.layThongBaoLoiBackend();
    } else {
      loi = manHinhDangKy.layThongBaoLoiFe();
    }
    if (!Objects.equals(loi, noiDungLoi)) {
      ReportManager.logFail(tenTestCase);
      ReportManager.captureScreenshot(tenTestCase);
      caseDung = false;
    }
    Assert.assertTrue(caseDung);
    ReportManager.endTest();
  }

  @DataProvider
  public String[][] duLieuTestChanNhapEmail() {
    return new String[][]{
        {"Nhap gia tri dac biet khac @ va .", "Khong duoc nhap gia tri dac biet khac @ va .", "lananh123_@gmail.com", "lananh123@gmail.com"}
    };
  }
  @Test(dataProvider = "duLieuTestChanNhapEmail")
  public void kiemTraChanNhapTruongEmail(String tenTestCase, String moTa, String duLieuTest, String giaTriMongMuon) {
    boolean caseDung = true;
    driver.navigate().to(ManHinhDangKy.PAGE_URL);
    ReportManager.startTest(tenTestCase, moTa);
    taoDuLieuDung();
    manHinhDangKy.nhapEmail(duLieuTest);
    String giaTriEmailHienTai = manHinhDangKy.layEmail();
    if (!Objects.equals(giaTriEmailHienTai, giaTriMongMuon)) {
      ReportManager.logFail("Khong dung gia tri mong muon: " + giaTriMongMuon);
      ReportManager.captureScreenshot(tenTestCase);
      caseDung = false;
    }
    Assert.assertTrue(caseDung);
    ReportManager.endTest();
  }

  public void taoDuLieuDung() {
    Faker faker = new Faker();
    manHinhDangKy.nhapEmail(faker.internet().emailAddress());
    manHinhDangKy.nhapMatKhau(faker.internet().password());
    manHinhDangKy.nhapMaSoThue(faker.number().digits(10));
    manHinhDangKy.nhapTenDoanhNghiep(faker.company().name());
    manHinhDangKy.nhapHoTen(faker.name().fullName());
    manHinhDangKy.nhapDiaChi(faker.address().fullAddress());
    manHinhDangKy.nhapSoDienThoaiDoanhNghiep(faker.number().digits(11));
    manHinhDangKy.nhapSoDienThoaiCaNhan(faker.number().digits(10));
  }

}
