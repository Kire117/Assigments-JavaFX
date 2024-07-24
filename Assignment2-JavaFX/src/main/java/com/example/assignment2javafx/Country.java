package com.example.assignment2javafx;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;

public class Country {
    @SerializedName("name")
    private Name name;
    @SerializedName("population")
    private long population;
    @SerializedName("region")
    private String region;

    public String getName() {
        return name.common;
    }

    public long getPopulation() {
        return population;
    }

    public String getRegion() {
        return region;
    }

    public static Country[] fromJson(String json) {
        Gson gson = new Gson();
        JsonElement jsonElement = JsonParser.parseString(json);
        if (jsonElement.isJsonArray()) {
            return gson.fromJson(jsonElement, Country[].class);
        } else {
            Country country = gson.fromJson(jsonElement, Country.class);
            return new Country[]{country};
        }
    }

    public static class Name {
        @SerializedName("common")
        private String common;
    }
}
