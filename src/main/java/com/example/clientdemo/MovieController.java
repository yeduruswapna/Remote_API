package com.example.clientdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping("/get-movie")
    public Movie getMovie(@RequestParam Integer id){
        return movieService.getMovieFromMovieClient(id);
    }
    @PostMapping("/add-movie")
    public String addMovie(@RequestBody Movie movie){
        return movieService.addMovieFromMovieClient(movie);
    }

    @PutMapping("/update-movie")
    public String updateMovie(@RequestParam Integer id, String updatedTitle){
        return movieService.updateMovieFromMovieClient(id, updatedTitle);
    }

    @DeleteMapping("/delete-movie")
    public String deleteMovie(@RequestParam Integer id){
        return movieService.deleteMovieFromMovieClient(id);
    }
}

