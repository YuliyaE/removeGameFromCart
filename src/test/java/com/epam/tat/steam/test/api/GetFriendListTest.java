package com.epam.tat.steam.test.api;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GetFriendListTest extends APIBaseTest {

    private static final String URL = BASIC_URI + "/ISteamUser/GetFriendList/v0001/?key=" + KEY + "&steamid=" + STEAM_ID;

    @Test
    public void getFriendListTest() {
        Assert.assertEquals(jsonReader
                .readJsonArray(api.sendGetRequest(URL), "friendslist", "friends")
                .length(), 2);
    }

}
