package com.example.clientdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping("/get-movie")
    public Movie getMovie(@RequestParam Integer id){
        return movieService.getMovieFromMovieClient(id);
    }
}
