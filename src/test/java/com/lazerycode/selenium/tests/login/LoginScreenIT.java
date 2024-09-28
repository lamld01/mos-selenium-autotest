package com.lazerycode.selenium.tests.login;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.config.RecordVideo;
import com.lazerycode.selenium.config.ReportManager;
import com.lazerycode.selenium.page_objects.booking.ListBookingPage;
import com.lazerycode.selenium.page_objects.login.LoginScreenPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginScreenIT extends DriverBase {

  @Test
  public void loginTest() throws Exception {
    String username = "agencytest@gmail.com";
    String password = "123456";
    RecordVideo.startRecord("Test login");
    ReportManager.startTest("Login test", "Login to dev-smartgate.wiinvent.tv");
    // Create a new WebDriver instance
    // Notice that the remainder of the code relies on the interface, not the implementation.
    WebDriver driver = getDriver();
    driver.get("https://dev-smartgate.wiinvent.tv/auth/login");

    LoginScreenPage loginScreenPage = new LoginScreenPage();
    loginScreenPage.enterUsernameInput(username);
    loginScreenPage.enterPasswordInput(password);

    String usernameInput = loginScreenPage.getUsernameInput();
    ReportManager.logInfo("Nhap username: " + usernameInput);
    String passwordInput = loginScreenPage.getPasswordInput();
    ReportManager.logInfo("Nhap password: " + passwordInput);
    if(Objects.equals(usernameInput, username)){
      ReportManager.logPass("Nhap dung username: " + username);
    }
    if (Objects.equals(passwordInput, password)) {
      ReportManager.logPass("Nhap dung password: " + password);
    }

    ListBookingPage listBookingPage = new ListBookingPage();
    loginScreenPage.clickLoginButton();
    RecordVideo.stopRecord();

    assertThat(listBookingPage.pageUrlContain("danhsachtokhai")).isTrue();
  }

}
