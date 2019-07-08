package com.epam.tat.steam.form.page;

import com.epam.tat.framework.webdriver.element.Button;
import com.epam.tat.framework.webdriver.element.TextField;
import com.epam.tat.steam.model.Game;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//*[@class='pageheader']")
    private TextField pageHeader;

    @FindBy(xpath = "//*[@class='cart_item_desc']/a")
    private Button currentGameName;

    @FindBy(xpath = "//*[@class='cart_item_desc']/span")
    private Button availableFrom;

    @FindBy(xpath ="//*[@class='cart_item_price_container']/div/*[@class='price']") //"//*[@class='cart_item_price ']/div"
    private Button currentPriceField;

    @FindBy(xpath = "//*[@class='cart_item_platform']/span")
    private Button currentPlatform;

    public String getPageHeader() {
        return pageHeader.getText();
    }

    public Game getGameData() {
        Game game = new Game();
        game.setPrice(currentPriceField.getText());
        game.setName(currentGameName.getText());
        game.setPlatform(currentPlatform.getAttribute("class"));
        return game;
    }
}
