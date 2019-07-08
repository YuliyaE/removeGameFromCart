package com.epam.tat.framework.webdriver.element;

import com.epam.tat.framework.webdriver.element.factory.Element;
import org.openqa.selenium.WebElement;

public class Button extends AbstractElement implements Element {

    protected Button(final WebElement webElement) {
        super(webElement);
    }

}
