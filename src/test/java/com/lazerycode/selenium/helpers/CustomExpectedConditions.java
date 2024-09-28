package com.lazerycode.selenium.helpers;

import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomExpectedConditions {

    static public ExpectedCondition<Boolean> pageTitleStartsWith(final String searchString) {
        return driver -> {
          assert driver != null;
          return driver.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
        };
    }

    static public ExpectedCondition<Boolean> pageUrlContain(final String router) {
        return driver -> {
          assert driver != null;
          return driver.getCurrentUrl().toLowerCase().contains(router.toLowerCase());
        };
    }
}
