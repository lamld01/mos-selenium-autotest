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

public class TestDiaChi extends DriverBase {
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
    public void diaChiDeTrong(){
        boolean caseDung = true;
        danhSachHH.clickThemMoiButton();
        ReportManager.startTest("Test để trống địa chỉ", "Địa chỉ là bắt buộc nhập ");
        dienGiaTriDung();
        manHinhThemMoi.nhapDiaChi("");
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
    public void nhapSoKiTuToiDa(){
        boolean caseDung = true;
        danhSachHH.clickThemMoiButton();
        ReportManager.startTest("Test biên > 255 kí tự cho tên công ty", "Tên công ty có độ dài tối đa là 255");
        dienGiaTriDung();
        manHinhThemMoi.nhapDiaChi(faker.lorem().characters(256));
        ReportManager.captureScreenshot("sau nhập dữ liệu");
        String giaTriDiaChiHT = manHinhThemMoi.layDiaChi();
        if(giaTriDiaChiHT.length() > 255){
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
        ReportManager.startTest("Test nhập khoảng trắng", "Chỉ nhập khoảng trắng cho field địa chỉ");
        dienGiaTriDung();
        manHinhThemMoi.nhapHoTen("   ");
        ReportManager.captureScreenshot("sau nhập dữ liệu");
        manHinhThemMoi.nhanNutThemMoi();
        ReportManager.captureScreenshot("Màn hình sau khi nhấn nút");
        String giaTriDiaChiHT = manHinhThemMoi.layDiaChi();
        if(!giaTriDiaChiHT.isEmpty()){
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
