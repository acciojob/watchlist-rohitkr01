package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    // 1. addMovie
    public String addMovie(Movie movie) {
        return movieRepository.addMovie(movie);
    }

    // 2.addDirector
    public String addDirector(Director director) {
        return movieRepository.addDirector(director);
    }

    // 3.addMovieDirectorPair
    public String addMovieDirectorPair(String movieName, String directorName) {
        return movieRepository.addMovieDirectorPair(movieName, directorName);
    }

    // 4.getMovieByName
    public Movie getMovieByName(String movieName) {
        return movieRepository.getMovieByName(movieName);
    }

    // 5. getDirectorByName
    public Director getDirectorByName(String directorName) {
        return movieRepository.getDirectorByName(directorName);
    }

    //6.getMoviesByDirectorName
    public List<String> getMoviesByDirectorName(String directorName) {
        return movieRepository.getMoviesByDirectorName(directorName);
    }

    // 7. findAllMovies
    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    // 8. deleteDirectorByName
    public String deleteDirectorByName(String directorName){
        return movieRepository.deleteDirectorByName(directorName);
    }

    // 9. deleteAllDirector
    public String deleteAllDirectors(){
        return movieRepository.deleteAllDirectors();
    }

}
