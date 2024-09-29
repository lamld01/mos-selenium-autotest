package com.lazerycode.selenium.utils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {
  public static String encodeLocator(String locator) {
    try {
      return URLEncoder.encode(locator, StandardCharsets.UTF_8);
    } catch (Exception e) {
      return locator;  // Return the original if encoding fails
    }
  }

  public static String getTimeStamp() {
    return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
  }
}
