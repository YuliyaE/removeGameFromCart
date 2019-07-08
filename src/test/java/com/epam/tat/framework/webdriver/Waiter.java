package com.epam.tat.framework.webdriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class Waiter {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final int WAIT_TIME_SECONDS = 10;

    public static void waitUntilSwitch(String webElement) {
        LOGGER.info("Wait frame " + webElement + " and switch to it");
        new WebDriverWait(Browser.getDriver(), WAIT_TIME_SECONDS).
                until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(webElement));
    }

    public static void waitForPagerLoad() {
        new WebDriverWait(Browser.getDriver(), 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }


    public static void waitForJQuery() {
        (new WebDriverWait(Browser.getDriver(), 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                return (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
            }
        });
    }
}
