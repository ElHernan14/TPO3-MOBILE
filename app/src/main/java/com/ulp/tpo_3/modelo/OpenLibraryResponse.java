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
            if(key == null) return null;

            if(key.contains("works")) {
                return key.substring(key.lastIndexOf("/") + 1);
            }

            return key;
        }
        public String getAutores() {
            if(author_name == null) return "";
            if(author_name.isEmpty()) return "";
            return String.join(" ", author_name);
        }
        public int getIntFirstPublishYear() {
            if(first_publish_year == null) return 0;
            return first_publish_year;
        }
        public String getStringFirstPublishYear() {
            if(first_publish_year == null) return "";
            return String.valueOf(first_publish_year);
        }
    }
}
