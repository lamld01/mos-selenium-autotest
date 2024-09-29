package com.lazerycode.selenium.page_objects.doanhNghiepHangHoa;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.config.ReportManager;
import com.lazerycode.selenium.page_objects.BasePage;
import com.lazerycode.selenium.page_objects.vehice.base.VehicleDriver;
import com.lazerycode.selenium.util.Query;
import com.lazerycode.selenium.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.lazerycode.selenium.util.AssignDriver.initQueryObjects;

public class DanhSachHH extends BasePage {

  public static final String PAGE_URL = Constants.SMARTGATE_WIINVENT_TV + "/doanhnghiephanghoa";
  private final Query errorMessage = new Query().defaultLocator(By.xpath("//p[contains(@class, 'text-xs') and contains(@class, 'text-red-600') and contains(@class, 'mt-0')]"));
  private final Query errorBackendMessage = new Query().defaultLocator(By.xpath("//div[contains(@class, 'Toastify__toast') and contains(@class, 'Toastify__toast-theme--light')]"));
  private final Query themMoiBtn = new Query().defaultLocator(By.xpath("/html/body/div[1]/div[1]/div[2]/main/div/div/div[1]/button"));
  private final WebDriverWait wait;


  public DanhSachHH() throws Exception {
    initQueryObjects(this, DriverBase.getDriver());
    this.wait = new WebDriverWait(DriverBase.getDriver(), Duration.ofSeconds(15), Duration.ofMillis(5000));
  }
  public void clickThemMoiButton(){
    wait.until(ExpectedConditions.presenceOfElementLocated(themMoiBtn.by()));
    themMoiBtn.findWebElement().click();
  }

}
