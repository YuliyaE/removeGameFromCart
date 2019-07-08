package com.epam.tat.framework.webdriver.commonfunction;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {

    public static String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "uuuu-MM-dd_HH-mm");
        return ZonedDateTime.now().format(formatter);
    }
}
