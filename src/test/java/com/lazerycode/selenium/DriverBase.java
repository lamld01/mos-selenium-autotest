package com.lazerycode.selenium;

import com.lazerycode.selenium.config.DriverFactory;
import com.lazerycode.selenium.config.ReportManager;
import com.lazerycode.selenium.listeners.ScreenshotListener;
import com.lazerycode.selenium.page_objects.booking.manHinhDanhSachBooking.ManHinhDanhSachBooking;
import com.lazerycode.selenium.page_objects.login.LoginScreenPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.util.*;

@Listeners(ScreenshotListener.class)
public class DriverBase {
    protected static final Logger LOG = (Logger) LogManager.getLogger(DriverBase.class);
    private static final List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<>());
    private static ThreadLocal<DriverFactory> driverFactoryThread;
    private static Set<Cookie> cookies;
    private static LocalStorage storage ;
    @BeforeSuite(alwaysRun = true)
    public static void instantiateDriverObject() {
        ReportManager.setUp();
        driverFactoryThread = ThreadLocal.withInitial(() -> {
            DriverFactory driverFactory = new DriverFactory();
            webDriverThreadPool.add(driverFactory);
            return driverFactory;
        });
    }

    public static RemoteWebDriver getDriver() throws Exception {
        return driverFactoryThread.get().getDriver();
    }

    public static RemoteWebDriver getDriverLogin(String pageUrl) throws Exception {
        RemoteWebDriver driver = driverFactoryThread.get().getDriver();

        // Check if cookies are empty (to avoid re-login)
        if (cookies == null) {
            String username = "agencytest@gmail.com";
            String password = "123456";

            // Perform login
            driver.get("https://dev-smartgate.wiinvent.tv/auth/login");
            LoginScreenPage loginScreenPage = new LoginScreenPage();
            loginScreenPage.enterUsernameInput(username);
            loginScreenPage.enterPasswordInput(password);
            loginScreenPage.clickLoginButton();

            ManHinhDanhSachBooking defaultPageAfterLogin = new ManHinhDanhSachBooking();
            defaultPageAfterLogin.waitForUrl();

            // Add cookies after login
            cookies = new HashSet<>();
            cookies.addAll(driver.manage().getCookies());

            // Get local storage after login
            WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
            storage = webStorage.getLocalStorage();
        }

        // Add cookies to driver
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }

        // Set local storage to driver (if needed)
        WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
        LocalStorage localStorage = webStorage.getLocalStorage();

        // Add storage keys and values (if needed)
        for (String key : storage.keySet()) {
            localStorage.setItem(key, storage.getItem(key));
        }
        driver.navigate().to(pageUrl);
        return driver;
    }


    @AfterMethod(alwaysRun = true)
    public static void clearCookies() {
        try {
            driverFactoryThread.get().getStoredDriver().manage().deleteAllCookies();
        } catch (Exception ignored) {
            LOG.warn("Unable to clear cookies, driver object is not viable...");
        }
    }

    @AfterSuite(alwaysRun = true)
    public static void closeDriverObjects() {
        for (DriverFactory driverFactory : webDriverThreadPool) {
            driverFactory.quitDriver();
        }
        ReportManager.endTest();
    }

    public static void getAndSetDataFromLocalStorage() {
        String lang = storage.getItem("lng");
        String role = storage.getItem("role");
        String token = storage.getItem("token");
        String user = storage.getItem("user");

        storage.setItem("lng", lang);
        storage.setItem("role", role);
        storage.setItem("token", token);
        storage.setItem("user", user);
    }
}
