package com.epam.tat.framework.webdriver.element.shared.elements;

import com.epam.tat.framework.webdriver.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BaseAbstractElement {

    private final Logger logger = LogManager.getLogger();
    private static final int WAIT_TIME_SECONDS = 10;
    private List<WebElement> webElements;
    private WebElement webElement;
    private By locator;

    public BaseAbstractElement(By locator) {
        this.locator = locator;
        webElements = Browser.getDriver().findElements(getLocator());
    }

    public Actions getActions() {
        return BaseAbstractElement.ActionsHolder.instance;
    }

    private static class ActionsHolder {
        private static final Actions instance = new Actions(Browser.getDriver());
    }

    public By getLocator() {
        return locator;
    }

    private WebElement getWebElement() {
        webElement = Browser.getDriver().findElement(locator);
        return webElement;
    }

    public BaseAbstractElement moveToElement() {
        logger.info("Move to element in main " + getWebElement());
        getActions().moveToElement(getWebElement()).perform();
        return this;
    }

    public WebElement getElementFromList(int number) {
        return webElements.get(number);
    }

    public List<WebElement> getWebElements() {
        return webElements;
    }

    public void click(int number) {
        logger.info("Wait until shared " + webElements + " to be clickable and waitAndClickAction");
        waitUntilVisibilityOfAllElements(webElements).get(number).click();
    }

    public void clickViaAction() {
        logger.info("Wait until element " + webElement + " to be clickable and waitAndClickAction");
        waitUntilClickable(webElement).click();
    }

    public String getFieldText(int number, By locator) {
        logger.info("Get text from element " + webElements.get(number));
        return webElements.get(number).findElements(locator).get(number).getText();
    }

    public String getAttribute(int number, By locator, String attribute) {
        logger.info("Get attribute " + attribute + " from element " + webElements.get(number));
        return webElements.get(number).findElements(locator).get(number).getAttribute(attribute);
    }

    private List<WebElement> waitUntilVisibilityOfAllElements(List<WebElement> webElements) {
        return new WebDriverWait(Browser.getDriver(), WAIT_TIME_SECONDS)
                .until(ExpectedConditions.visibilityOfAllElements(webElements));
    }

    protected WebElement waitUntilClickable(WebElement webElement) {
        return new WebDriverWait(Browser.getDriver(), WAIT_TIME_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

}
