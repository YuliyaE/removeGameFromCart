package com.epam.tat.steam.test;

import com.epam.tat.steam.form.page.SearchPage;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test()
    public void testSearch() {
        new SearchPage().search("Bolek i Lolek");
    }
}
