package com.epam.tat.steam.enums.header;

import com.epam.tat.framework.webdriver.commonfunction.LocalizationDataProvider;

public interface Menu {
    String getName();

   default String getNameFromBundle(String name){
       return LocalizationDataProvider.getResourceBundle(name);
   }
}
