package com.epam.tat.steam.test;

import com.epam.tat.framework.webdriver.Browser;
import com.epam.tat.framework.webdriver.listener.TestListener;
import com.epam.tat.framework.webdriver.utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

@Listeners(TestListener.class)
public abstract class BaseTest {

    private static final String PAGE_URL = "PAGE_URL";

    private final Logger LOGGER = LogManager.getLogger();
    private SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
        Browser.openStartPage(PropertyReader.getTestData(PAGE_URL));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        Browser.exit();
    }
}
