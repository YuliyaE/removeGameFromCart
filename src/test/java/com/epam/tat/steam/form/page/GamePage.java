package com.epam.tat.steam.form.page;

import com.epam.tat.framework.webdriver.element.Button;
import com.epam.tat.steam.model.Game;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class GamePage extends BasePage {

    private final Logger LOGGER = LogManager.getLogger();

    private By topSellersRowsListRandom = By.id("TopSellersRows");

    //  private final By topSellersRowsList = By.id("TopSellersRows");
    private final By topSellersRowsList = By.xpath("//*[@class='tab_item   app_impression_tracked']");

    @FindBy(id = "TopSellersRows")
    private Button topSellersRows;

    @FindBy(xpath = "//*[@id='TopSellersRows']/*[@data-ds-appid='578080']")
    private Button topSellersRowsGame;

    @FindBy(xpath = "//*[@class='tab_item   app_impression_tracked']")
    private Button topSellersRowsListFindBy;

    @FindBy(id = "tab_select_TopSellers")
    private Button topSellers;

    @FindBy(xpath = "//*[@class='btn_addtocart']")
    private Button addToCart;

    @FindBy(xpath = "//*[@onclick='ViewProductPage()']/span")
    private Button viewPage;

    @FindBy(xpath = "//*[@id='TopSellersRows']/*[@data-ds-appid='578080']//div[@class='discount_final_price']")
    private Button expectedPriceField;

    @FindBy(xpath = "//*[@id='TopSellersRows']/*[@data-ds-appid='578080']//div[@class='tab_item_name']")
    private Button expectedGameName;

    @FindBy(xpath = "//*[@id='TopSellersRows']/*[@data-ds-appid='578080']//div[@class='tab_item_details']/span")
    private Button expectedPlatform;

    public Game chooseGame() {
        topSellers.click();
        //  new MenuLabel(topSellersRowsListRandom).chooseRandomGame(topSellersRowsList); //Random implementation, please check
        return getExpectedGame();
    }

    public CartPage addToCart() {
        topSellersRowsGame.click();
        // viewPage.click(); // if 18+ appears, use this line
        addToCart.click();
        return new CartPage();
    }

    private Game getExpectedGame() {
        Game game = new Game();
        game.setName(expectedGameName.getText());
        game.setPrice(expectedPriceField.getText());
        game.setPlatform(expectedPlatform.getAttribute("class"));
        return game;
    }
}
