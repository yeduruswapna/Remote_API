package com.example.clientdemo;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
@Repository
public class MovieRepository {
    Map<String, Movie>movieData= new HashMap<>();
}
