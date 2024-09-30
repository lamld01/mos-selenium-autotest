package com.lazerycode.selenium.utils;

import com.lazerycode.selenium.config.DriverType;

public class Constants {

  public static final String SMARTGATE_WIINVENT_TV = "https://dev-smartgate.wiinvent.tv";
  public static final String DEFAULT_AFTER_LOGIN = SMARTGATE_WIINVENT_TV + "/danhsachtokhai";
  public static final int DELAY_ACTION = 2000;
  public static final int WAIT_TIME = 1000;
  public static final int PAGE_LOAD_TIMEOUT = 30;
  public static final DriverType DEFAULT_WEB_TYPE = DriverType.CHROME;
  public static final boolean RECORD_VIDEO = false;
  public static final String INPUT_EMPTY = "Vui lòng nhập dữ liệu";
}
