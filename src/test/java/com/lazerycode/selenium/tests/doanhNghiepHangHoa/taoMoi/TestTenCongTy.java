package com.lazerycode.selenium.tests.doanhNghiepHangHoa.taoMoi;

import com.github.javafaker.Faker;
import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.config.ReportManager;
import com.lazerycode.selenium.page_objects.doanhNghiepHangHoa.DanhSachHH;
import com.lazerycode.selenium.page_objects.doanhNghiepHangHoa.ManHinhThemMoi;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;

public class TestTenCongTy extends DriverBase {
    private final Faker faker = new Faker();
    private DanhSachHH  danhSachHH;
    private ManHinhThemMoi manHinhThemMoi;
    @BeforeMethod
    public void setup() throws Exception {
        getDriverLogin(DanhSachHH.PAGE_URL);
        danhSachHH = new DanhSachHH();
        manHinhThemMoi = new ManHinhThemMoi();
    }
    @Test
    public void tenCongTyDeTrong(){
        boolean caseDung = true;
        danhSachHH.clickThemMoiButton();
        ReportManager.startTest("Test để trống tên công ty", "Tên công ty la bat buoc nhap");
        dienGiaTriDung();
        manHinhThemMoi.nhapHoTen("");
        ReportManager.captureScreenshot("sau nhập dữ liệu");
        manHinhThemMoi.nhanNutThemMoi();
        ReportManager.captureScreenshot("kết quả sau khi nhấn button thêm mới");
        String loiFE = manHinhThemMoi.layLoiFE().toLowerCase().trim();
        if(!Objects.equals(loiFE, "vui lòng nhập dữ liệu")){
            caseDung = false;
            ReportManager.logFail("Nội dung không chính xác");
        }else{
            ReportManager.logPass("Đã pass case này");
        }
        ReportManager.endTest();
        Assert.assertTrue(caseDung);

    }
    @Test
    public void nhapTenKiTuDacBiet(){
        boolean caseDung = true;
        danhSachHH.clickThemMoiButton();
        ReportManager.startTest("Test nhập kí tự đặc biêt vào  Tên công ty", "Tên công ty không được nhập k tự đặc biệt");
        dienGiaTriDung();
        manHinhThemMoi.nhapHoTen("!@#$%^&*(),./");
        ReportManager.captureScreenshot("sau nhập dữ liệu");
        String giaTriTenCongTyTai = manHinhThemMoi.layHoTen();
        if(!giaTriTenCongTyTai.isEmpty()){
            caseDung = false;
            ReportManager.logFail("FE chưa chặn nập kí tự đặc biệt");
        }else{
            ReportManager.logPass("Đã pass case này");
        }
        ReportManager.endTest();
        Assert.assertTrue(caseDung);

    }

    @Test
    public void nhapSoKiTuToiDa(){
        boolean caseDung = true;
        danhSachHH.clickThemMoiButton();
        ReportManager.startTest("Test biên > 255 kí tự cho tên công ty", "Tên công ty có độ dài tối đa là 255");
        dienGiaTriDung();
        manHinhThemMoi.nhapMaSoThue(faker.lorem().characters(256));
        ReportManager.captureScreenshot("sau nhập dữ liệu");
        String giaTriTenCongTyHT = manHinhThemMoi.layHoTen();
        if(giaTriTenCongTyHT.length() > 255){
            caseDung = false;
            ReportManager.logFail("FE chưa chặn số kí tự tôí đa");
        }else{
            ReportManager.logPass("Đã pass case này");
        }
        ReportManager.endTest();
        Assert.assertTrue(caseDung);

    }
    @Test
    public void nhapKhoangTrang(){
        boolean caseDung = true;
        danhSachHH.clickThemMoiButton();
        ReportManager.startTest("Test nhập khoảng trắng", "Chỉ nhập khoảng trawgs cho field tên công ty");
        dienGiaTriDung();
        manHinhThemMoi.nhapHoTen("   ");
        ReportManager.captureScreenshot("sau nhập dữ liệu");
        manHinhThemMoi.nhanNutThemMoi();
        ReportManager.captureScreenshot("Màn hình sau khi nhấn nút");
        String giaTriHTTenCT = manHinhThemMoi.layHoTen();
        if(!giaTriHTTenCT.isEmpty()){
            caseDung = false;
            ReportManager.logFail("FE chưa chặn khoảng trắng");
        }else{
            ReportManager.logPass("Đã pass case này");
        }
        ReportManager.endTest();
        Assert.assertTrue(caseDung);

    }


    public void dienGiaTriDung(){
        manHinhThemMoi.nhapMaSoThue(String.valueOf(faker.number().numberBetween(1000000000,9999999999999L)));
        manHinhThemMoi.nhapHoTen("Công ty " + faker.company().name());
        manHinhThemMoi.nhapSoDienThoai(0 + faker.phoneNumber().subscriberNumber(9));
        manHinhThemMoi.nhapDiaChi(faker.address().fullAddress());
    }

}
