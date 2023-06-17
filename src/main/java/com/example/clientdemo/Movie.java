package com.example.clientdemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private String imdb_id;
    private String original_language;
    private String original_title;
    private MovieCollection belongs_to_collection;
    public class MovieCollection {
        private int id;
        private String name;
        private String poster_path;
        private String backdrop_path;
    }
}