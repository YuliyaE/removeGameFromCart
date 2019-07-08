package com.epam.tat.framework.webdriver.element;

import com.epam.tat.framework.webdriver.Browser;
import com.epam.tat.framework.webdriver.element.factory.Element;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractElement implements Element {

    protected WebElement webElement;
    private By locator;
    private final Logger logger = LogManager.getLogger();
    private static final int WAIT_TIME_SECONDS = 10;

    protected AbstractElement(By locator) {
        this.locator = locator;
    }

    protected AbstractElement(final WebElement webElement) {
        this.webElement = webElement;
    }

    public By getLocator() {
        return locator;
    }

    public void click() {
        logger.info("Wait until element " + webElement + " to be clickable and waitAndClickAction");
        waitUntilClickable(webElement).click();
    }

    public String getText() {
        logger.info("Get text from element " + webElement);
        return webElement.getText();
    }

    public String getAttribute(String attribute) {
        logger.info("Get attribute " + attribute + " from element " + webElement);
        return webElement.getAttribute(attribute);
    }

    private WebElement waitUntilClickable(WebElement webElement) {
        return new WebDriverWait(Browser.getDriver(), WAIT_TIME_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    private WebElement waitUntilVisibilityOfElement(WebElement webElement) {
        return new WebDriverWait(Browser.getDriver(), WAIT_TIME_SECONDS)
                .until(ExpectedConditions.visibilityOf(webElement));
    }


}
