package com.epam.tat.steam.form.page;

import com.epam.tat.steam.enums.header.Menu;
import com.epam.tat.steam.form.menu.LanguageMenuForm;
import com.epam.tat.steam.form.menu.MainMenuForm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainPage extends BasePage {

    private final Logger LOGGER = LogManager.getLogger();
    private LanguageMenuForm languageMenuForm = new LanguageMenuForm();

    public LanguageMenuForm getLanguageMenuForm() {
        return languageMenuForm;
    }

//    public MainPage changeMainPageLanguage(LanguageMenu languageMenu) {
//        new LanguageMenuForm().changePageLanguage(languageMenu);
//        return this;
//    }

    public GamePage navigateToGames(Menu mainMenu) {
        new MainMenuForm().navigate(mainMenu);
        return new GamePage();
    }

}
