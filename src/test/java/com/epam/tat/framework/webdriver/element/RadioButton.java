package com.epam.tat.framework.webdriver.element;

import com.epam.tat.framework.webdriver.element.factory.Element;
import org.openqa.selenium.WebElement;

public class RadioButton extends AbstractElement implements Element {

    protected RadioButton(final WebElement webElement) {
        super(webElement);
    }
}
