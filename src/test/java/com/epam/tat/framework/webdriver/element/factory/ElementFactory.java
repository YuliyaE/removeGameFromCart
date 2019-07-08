package com.epam.tat.framework.webdriver.element.factory;

import org.openqa.selenium.WebElement;

public interface ElementFactory {
    <E extends Element> E create(Class<E> elementClass, WebElement wrappedElement);

}
