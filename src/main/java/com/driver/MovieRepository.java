package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    Map<String, Movie> movieMap;
    Map<String, Director> directorMap;
    Map<String, List<String>> pairMap;

    public MovieRepository() {
        this.movieMap = new HashMap<>();
        this.directorMap = new HashMap<>();
        this.pairMap = new HashMap<>();
    }

    // 1. addMovie
    public String addMovie(Movie movie){
        String name = movie.getName();
        if(!movieMap.containsKey(name)){
            movieMap.put(name,movie);
        }
       return "Movie Added Successfully";
    }

    // 2. addDirector
    public String addDirector(Director director){
        String name = director.getName();
        if(!directorMap.containsKey(name)){
            directorMap.put(name,director);
        }
        return "Director Added Successfully";
    }

    // 3. addMovieDirectorPair
    public String addMovieDirectorPair(String movieName, String directorName){
        if(!movieMap.containsKey(movieName) || !directorMap.containsKey(directorName)){
            return "Movie or Director Not Found in the data base";
        }

        if(pairMap.containsKey(directorName)){
            pairMap.get(directorName).add(movieName);
        }else{
            List<String> ans = new ArrayList<>();
            ans.add(movieName);
            pairMap.put(directorName, ans);
        }
        return "Movie-Director Pair added successfully";
    }

    // 4.getMovieByName
    public Movie getMovieByName(String movieName){
        if(!movieMap.containsKey(movieName)){
            return null;
        }
        return movieMap.get(movieName);
    }

    // 5. getDirectorByName
    public Director getDirectorByName(String directorName){
        if(!directorMap.containsKey(directorName)){
            return null;
        }
        return directorMap.get(directorName);
    }

    // 6. getMoviesByDirectorName
    public List<String> getMoviesByDirectorName(String directorName){
        if(!directorMap.containsKey(directorName)){
            return null;
        }
        return pairMap.get(directorName);
    }

    // 7. findAllMovies
    public List<String> findAllMovies(){
        List<String> allMovies = new ArrayList<>();
        for(String name : movieMap.keySet()){
            allMovies.add(name);
        }
        return allMovies;
    }

    // 8. deleteDirectorByName
    public String deleteDirectorByName(String directorName){
        List<String> movies = pairMap.get(directorName);
        for(int i =0;i<movies.size();i++){
            if(movieMap.containsKey(movies.get(i))){
                movieMap.remove(movies.get(i));
            }
        }
        pairMap.remove(directorName);
        if(directorMap.containsKey(directorName)){
            directorMap.remove(directorName);
        }
        return "Director and its movies removed successfully";
    }

    // 9. deleteAllDirector
    public String deleteAllDirectors(){
        for(String dir : pairMap.keySet()){
            List<String> moviesList = pairMap.get(dir);
            for(String name : moviesList ){
                if(movieMap.containsKey(name)){
                    movieMap.remove(name);
                }
            }
            directorMap.remove(dir);
        }

        for(String dirName : directorMap.keySet()){
            directorMap.remove(dirName);
        }
        return "All directors and all of the their movies removed successfully";
    }

}
