package com.example.clientdemo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.*;

public class MovieClient {
    private static String url = "https://api.themoviedb.org/3/movie/%s?api_key=cd46fe13f1442cfa663d94a7d3ed7e5e";
    private static String baseUrl = "https://api.themoviedb.org/3/";
    private static String key = "cd46fe13f1442cfa663d94a7d3ed7e5e";
    private static String POST_MOVIE_URL = "/name/%s";
    private static String GET_MOVIE_PATH = "/get-movie/%s";
    private static String UPDATE_MOVIE_PATH = "update-movie/%s";
    private static String DELETE_MOVIE_PATH = "delete-movie/%s";

    RestTemplate restTemplate = new RestTemplate();


    //    public Movie getMovie(Integer id) {
//        String getUrl= String.format(url, String.valueOf(id));
//        Movie movie= restTemplate.getForObject(getUrl, Movie.class);
//        return movie;
//    }
    public Movie getMovie(Integer id) {
        String getUrl = String.format(url, String.valueOf(id));
        ResponseEntity<Movie> responseEntity = restTemplate.exchange(getUrl, HttpMethod.GET, HttpEntity.EMPTY, Movie.class);
        return responseEntity.getBody();
    }

    public String addMovie(Movie movie) {
        String addUrl = String.format(POST_MOVIE_URL, key);
        HttpEntity entity = new HttpEntity<>(movie);
        ResponseEntity responseEntity = restTemplate.exchange(addUrl, HttpMethod.POST, entity, String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return "Movie Added Successfully";
        }
        return "Nothing";
    }

    public String updateMovie(Integer id, String updatedTitle) {
        String updateUrl= String.format(UPDATE_MOVIE_PATH,key);
        ResponseEntity responseEntity=restTemplate.exchange(updateUrl, HttpMethod.PUT, HttpEntity.EMPTY, String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()) {
            return "Movie updated Successfully";
        }
        return "Nothing";
    }

    public String deleteMovie(Integer id) {
        String deleteUrl = String.format(DELETE_MOVIE_PATH, key);
        ResponseEntity responseEntity = restTemplate.exchange(deleteUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return "Movie Deleted Successfully";
        }
        return "Nothing";
    }
}
//    Other way to update
//    public String updateMovie(Integer id, String updatedTitle) {
//
//        String updateUrl= UriComponentsBuilder
//                .fromHttpUrl(baseUrl)
//                .path(String.format(UPDATE_MOVIE_PATH, id))
//                .queryParam("api-key", key)
//                .build()
//                .toUriString();
//        ResponseEntity responseEntity=restTemplate.exchange(updateUrl, HttpMethod.PUT, HttpEntity.EMPTY, String.class);
//        if(responseEntity.getStatusCode().is2xxSuccessful()) {
//            return "Movie updated Successfully";
//        }
//        return "Nothing";
//    }
//
