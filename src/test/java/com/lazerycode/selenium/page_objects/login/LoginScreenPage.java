package com.lazerycode.selenium.page_objects.login;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.page_objects.GoogleHomePage;
import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.lazerycode.selenium.util.AssignDriver.initQueryObjects;

public class LoginScreenPage {
  private final Query usernameInput = new Query().defaultLocator(By.name("username"));
  private final Query passwordInput = new Query().defaultLocator(By.name("password"));
  private final Query loginButton = new Query().defaultLocator(By.xpath("//button[text()='Đăng nhập']"));
  private final WebDriverWait wait;

  public LoginScreenPage() throws Exception {
    initQueryObjects(this, DriverBase.getDriver());
    this.wait = new WebDriverWait(DriverBase.getDriver(), Duration.ofSeconds(15), Duration.ofMillis(5000));
  }

  public LoginScreenPage enterUsernameInput(String username) {
    wait.until(ExpectedConditions.presenceOfElementLocated(usernameInput.by()));
    usernameInput.findWebElement().clear();
    usernameInput.findWebElement().sendKeys(username);
    try {
      // Thời gian chờ giữa các lần nhập (1 giây)
      Thread.sleep(1000); // Thay đổi giá trị này nếu cần
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return this;
  }

  public LoginScreenPage enterPasswordInput(String password) {
    wait.until(ExpectedConditions.presenceOfElementLocated(passwordInput.by()));
    passwordInput.findWebElement().clear();
    passwordInput.findWebElement().sendKeys(password);
    try {
      // Thời gian chờ giữa các lần nhập (1 giây)
      Thread.sleep(1000); // Thay đổi giá trị này nếu cần
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return this;
  }

  public LoginScreenPage clickLoginButton() {
    loginButton.findWebElement().click();
    try {
      // Thời gian chờ giữa các lần nhập (1 giây)
      Thread.sleep(3000); // Thay đổi giá trị này nếu cần
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return this;
  }
}
