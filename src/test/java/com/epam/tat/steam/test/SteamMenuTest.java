package com.epam.tat.steam.test;

import com.epam.tat.steam.enums.header.LanguageMenu;
import com.epam.tat.steam.enums.header.MainMenu;
import com.epam.tat.steam.enums.header.GameMenu;
import com.epam.tat.steam.form.menu.LanguageMenuForm;
import com.epam.tat.steam.form.menu.MainMenuForm;
import org.testng.annotations.Test;

public class SteamMenuTest extends BaseTest {
    @Test
    public void testHeader() {
        new LanguageMenuForm().changePageLanguage(LanguageMenu.ENGLISH);
        new MainMenuForm().navigate(MainMenu.GAMES, GameMenu.ACTION);
    }
}
