package com.epam.tat.framework.webdriver.commonfunction;

import com.epam.tat.framework.webdriver.utils.PropertyReader;
import com.epam.tat.framework.webdriver.utils.UTF8Control;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationDataProvider {

    private static Locale locale = Locale.getDefault();
    public static final String MAIN_MENU_LABEL_LOCALIZATION = "mainMenuLabelLocalization";

    public static String getResourceBundle(String key) {
        locale = new Locale(PropertyReader.getTestData("LANGUAGE"));
        return ResourceBundle.getBundle
                (MAIN_MENU_LABEL_LOCALIZATION, locale, new UTF8Control()).getString(key);
    }
}

