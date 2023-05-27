package com.example.clientdemo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Locale;

public class MovieClient {
    private String url = "https://api.themoviedb.org/3/movie/%s?api_key=cd46fe13f1442cfa663d94a7d3ed7e5e";
    private static String key = "cd46fe13f1442cfa663d94a7d3ed7e5e";
    private static String POST_MOVIE_URL = "https://api.themoviedb.org/3/movie?api_key=%s";
    private static String GET_MOVIE_PATH = "/movie/%s";
    private static String UPDATE_MOVIE_URL = "/update-movie/%s";
    private String baseUrl = "https://api.themoviedb.org/3";
    RestTemplate restTemplate = new RestTemplate();

    public Movie getMovie(Integer id) {
        String url2 = String.format(url, String.valueOf(id));
        Movie movie = restTemplate.getForObject(url2, Movie.class);
        return movie;

    }

    //ADD
    public String addMovie(Movie movie) {
        String postUrl = String.format(POST_MOVIE_URL, key);
        HttpEntity entity = new HttpEntity(movie);
        ResponseEntity response = restTemplate.exchange(postUrl, HttpMethod.POST, entity, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return "Movie Added Successfully";
        }
        return "Nothing";
    }

    //UPDATE
    public String updateMovie(Integer ud, String updatedTitle) {
        String updateUrl = String.format(UPDATE_MOVIE_URL, key);
        ResponseEntity response = restTemplate.exchange(updateUrl, HttpMethod.POST, HttpEntity.EMPTY, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return "Movie Added Successfully";
        }
        return "Nothing";
    }

//    // GET
//    public Movie getMovie(Movie movie){
//        String getUrl=String.format(GET_MOVIE_PATH,key);
//        HttpEntity entity= new HttpEntity(movie);
//        ResponseEntity<Movie>response= restTemplate.exchange(getUrl, HttpMethod.GET, HttpEntity.EMPTY,Movie.class);
//        return response.getBody();
//    }

//    //Other way to UPDATE
//    public String updateUrl(Integer id, String updateTitle){
//        String updateUrl= UriComponentsBuilder
//                .fromHttpUrl(baseUrl)
//                .path(String.format(UPDATE_MOVIE_URL, id))
//                .queryParam("api_key", key)
//                .build()
//                .toUriString();
//        ResponseEntity response= restTemplate.exchange(updateUrl, HttpMethod.POST, HttpEntity.EMPTY, String.class);
//        if(response.getStatusCode().is2xxSuccessful()){
//            return "Movie Added Successfully";
//        }
//        return "Nothing";
//        }


}
