package com.epam.tat.framework.webdriver.api;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonReader {

    public JSONArray readJsonArray(JSONObject jsonObject, String jsonObjectName, String jsonVariable) {
        return (JSONArray) jsonObject.getJSONObject(jsonObjectName).get(jsonVariable);

    }

    public JSONObject readJson(JSONObject jsonObject, String jsonObjectName) {
        return jsonObject.getJSONObject(jsonObjectName);
    }

}
