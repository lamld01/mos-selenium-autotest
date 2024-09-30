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
  @DataProvider
  public String[][] duLieuKiemTraThongBaoLoiMK(){
    Faker faker = new Faker();
    return new String[][]{

            {"Nhập mật khẩu = null","Mật khẩu không được để trống","","FE","Vui lòng nhập dữ liệu"},
            {"Nhập mật khẩu không có kí tự số","Mật khẩu phải chứa cả chữ và số", faker.lorem().characters(6,10),"FE","Tối thiểu 6 kí tự và bao gồm cả chữ và số"},
            {"Nhập mật khẩu không có kí tự chữ","Mật khẩu phải chứa cả chữ và số",faker.phoneNumber().subscriberNumber(10),"FE","Tối thiểu 6 kí tự và bao gồm cả chữ và số"},
            {"Nhập mật khẩu nhỏ hơn số kí tự tối thiểu","Mật khẩu tối thiểu 6 kí tự bao gồm cả chữ và số",faker.internet().password(1,5),"FE","Tối thiểu 6 kí tự và bao gồm cả chữ và số"},
            {"Nhập mật khẩu  không chứa khoảng trắng","Mật khẩu không được chứa kí tự space","lananh1511 1511lananh","FE","Mật khẩu không bao gồm khaongr trắng"}
    };

  }
  @Test(dataProvider = "duLieuKiemTraThongBaoLoiMK")
  public void kiemTraThongBaoLoiMatKhau(String tenTestCase, String moTa, String duLieuTest,String loiPhia, String noiDungLoi ){
    boolean caseDung = true;
    driver.navigate().to(ManHinhDangKy.PAGE_URL);
    ReportManager.startTest(tenTestCase,moTa);
    taoDuLieuDung();
    manHinhDangKy.nhapMatKhau(duLieuTest);
    manHinhDangKy.clickNutDangKy();
    String loi;
    if(loiPhia =="BE"){
      loi = manHinhDangKy.layThongBaoLoiBackend();
    }else{
      loi = manHinhDangKy.layThongBaoLoiFe();
    }
    if(loi != noiDungLoi){
      ReportManager.logFail("Thông báo không chính xác ");
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
