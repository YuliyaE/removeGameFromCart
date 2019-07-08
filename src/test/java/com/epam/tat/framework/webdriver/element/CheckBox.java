package com.epam.tat.framework.webdriver.element;

import com.epam.tat.framework.webdriver.element.factory.Element;
import org.openqa.selenium.WebElement;

public class CheckBox extends AbstractElement implements Element {

    protected CheckBox(final WebElement webElement) {
        super(webElement);
    }
}
