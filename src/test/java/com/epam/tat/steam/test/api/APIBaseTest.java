package com.epam.tat.steam.test.api;

import com.epam.tat.framework.webdriver.listener.TestListener;
import com.epam.tat.framework.webdriver.api.APIRequest;
import com.epam.tat.framework.webdriver.api.JsonReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class APIBaseTest {

    protected static final String KEY = "02F53CA3FA7FAE4CA562207AE5274BC9";
    protected static final String STEAM_ID = "76561198969659493";
    protected static final String BASIC_URI = "https://api.steampowered.com";
    protected APIRequest api;
    protected JsonReader jsonReader;

    @BeforeTest
    public void setUp() {
        api = new APIRequest();
        jsonReader = new JsonReader();
    }

    @AfterTest
    public void tearDown() {
        api = null;
        jsonReader = null;
    }

}
