package com.epam.tat.framework.webdriver;

import com.epam.tat.framework.webdriver.utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserFactory {
    private static final Logger LOGGER = LogManager.getLogger();
    private static RemoteWebDriver driver;
    private static final String REMOTE_WEBDRIVER_PAGE_URL = "REMOTE_WEBDRIVER_PAGE_URL";
    private static final String BROWSER = "BROWSER";
    private static String remoteWebDriverURL = PropertyReader.getTestData(REMOTE_WEBDRIVER_PAGE_URL);
    private final static String EDGE = "edge";
    private final static String CHROME = "chrome";
    private final static String FIREFOX = "firefox";
    private static final String MACHINE = "MACHINE";

    public static RemoteWebDriver initDriver() {
        if (driver == null) {
            switch (getBrowserName()) {
                case EDGE: {
                    WebDriverManager.edgedriver().setup();
                    if (getConfigProperty().equals("remote")) {
                        getRemoteMachine(getEdgeCapabilities());
                    } else driver = new EdgeDriver(getEdgeCapabilities());
                    LOGGER.info("Set up webdriver for Edge");
                    break;
                }
                case FIREFOX: {
                    WebDriverManager.firefoxdriver().setup();
                    if (getConfigProperty().equals("remote")) {
                        getRemoteMachine(getFirefoxCapabilities());
                    } else driver = new FirefoxDriver(getFirefoxCapabilities());
                    LOGGER.info("Set up webdriver for Firefox");
                    break;
                }
                case CHROME: {
                    WebDriverManager.chromedriver().setup();
                    if (getConfigProperty().equals("remote")) {
                        getRemoteMachine(getChromeCapabilities());
                    } else driver = new ChromeDriver(getChromeCapabilities());
                    LOGGER.info("Set up webdriver for Chrome");
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    private static void getRemoteMachine(MutableCapabilities capabilities) {
        try {
            driver = new RemoteWebDriver(new URL(remoteWebDriverURL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static String getConfigProperty() {
        String machine = null;
        try {
            if (!(System.getProperty("machine").equals(null))) {
                machine = System.getProperty("machine");
            }
            return machine;
        } catch (NullPointerException e) {
            machine = PropertyReader.getTestData(MACHINE);
            return machine;
        }
    }

    private static String getBrowserName() {
        String browser = null;
        try {
            if (!(System.getProperty("browser").equals(null))) {
                browser = System.getProperty("browser");
            }
            return browser;
        } catch (NullPointerException e) {
            browser = PropertyReader.getTestData(BROWSER);
            return browser;
        }
    }

    private static ChromeOptions getChromeCapabilities() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        ChromeOptions options = new ChromeOptions();
        options.setCapability("platformName", Platform.WINDOWS);
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        //options.headers = {host: 'localhost'};
        //options.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);

//        Proxy proxy = new Proxy();
//        proxy.setHttpProxy("10.6.103.12:4444");
//        options.setCapability("proxy", proxy);
//        options.addArguments("--proxy-server=http://" + proxy);
//        options.addArguments("--remote-debugging-port=4444");
//        options.addArguments("--user-data-dir=remote-profile");

        return options;
    }

    private static EdgeOptions getEdgeCapabilities() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability("platformName", Platform.WINDOWS);
        return edgeOptions;
    }

    private static FirefoxOptions getFirefoxCapabilities() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("platformName", Platform.WINDOWS);
        return firefoxOptions;
    }
}

