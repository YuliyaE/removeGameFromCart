package com.epam.tat.framework.webdriver.element;

import com.epam.tat.framework.webdriver.element.factory.Element;
import org.openqa.selenium.WebElement;

public class DropDown extends AbstractElement implements Element {
    protected DropDown(final WebElement webElement) {
        super(webElement);
    }
}
