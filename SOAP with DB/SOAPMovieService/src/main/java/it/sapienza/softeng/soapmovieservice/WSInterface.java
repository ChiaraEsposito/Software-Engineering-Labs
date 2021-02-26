/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.soapmovieservice;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author studente
 */
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@WebService
public interface WSInterface {
    
    public List<Movie> getAll() throws ClassNotFoundException, SQLException;
    
    public Director getDirector(int movieId) throws ClassNotFoundException, SQLException;
    
    public Movie getMovie(int id) throws ClassNotFoundException, SQLException;
    
}
