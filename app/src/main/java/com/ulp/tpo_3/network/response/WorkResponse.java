package com.ulp.tpo_3.network.response;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;

public class WorkResponse {
    private List<String> subjects;
    private JsonElement description;

    public List<String> getSubjects() {
        return subjects;
    }

    public String getDescription() {
        if(description == null) return null;

        if(description.isJsonPrimitive()) return description.getAsString();

        if(description.isJsonObject()) {
            JsonObject obj = description.getAsJsonObject();
            if(obj.has("value")) {
                return obj.get("value").getAsString();
            }
        }

        return null;
    }
}
