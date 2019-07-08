package com.epam.tat.steam.form.menu;

import com.epam.tat.framework.webdriver.element.shared.elements.ListLabel;
import com.epam.tat.steam.enums.header.Menu;
import com.epam.tat.steam.form.page.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class MainMenuForm extends BasePage {
    private final Logger LOGGER = LogManager.getLogger();
    private static final String MAIN_MENU = "//a[@class='pulldown_desktop'][contains(text(), '%s')]";
    private static final String SUB_MENU = "//a[@class='popup_menu_item'][contains(text(), '%s')]";

     public void navigate(Menu mainMenu, Menu menu) {
        LOGGER.info("Open page with main shared, choose MainMenuForm option, choose option in submenu and waitAndClickAction on it");
        new ListLabel(By.xpath(String.format(MAIN_MENU, mainMenu.getName()))).moveToElement();
        new ListLabel(By.xpath(String.format(SUB_MENU, menu.getName()))).moveToElement().clickViaAction();
    }

    public void navigate(Menu mainMenu) {
        LOGGER.info("Open page with main shared, choose MainMenuForm option, choose option in submenu and waitAndClickAction on it");
        new ListLabel(By.xpath(String.format(MAIN_MENU, mainMenu.getName()))).moveToElement().clickViaAction();
    }

}
