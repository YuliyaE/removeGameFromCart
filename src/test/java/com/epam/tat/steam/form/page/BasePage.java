package com.epam.tat.steam.form.page;

import com.epam.tat.framework.webdriver.Browser;
import com.epam.tat.framework.webdriver.element.factory.ExtendedFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    private final Logger LOGGER = LogManager.getLogger();

    public BasePage() {
        PageFactory.initElements(new ExtendedFieldDecorator(Browser.getDriver()), this);
    }

}
