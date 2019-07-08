package com.epam.tat.steam.test.api;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GetPlayersSummariesTest extends APIBaseTest {

    private static final String URL = BASIC_URI + "/ISteamUser/GetPlayerSummaries/v0002/?key=" + KEY + "&steamids=" + STEAM_ID;

    @Test
    public void getPlayersSummariesTest() {
        Assert.assertEquals(jsonReader
                .readJsonArray(api.sendGetRequest(URL), "response", "players")
                .getJSONObject(0)
                .get("communityvisibilitystate"), 3);
    }

    @Test
    public void getPersonName() {
        Assert.assertEquals(jsonReader
                .readJsonArray(api.sendGetRequest(URL), "response", "players")
                .getJSONObject(0)
                .get("personaname"), "EugeneTat");
    }

}
