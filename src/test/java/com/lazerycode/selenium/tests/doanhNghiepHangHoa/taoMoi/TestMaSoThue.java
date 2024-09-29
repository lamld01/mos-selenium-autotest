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

public class TestMaSoThue extends DriverBase {
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
    public void maSoThueDeTrong(){
        boolean caseDung = true;
        danhSachHH.clickThemMoiButton();
        ReportManager.startTest("Test De Trong Ma So Thue", "Ma so thue la bat buoc nhap");
        dienGiaTriDung();
        manHinhThemMoi.nhapMaSoThue("");
        ReportManager.captureScreenshot("sau nhập dữ liệu");
        manHinhThemMoi.nhanNutThemMoi();
        ReportManager.captureScreenshot("kết quả sau khi nhấn button thêm mới");
        String loiFE = manHinhThemMoi.layLoiFE();
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
    public void nhapKhoangTrangMaSoThue(){
        boolean caseDung = true;
        danhSachHH.clickThemMoiButton();
        ReportManager.startTest("Test nhập khoảng trắng Ma So Thue", "Chỉ nhập mình khoảng trắng");
        dienGiaTriDung();
        manHinhThemMoi.nhapMaSoThue("   ");
        ReportManager.captureScreenshot("sau nhập dữ liệu");
        String giaTriHTMaSoThue = manHinhThemMoi.layMaSoThue();
        if(!giaTriHTMaSoThue.isEmpty()){
            caseDung = false;
            ReportManager.logFail("Nội dung không chính xác");
        }else{
            ReportManager.logPass("Đã pass case này");
        }
        ReportManager.endTest();
        Assert.assertTrue(caseDung);

    }
    @Test
    public void nhapKiTuDacBiet(){
        boolean caseDung = true;
        danhSachHH.clickThemMoiButton();
        ReportManager.startTest("Test nhập kí tự đặc biêt vào  Ma So Thue", "Ma so thue không được nhập k tự đặc biệt");
        dienGiaTriDung();
        manHinhThemMoi.nhapMaSoThue("!@#$%^&*()");
        ReportManager.captureScreenshot("sau nhập dữ liệu");
        String giaTriMaSoThueHienTai = manHinhThemMoi.layMaSoThue();
        if(!giaTriMaSoThueHienTai.isEmpty()){
            caseDung = false;
            ReportManager.logFail("FE chưa chặn nập kí tự đặc biệt");
        }else{
            ReportManager.logPass("Đã pass case này");
        }
        ReportManager.endTest();
        Assert.assertTrue(caseDung);

    }
    @Test
    public void nhapKiTuChu(){
        boolean caseDung = true;
        danhSachHH.clickThemMoiButton();
        ReportManager.startTest("Test nhập kí tự chữ vào  Ma So Thue", "Ma so thue không được nhập kí tự chữ");
        dienGiaTriDung();
        manHinhThemMoi.nhapMaSoThue(faker.lorem().fixedString(13));
        ReportManager.captureScreenshot("sau nhập dữ liệu");
        String giaTriMaSoThueHienTai = manHinhThemMoi.layMaSoThue();
        if(!giaTriMaSoThueHienTai.isEmpty()){
            caseDung = false;
            ReportManager.logFail("FE chưa chặn nập kí tự chữ");
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
        ReportManager.startTest("Test biên > 13 kí tự cho Ma So Thue", "Ma so thue có độ daài tối đa là 13");
        dienGiaTriDung();
        manHinhThemMoi.nhapMaSoThue(faker.number().digits(14));
        ReportManager.captureScreenshot("sau nhập dữ liệu");
        String giaTriMaSoThueHienTai = manHinhThemMoi.layMaSoThue();
        if(giaTriMaSoThueHienTai.length() > 13){
            caseDung = false;
            ReportManager.logFail("FE chưa chặn số kí tự tôí đa");
        }else{
            ReportManager.logPass("Đã pass case này");
        }
        ReportManager.endTest();
        Assert.assertTrue(caseDung);

    }
    @Test
    public void nhapSoKiTuToiThieu(){
        boolean caseDung = true;
        danhSachHH.clickThemMoiButton();
        ReportManager.startTest("Test biên < 10 kí tự cho Ma So Thue", "Mã so thue có độ dài tối thiểu");
        dienGiaTriDung();
        manHinhThemMoi.nhapMaSoThue(faker.number().digits(9));
        ReportManager.captureScreenshot("sau nhập dữ liệu");
        manHinhThemMoi.nhanNutThemMoi();
        ReportManager.captureScreenshot("Màn hình sau khi nhấn nút");
        String loiFE = manHinhThemMoi.layLoiFE().toLowerCase().trim();
        if(!loiFE.equals("vui lòng nhập đúng mã số thuế")){
            caseDung = false;
            ReportManager.logFail("Fe hiển thị sai thông báo");
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
