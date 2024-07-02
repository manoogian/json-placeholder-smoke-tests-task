package com.JsonPlaceholder.api;

import com.JsonPlaceholder.model.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Helper {

    public Helper() {
    }

    public JSONObject jsonReader(String path, int userId) {

        JSONParser parser = new JSONParser();

        JSONObject jsonObject = null;
        try {
            Object obj = parser.parse(new FileReader(path));

            jsonObject = (JSONObject) obj;
            jsonObject.put("userId", String.valueOf(userId));

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}

