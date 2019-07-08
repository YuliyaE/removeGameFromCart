package com.epam.tat.steam.form.menu;

import com.epam.tat.framework.webdriver.Browser;
import com.epam.tat.framework.webdriver.Waiter;
import com.epam.tat.framework.webdriver.element.Label;
import com.epam.tat.framework.webdriver.element.shared.elements.ListLabel;
import com.epam.tat.steam.enums.header.LanguageMenu;
import com.epam.tat.steam.form.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class LanguageMenuForm extends BasePage {

    @FindBy(xpath = "//*[@id='language_pulldown']")
    private Label languageLabel;

    private static final String LANGUAGE_MENU = "//*[@class='popup_menu_item tight' ][contains(text(), '%s')]";

    public void changePageLanguage(LanguageMenu languageMenu) {
        if (!languageLabel.getText().equals(languageMenu.getLocalLanguageButtonName())) {
            languageLabel.click();
            new ListLabel(By.xpath(String.format(LANGUAGE_MENU, languageMenu.getName()))).moveToElement().clickViaAction();
            Waiter.waitForJQuery();
            Browser.getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        }
    }
}
