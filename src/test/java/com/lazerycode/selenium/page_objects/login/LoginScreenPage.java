package com.lazerycode.selenium.page_objects.login;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.page_objects.BasePage;
import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.lazerycode.selenium.util.AssignDriver.initQueryObjects;

public class LoginScreenPage extends BasePage {
  private final Query usernameInput = new Query().defaultLocator(By.name("username"));
  private final Query passwordInput = new Query().defaultLocator(By.name("password"));
  private final Query loginButton = new Query().defaultLocator(By.xpath("//button[text()='Đăng nhập']"));
  private final WebDriverWait wait;

  public LoginScreenPage() throws Exception {
    initQueryObjects(this, DriverBase.getDriver());
    this.wait = new WebDriverWait(DriverBase.getDriver(), Duration.ofSeconds(15), Duration.ofMillis(5000));
  }

  public void enterUsernameInput(String username) {
    wait.until(ExpectedConditions.presenceOfElementLocated(usernameInput.by()));
    usernameInput.findWebElement().clear();
    usernameInput.findWebElement().sendKeys(username);
    waitAction();
  }

  public String getUsernameInput() {
    wait.until(ExpectedConditions.presenceOfElementLocated(usernameInput.by()));
    return getValue(usernameInput.findWebElement());
  }

  public void enterPasswordInput(String password) {
    wait.until(ExpectedConditions.presenceOfElementLocated(passwordInput.by()));
    passwordInput.findWebElement().clear();
    passwordInput.findWebElement().sendKeys(password);
    waitAction();
  }

  public String getPasswordInput() {
    wait.until(ExpectedConditions.presenceOfElementLocated(passwordInput.by()));
    return getValue(passwordInput.findWebElement());
  }

  public void clickLoginButton() {
    wait.until(ExpectedConditions.presenceOfElementLocated(loginButton.by()));
    loginButton.findWebElement().click();
    waitAction();
  }

}
