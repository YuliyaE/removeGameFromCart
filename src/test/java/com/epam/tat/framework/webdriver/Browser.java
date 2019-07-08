package com.epam.tat.framework.webdriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;

public class Browser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static ThreadLocal<RemoteWebDriver> driverHolder;

    private Browser() {
    }

    private static RemoteWebDriver getNewDriver() {
        return BrowserFactory.initDriver();
    }

    public static RemoteWebDriver getDriver() {
        if (driverHolder.get() == null) {
            driverHolder.set(getNewDriver());
        }
        return driverHolder.get();
    }

    public static void exit() {
        getDriver().quit();
        driverHolder.set(null);
    }

    public static void openPage(String pageUrl) {
        getDriver().get(pageUrl);
    }

    public static void openStartPage(String pageUrl) {
        driverHolder = ThreadLocal.withInitial(() -> getNewDriver());
        getDriver().get(pageUrl);
    }

    protected static void openNewTab() {
        LOGGER.info("Open new tab");
        ((JavascriptExecutor)getDriver()).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(tabs.size() - 1));
    }

    protected static void tabSwitchPreviousTab() {
        LOGGER.info("Switch to previous tab");
        ArrayList<String> tabs = new ArrayList(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(tabs.size() - 2));
    }

    protected static void switchToDefaultContent() {
        LOGGER.info("Switch to default content");
        getDriver().switchTo().defaultContent();
    }

    protected static void switchToFrame(WebElement webElement) {
        LOGGER.info("Switch to frame " + webElement);
        getDriver().switchTo().frame(webElement);
    }

    public static void refresh() {
        getDriver().navigate().refresh();
        LOGGER.debug("Page was refreshed");
    }

    public static void scrollUp() {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollBy(0,-250)", "");
    }
}
