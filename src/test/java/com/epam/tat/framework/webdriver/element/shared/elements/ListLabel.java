package com.epam.tat.framework.webdriver.element.shared.elements;

import com.epam.tat.framework.webdriver.element.factory.Element;
import org.openqa.selenium.By;

public class ListLabel extends BaseAbstractElement implements Element {
    public ListLabel(By locator) {
        super(locator);
    }

    @Override
    public void clickViaAction() {
        getActions().click().build().perform();
    }
}
