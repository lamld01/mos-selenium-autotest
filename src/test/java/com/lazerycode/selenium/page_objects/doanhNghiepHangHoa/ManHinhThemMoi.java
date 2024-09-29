package com.lazerycode.selenium.page_objects.doanhNghiepHangHoa;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.page_objects.BasePage;
import com.lazerycode.selenium.util.Query;
import com.lazerycode.selenium.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.lazerycode.selenium.util.AssignDriver.initQueryObjects;

public class ManHinhThemMoi extends BasePage {
    private final String URL_PAGE = Constants.SMARTGATE_WIINVENT_TV + "/doanhnghiephanghoa";
    protected final Query loiFE = new Query().defaultLocator(By.xpath("//p[contains(@class, 'text-xs') and contains(@class, 'text-red-600') and contains(@class, 'mt-0')]"));
    protected final Query loiBE = new Query().defaultLocator(By.xpath("//div[contains(@class, 'Toastify__toast') and contains(@class, 'Toastify__toast-theme--light')]"));
    private final Query oNhapMaSoThue = new Query().defaultLocator(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div/div/div/form/div[1]/div/div[1]/div/input"));
    private final Query oNhapSoDienThoai = new Query().defaultLocator(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div/div/div/form/div[1]/div/div[3]/div/input"));
    private final Query oNhapDiaChi = new Query().defaultLocator(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div/div/div/form/div[1]/div/div[4]/div/input"));
    private final Query nutBamThemMoi = new Query().defaultLocator(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div/div/div/form/div[2]/button"));
    private final Query oNhapHoTen = new Query().defaultLocator(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div/div/div/form/div[1]/div/div[2]/div/input"));
    private final WebDriverWait wait;

    public ManHinhThemMoi() throws Exception {
        initQueryObjects(this, DriverBase.getDriver());
        wait = new WebDriverWait(DriverBase.getDriver(), Duration.ofSeconds(15), Duration.ofMillis(5000));
    }

    public String layMaSoThue() {
        wait.until(ExpectedConditions.presenceOfElementLocated(oNhapMaSoThue.by()));
        return getValueFromElement(oNhapMaSoThue);

    }

    public void nhapMaSoThue(String maSoThue) {
        wait.until(ExpectedConditions.presenceOfElementLocated(oNhapMaSoThue.by()));
        inputValueToElement(oNhapMaSoThue, maSoThue);
    }
    public String layHoTen() {
        wait.until(ExpectedConditions.presenceOfElementLocated(oNhapHoTen.by()));
        return getValueFromElement(oNhapHoTen);

    }

    public void nhapHoTen(String hoTen) {
        wait.until(ExpectedConditions.presenceOfElementLocated(oNhapHoTen.by()));
        inputValueToElement(oNhapHoTen, hoTen);
    }
    public String laySoDienThoai() {
        wait.until(ExpectedConditions.presenceOfElementLocated(oNhapSoDienThoai.by()));
        return getValueFromElement(oNhapSoDienThoai);

    }
    public void nhapSoDienThoai(String sodt){
        wait.until(ExpectedConditions.presenceOfElementLocated(oNhapSoDienThoai.by()));
        inputValueToElement(oNhapSoDienThoai,sodt);
    }
    public String layDiaChi(){
        wait.until(ExpectedConditions.presenceOfElementLocated(oNhapDiaChi.by()));
        return getValueFromElement(oNhapDiaChi);
    }
    public void nhapDiaChi(String diachi){
        wait.until(ExpectedConditions.presenceOfElementLocated(oNhapDiaChi.by()));
        inputValueToElement(oNhapDiaChi,diachi);
    }
    public void nhanNutThemMoi(){
        wait.until(ExpectedConditions.presenceOfElementLocated(nutBamThemMoi.by()));
        clickElement(nutBamThemMoi);
    }
    public String layLoiFE(){
        return getValueFromElement(loiFE).toLowerCase().trim();
    }
    public String layLoiBE(){
        return getValueFromElement(loiBE);
    }



}
