package com.ulp.tpo_3.modelo;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;

public class WorkResponse {
    private List<String> subjects;
    private JsonElement description;
    public String getDescription() {
        if(description == null) return "";

        if(description.isJsonPrimitive()) return description.getAsString();

        if(description.isJsonObject()) {
            JsonObject obj = description.getAsJsonObject();
            if(obj.has("value")) {
                return obj.get("value").getAsString();
            }
        }

        return "";
    }
    public String getSubjects() {
        if(subjects != null && !subjects.isEmpty()) return String.join(", ", subjects);

        return "";
    }
}
