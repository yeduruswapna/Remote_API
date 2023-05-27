package com.example.clientdemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.authenticator.SavedRequest;

@Getter
@Setter
public class Movie {
    private String imdb_id;
    private String original_language;
    private String original_title;
    private MovieColection belongs_to_collection;
    public Movie(){

    }

    public Movie(String imdb_id, String original_language, String original_title) {
        this.imdb_id = imdb_id;
        this.original_language = original_language;
        this.original_title = original_title;
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class MovieColection{
        private int id;
        private String name;
        private String poster_path;
        private String backdrop_path;

    }

}























