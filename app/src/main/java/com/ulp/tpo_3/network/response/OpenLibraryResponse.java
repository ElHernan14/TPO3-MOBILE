package com.ulp.tpo_3.network.response;

import java.util.List;

public class OpenLibraryResponse {

    public List<Doc> docs;

    public static class Doc {
        public String key;
        public String title;
        public List<String> author_name;
        public Integer first_publish_year;
    }
}
