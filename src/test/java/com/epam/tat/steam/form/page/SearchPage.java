package com.epam.tat.steam.form.page;

import com.epam.tat.framework.webdriver.element.Button;
import com.epam.tat.framework.webdriver.element.TextField;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchPage extends BasePage {

    private final Logger LOGGER = LogManager.getLogger();

    @FindBy(id = "store_nav_search_term")
    private TextField searchField;

    @FindBy(id = "store_nav_search_term")
    private Button searchButton;

    public void search(final String query) {
        searchField.sendText(query);
        searchButton.click();
    }

}
