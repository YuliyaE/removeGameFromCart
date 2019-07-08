package com.epam.tat.framework.webdriver.element;

import com.epam.tat.framework.webdriver.element.factory.Element;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class TextField extends AbstractElement implements Element {

    private final Logger LOGGER = LogManager.getLogger();

    protected TextField(final WebElement webElement) {
        super(webElement);
    }

    public void type(final String text) {
        LOGGER.info("Type text in element " + webElement);
        webElement.sendKeys(text);
    }
    
    public void clear() {
        LOGGER.info("Clear text in element " + webElement);
        webElement.clear();
    }

    public void sendText(final String text) {
        clear();
        type(text);
    }
}
