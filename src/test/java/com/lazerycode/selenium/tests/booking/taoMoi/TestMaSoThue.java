package com.lazerycode.selenium.tests.booking.taoMoi;

import com.github.javafaker.Faker;
import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.config.ReportManager;
import com.lazerycode.selenium.page_objects.booking.manHinhDanhSachBooking.ManHinhDanhSachBooking;
import com.lazerycode.selenium.page_objects.booking.manHinhDanhSachBooking.taoThongTinChung.TaoThongTinChung;
import com.lazerycode.selenium.page_objects.booking.manHinhDanhSachBooking.taoThongTinChung.hangHoa.ThemHangHoa;
import com.lazerycode.selenium.page_objects.booking.manHinhDanhSachBooking.taoThongTinChung.phuongTien.ThemPhuongTien;
import com.lazerycode.selenium.page_objects.booking.manHinhDanhSachBooking.taoThongTinChung.phuongTien.xeSangTai.XeSangTai;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestMaSoThue extends DriverBase {
  private final Faker faker = new Faker();
  private ManHinhDanhSachBooking manHinhDanhSachBooking;
  private TaoThongTinChung manHinhTaoThongTinChung;
  private ThemPhuongTien manHinhThemPhuongTien;
  private XeSangTai manHinhXeSangTai;
  private ThemHangHoa manHinhTaoThongTinHangHoa;
  @BeforeMethod
  public void setup() throws Exception {
    getDriverLogin(ManHinhDanhSachBooking.PAGE_URL);
    manHinhDanhSachBooking = new ManHinhDanhSachBooking();
    manHinhTaoThongTinChung = new TaoThongTinChung();
    manHinhThemPhuongTien = new ThemPhuongTien();
    manHinhXeSangTai = new XeSangTai();
    manHinhTaoThongTinHangHoa = new ThemHangHoa();
  }

  @Test
  public void maSoThueDeTrong() {
    ReportManager.startTest("Test ma so thue de trong", "ma so thue de trong");
    manHinhDanhSachBooking.nhanNutThemMoi();
    taoThongTinChung();
    ReportManager.captureScreenshot("Sau khi tao thong tin chung");
    manHinhTaoThongTinChung.chonThemPhuongTien();
    taoThongTinXeVanChuyen();
    ReportManager.captureScreenshot("Sau khi tao thong tin xe van chuyen");
    taoThongTinXeSangTai(0);
    ReportManager.captureScreenshot("Sau khi tao thong tin xe sang tai");
    manHinhThemPhuongTien.bamLuuThongTinXe();
    ReportManager.captureScreenshot("Sau khi bam luu va them moi");

    manHinhTaoThongTinChung.chonThemHangHoa();
    taoThongTinHangHoa();
    ReportManager.endTest();
  }

  public void taoThongTinChung() {
    manHinhTaoThongTinChung.nhapMaSoThue(faker.number().digits(13));
    manHinhTaoThongTinChung.nhapTenToChucCaNhan(faker.company().name());
    manHinhTaoThongTinChung.nhapDiaChi(faker.address().fullAddress());
    manHinhTaoThongTinChung.nhapDiaChi(0 + faker.phoneNumber().cellPhone());
    manHinhTaoThongTinChung.nhapSoDienThoai(0 + faker.phoneNumber().subscriberNumber(9));
    manHinhTaoThongTinChung.chonNgayDenDuKien(faker.internet().domainName());
    manHinhTaoThongTinChung.chonGioDenDuKien("29/09/2024");
    manHinhTaoThongTinChung.chonBaiThongQuan(1);
    manHinhTaoThongTinChung.chonLoaiHinhHangHoa(0);
    manHinhTaoThongTinChung.nhapNguoiLamThuTuc(faker.company().name());
    manHinhTaoThongTinChung.nhapSoDienThoaiNguoiLamThuTuc(0 + faker.phoneNumber().subscriberNumber(9));
    manHinhTaoThongTinChung.checkHangThuongMaiDienTu(true);
  }

  public void taoThongTinXeVanChuyen() {
    manHinhThemPhuongTien.nhapBienKiemSoat("79A" + faker.number().digits(5)); // Biển số có tiền tố '79A'
    manHinhThemPhuongTien.chonLoaiPhuongTienVanTai(1);
    manHinhThemPhuongTien.nhapSoMooc(faker.number().digits(7));
    manHinhThemPhuongTien.nhapSoContainer(faker.number().digits(9));
    manHinhThemPhuongTien.nhapSoDienThoaiLaiXe(0 + faker.phoneNumber().subscriberNumber(9)); // Dùng cellPhone cho số điện thoại
    manHinhThemPhuongTien.nhapTenLaiXe(faker.name().fullName());
    manHinhThemPhuongTien.nhapCMNDLaiXe(faker.idNumber().valid()); // Sử dụng một ID hợp lệ
    manHinhThemPhuongTien.nhapTenNguoiDiCung(faker.name().fullName());
    manHinhThemPhuongTien.nhapXuatXuPhuongTien(faker.country().name());
    manHinhThemPhuongTien.nhapSoSeal(faker.number().digits(9));
    manHinhThemPhuongTien.nhapTuTrong("1000");
    manHinhThemPhuongTien.nhapTongTrongLuongHangHoa(String.valueOf(faker.number().numberBetween(1000, 10000))); // Trọng lượng từ 1000 đến 10000
    manHinhThemPhuongTien.chonNhomHangHoa(1);
    manHinhThemPhuongTien.chonTaiTrongXe(1);
    manHinhThemPhuongTien.nhapTaiGhiChu(faker.company().catchPhrase());
    manHinhThemPhuongTien.checkboxCoXeSangTai(true);
  }

  public void taoThongTinXeSangTai(int viTriXe) {
    manHinhXeSangTai.nhapBienKiemSoat("79A" + faker.number().digits(5), viTriXe);
    manHinhXeSangTai.chonLoaiPhuongTien(1, viTriXe);
    manHinhXeSangTai.nhapSoMooc(faker.number().digits(7), viTriXe);
    manHinhXeSangTai.nhapSoContainer(faker.number().digits(9), viTriXe);
    manHinhXeSangTai.nhapDienThoaiLaiXe(0 + faker.phoneNumber().subscriberNumber(9), viTriXe); // Sử dụng số điện thoại di động
    manHinhXeSangTai.nhapTenLaiXe(faker.name().fullName(), viTriXe);
    manHinhXeSangTai.nhapSoCmnn(faker.idNumber().valid(), viTriXe); // Sử dụng ID hợp lệ
    manHinhXeSangTai.nhapTuTrong(faker.number().randomDouble(2, 1, 1000) + "", viTriXe); // Trọng lượng, ví dụ: từ 1 đến 1000
    manHinhXeSangTai.chonTaiTrongXe(1, viTriXe);
    manHinhXeSangTai.nhapGhiChu(faker.lorem().sentence(), viTriXe); // Ghi chú, ví dụ: một câu mô tả ngắn
  }

  public void taoThongTinHangHoa() {
    manHinhTaoThongTinHangHoa.nhapMaSoThueNNK(faker.number().digits(10)); // Random tax code
    manHinhTaoThongTinHangHoa.nhapTenCongTyNNK(faker.company().name()); // Random company name
    manHinhTaoThongTinHangHoa.nhapDiaChiNNK(faker.address().fullAddress()); // Random address
    manHinhTaoThongTinHangHoa.nhapSoDienThoaiNNK(0 + faker.phoneNumber().subscriberNumber(9)); // Random phone number

    // Nhập thông tin người xuất khẩu
    manHinhTaoThongTinHangHoa.nhapMaSoThueNXK(faker.number().digits(10)); // Random tax code
    manHinhTaoThongTinHangHoa.nhapTenCongTyNXK(faker.company().name()); // Random company name
    manHinhTaoThongTinHangHoa.nhapDiaChiNXK(faker.address().fullAddress()); // Random address
    manHinhTaoThongTinHangHoa.nhapSoDienThoaiNXK(0 + faker.phoneNumber().subscriberNumber(9)); // Random phone number

    // Nhập thông tin hàng hóa
    manHinhTaoThongTinHangHoa.nhapTenHangHoa(faker.commerce().productName()); // Random product name
    manHinhTaoThongTinHangHoa.nhapTrongLuongHangHoa(String.valueOf(faker.number().numberBetween(1, 10000))); // Random weight
    manHinhTaoThongTinHangHoa.chonDonViTrongLuong(1); // Assuming "kg" as a fixed unit for simplicity
    manHinhTaoThongTinHangHoa.nhapXuatXuHangHoa(faker.country().name()); // Random country of origin
    manHinhTaoThongTinHangHoa.nhapSoLuongHangHoa(String.valueOf(faker.number().numberBetween(1, 100))); // Random quantity
    manHinhTaoThongTinHangHoa.chonDonViSoLuong(1); // Assuming "pcs" as a fixed unit for simplicity
    manHinhTaoThongTinHangHoa.nhapGiaTriHangHoa(String.valueOf(faker.commerce().price())); // Random commodity value

  }
}
