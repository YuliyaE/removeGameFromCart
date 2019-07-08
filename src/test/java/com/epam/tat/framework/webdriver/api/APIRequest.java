package com.epam.tat.framework.webdriver.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.openqa.selenium.remote.http.HttpClient.USER_AGENT;

public class APIRequest {

    private final Logger LOGGER = LogManager.getLogger();

    public JSONObject sendGetRequest(String url) {
        StringBuffer response = null;
        try {
            URL urlObject = new URL(url);
            LOGGER.info("GET request under URL: " + url);
            HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", USER_AGENT);
            LOGGER.info("Response Code :" + connection.getResponseCode());
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info("JSON text: " + response.toString());
        return new JSONObject(response.toString());
    }

}





