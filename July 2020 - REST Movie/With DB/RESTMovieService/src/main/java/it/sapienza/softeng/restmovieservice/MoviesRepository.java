/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.restmovieservice;

/**
 *
 * @author studente
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.*;
import java.util.List;
import java.util.ArrayList;

@Path("/movies")
public class MoviesRepository {
    
    private Connection conn;
    
    public void setConnection(String pos) {
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MoviesRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn
                    = DriverManager.getConnection("jdbc:sqlite:"+pos);
        } catch (SQLException ex) {
            Logger.getLogger(MoviesRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @GET
    @Path("{movieId}")
    @Produces("application/json")

    public Movie getMovie(@PathParam("movieId") int movieId) {

        return findMovieById(movieId);
    }
    
    @GET
    @Path("{movieId}/director")
    @Produces("application/json")

    public Director getDirector(@PathParam("movieId") int movieId) {

        return findDirectorById(Integer.parseInt(findMovieById(movieId).getDirectorId()));
    }
    
    @GET
    @Path("/all")
    @Produces("application/json")

    public List<Movie> getAll() {

        return findAll();
    }
    
   

    private Movie findMovieById(int id) {
        
        PreparedStatement stat = null;
        Movie mv = null;
        try {
            stat = conn.prepareStatement("select * from movie where id = ?");
            stat.setString(1, String.valueOf(id));//the id was a String
        
        ResultSet rs = stat.executeQuery();
        if (rs.next()) {
            mv = new Movie();
            mv.setId(Integer.parseInt(rs.getString("id")));
            mv.setTitle(rs.getString("title"));
            mv.setYear(rs.getString("year"));
            mv.setDirectorId(rs.getString("directorId"));
            Logger.getLogger(MoviesRepository.class.getName()).log(Level.INFO, "Accessed : " + mv);
        }
        rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MoviesRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        return mv;   
    }
    
        private Director findDirectorById(int id) {
        
        PreparedStatement stat = null;
        Director dr = null;
        try {
            stat = conn.prepareStatement("select * from director where id = ?");
            stat.setString(1, String.valueOf(id));//the id was a String
        
        ResultSet rs = stat.executeQuery();
        if (rs.next()) {
            dr = new Director();
            dr.setId(Integer.parseInt(rs.getString("id")));
            dr.setName(rs.getString("name"));
            dr.setBirth(rs.getString("year"));
            Logger.getLogger(MoviesRepository.class.getName()).log(Level.INFO, "Accessed : " + dr);
        }
        rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MoviesRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        return dr;   
    }
    
        private List<Movie> findAll() {
            
        PreparedStatement stat = null;
        List<Movie> list = new ArrayList();
        try {
            stat = conn.prepareStatement("select * from movie");
        
        ResultSet rs = stat.executeQuery();
        
        while (rs.next()) {
            Movie m = new Movie();
            
            m.setId(Integer.parseInt(rs.getString("id")));
            m.setTitle(rs.getString("title"));
            m.setYear(rs.getString("year"));
            m.setDirectorId(rs.getString("directorId"));
                        
            list.add(m);
            Logger.getLogger(MoviesRepository.class.getName()).log(Level.INFO, "Accessed : " + m);
        }
        rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MoviesRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        return list;   }
    
}
