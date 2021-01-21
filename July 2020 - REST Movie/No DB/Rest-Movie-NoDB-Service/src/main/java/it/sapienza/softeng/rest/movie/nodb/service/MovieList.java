/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.rest.movie.nodb.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author studente
 */
@XmlRootElement(name = "MovieList")
public class MovieList {
    
    private List<MovieNodb> movies;
    
    public List<MovieNodb> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieNodb> movies) {
        this.movies = movies;
    }
    
    public void MovieList() {
        this.movies = new ArrayList<>();
    }
    
    public void MovieList(List<MovieNodb> movies) {
        this.movies = movies;
    }
    
    @Override
    public String toString() {
        return movies.toString();
    }
    
}
