package com.epam.tat.framework.webdriver.element;

import com.epam.tat.framework.webdriver.element.factory.Element;
import org.openqa.selenium.WebElement;

public class Label extends AbstractElement implements Element {
    protected Label (final WebElement webElement) {
        super(webElement);
    }

}
