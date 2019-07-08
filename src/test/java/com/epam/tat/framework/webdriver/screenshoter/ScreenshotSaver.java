package com.epam.tat.framework.webdriver.screenshoter;

import com.epam.reportportal.message.ReportPortalMessage;
import com.epam.reportportal.service.ReportPortal;
import com.epam.tat.framework.webdriver.Browser;
import com.epam.tat.framework.webdriver.commonfunction.DateAndTime;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class ScreenshotSaver {

    private static Logger LOGGER;
    private static final String SCREENSHOT_PATH = ".//target/screenshots/" + DateAndTime.getCurrentTimeAsString() + ".png";
    private static final String REPORT_PORTAL_MESSAGE = "Test failed";

    public static File saveScreenshot() {
        File screenCapture = ((TakesScreenshot) Browser.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(SCREENSHOT_PATH));
        } catch (IOException e) {
            LOGGER.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
        return screenCapture;
    }

    public static void sendScreenshotToReportPortal() {
        try {
            ReportPortalMessage message = new ReportPortalMessage(saveScreenshot(), REPORT_PORTAL_MESSAGE);
            ReportPortal.emitLog(message, "ERROR", Calendar.getInstance().getTime());
        } catch (IOException e) {
            LOGGER.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

}
