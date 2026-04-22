package com.ulp.tpo_3.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OpenLibraryResponse {
    public int num_found;
    public int start;
    public String titleSearch = "";
    public ArrayList<Doc> docs;
    public int getTotalPages() {
        return (num_found / 100) + 1;
    }
    public int getPageActual() {
        return (start / 100) + 1;
    }
    public static class Doc implements Serializable {
        private String key;
        public String title;
        private List<String> author_name;
        private Integer first_publish_year;

        public String getKey() {
            if(key != null && !key.isEmpty()){
                // esto deberia tener algo como: /works/OL15626917W
                return key.substring(key.lastIndexOf("/") + 1);
            }

            return "";
        }
        public String getAutores() {
            if(author_name != null && !author_name.isEmpty()) return String.join(" ", author_name);

            return "";
        }
        public String getStringFirstPublishYear() {
            if(first_publish_year != null) return String.valueOf(first_publish_year);

            return "";
        }
    }
}
