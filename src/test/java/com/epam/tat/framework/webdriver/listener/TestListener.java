package com.epam.tat.framework.webdriver.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.epam.tat.framework.webdriver.screenshoter.ScreenshotSaver.saveScreenshot;
import static com.epam.tat.framework.webdriver.screenshoter.ScreenshotSaver.sendScreenshotToReportPortal;

public class TestListener implements ITestListener {
    private final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onTestStart(ITestResult iTestResult) {

        LOGGER.info("Start testing");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOGGER.info("Success testing");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOGGER.error("Step failed. See screenshots.");
        saveScreenshot();
        sendScreenshotToReportPortal();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LOGGER.info("Test skipped ");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        LOGGER.info("Test finished");
    }

}

