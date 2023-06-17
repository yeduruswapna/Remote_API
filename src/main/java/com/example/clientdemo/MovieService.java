package com.example.clientdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private MovieClient movieClient= new MovieClient();
    @Autowired
    private MovieRepository movieRepository;


    public Movie getMovieFromMovieClient(Integer id) {

        return movieClient.getMovie(id);
    }

    public String addMovieFromMovieClient(Movie movie) {
        return movieClient.addMovie(movie);
    }

    public String updateMovieFromMovieClient(Integer id, String updatedTitle) {
        return movieClient.updateMovie(id, updatedTitle);
    }

    public String deleteMovieFromMovieClient(Integer id) {
        return movieClient.deleteMovie(id);
    }
}
