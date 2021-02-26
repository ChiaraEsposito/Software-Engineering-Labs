/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.rest.movie.nodb.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.*;

/**
 *
 * @author studente
 */
@Path("/movies")
@Produces("text/xml")
public class MoviesRepositoryNodb {
    
    private Map<Integer, MovieNodb> movies = new HashMap<>();
    List<DirectorNodb> directors = new ArrayList<>();

    {//this is create static in order to be unique
        MovieNodb m1 = new MovieNodb();
        MovieNodb m2 = new MovieNodb();
        m1.setId(1);
        m1.setTitle("Hello 1");
        m1.setYear("1999");
        m1.setDirectorId("1");
        m2.setId(2);
        m2.setTitle("Prova");
        m2.setYear("2007");
        m2.setDirectorId("2");

        movies.put(1, m1);
        movies.put(2, m2);

        DirectorNodb d1 = new DirectorNodb();
        DirectorNodb d2 = new DirectorNodb();
        d1.setId(1);
        d1.setName("Chiara");
        d1.setBirth("1954");
        d2.setId(2);
        d2.setName("Matteo");
        d2.setBirth("1957");

        
        directors.add(d1);
        directors.add(d2);
    }
    
    @GET
    @Path("{movieId}")
    public MovieNodb getMovie(@PathParam("movieId") int movieId) {

        return findMovieById(movieId);
    }
    
    @GET
    @Path("{movieId}/director")
    public DirectorNodb getDirector(@PathParam("movieId") int movieId) {
        return findDirectorById(Integer.parseInt(findMovieById(movieId).getDirectorId()));
       
    }
    
    @GET
    @Path("/all")
    public MovieList getAll() {
        return findAll();
       
    }
    
    /*
    @GET
    @Path("/all")
    public void getAll() {
        List<MovieNodb> lista = new ArrayList<>();
        lista = findAll();
        DirectorNodb d = new DirectorNodb();
        for (MovieNodb movie : lista){
            d = findDirectorById(Integer.parseInt(movie.getDirectorId()));
               
        }
    }*/
        
    
    
    private MovieList findAll() {
        MovieList lista = new MovieList();
        List<MovieNodb> list = new ArrayList<>();
        
        for (Map.Entry<Integer, MovieNodb> movie : movies.entrySet()) {
            
                list.add(movie.getValue());
            }
        lista.setMovies(list);
        //System.out.println(lista);
        
        return lista;
      
        
    }
    
    private MovieNodb findMovieById(int id) {
        
        for (Map.Entry<Integer, MovieNodb> movie : movies.entrySet()) {
            if (movie.getKey() == id) {
                return movie.getValue();
            }
        }
        return null;
    }
    
        private DirectorNodb findDirectorById(int id) {
        
        for (DirectorNodb director : directors) {
            if (director.getId() == id) {
                return director;
            }
        }
        return null;
    }
    
    
}
