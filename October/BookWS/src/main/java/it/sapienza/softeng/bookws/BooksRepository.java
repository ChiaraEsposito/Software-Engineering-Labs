/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.bookws;

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

@Path("/books")
public class BooksRepository {
    
    private Connection conn;
    
    public void setConnection(String pos) {
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BooksRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn
                    = DriverManager.getConnection("jdbc:sqlite:"+pos);
        } catch (SQLException ex) {
            Logger.getLogger(BooksRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @GET
    @Path("{bookId}")
    @Produces("application/json")

    public Book getBook(@PathParam("bookId") int bookId) {

        return findBookById(bookId);
    }
    
    @GET
    @Path("/all")
    @Produces("application/json")

    public List<Book> getAll() {

        return findAll();
    }
    
   

    private Book findBookById(int id) {
        
        PreparedStatement stat = null;
        Book b = null;
        try {
            stat = conn.prepareStatement("select * from books where id = ?");
            stat.setString(1, String.valueOf(id));//the id was a String
        
        ResultSet rs = stat.executeQuery();
        if (rs.next()) {
            b = new Book();
            b.setId(Integer.parseInt(rs.getString("id")));
            b.setTitle(rs.getString("title"));
            b.setYear(rs.getString("year"));
            b.setAuthor(rs.getString("author"));
            b.setBirth(rs.getString("birth"));
            Logger.getLogger(BooksRepository.class.getName()).log(Level.INFO, "Accessed : " + b);
        }
        rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BooksRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        return b;   
    }
    
    
        private List<Book> findAll() {
            
        PreparedStatement stat = null;
        List<Book> list = new ArrayList();
        
        try {
            stat = conn.prepareStatement("select * from books");
        
        ResultSet rs = stat.executeQuery();
        
        while (rs.next()) {
            Book b = new Book();
            
            b.setId(Integer.parseInt(rs.getString("id")));
            b.setTitle(rs.getString("title"));
            b.setYear(rs.getString("year"));
            b.setAuthor(rs.getString("author"));
            b.setBirth(rs.getString("birth"));            
            list.add(b);
            Logger.getLogger(BooksRepository.class.getName()).log(Level.INFO, "Accessed : " + b);
        }
        rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BooksRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        return list;   
        
        }
    
}
