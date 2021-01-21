/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.soapmovieservice;

/**
 *
 * @author studente
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;

@WebService(endpointInterface = "it.sapienza.softeng.soapmovieservice.WSInterface")
public class WSImpl implements WSInterface {
    
    public List<Movie> getAll() throws ClassNotFoundException, SQLException{
         
            Class.forName("org.sqlite.JDBC");
            
            String pos = "/home/studente/database";
            Connection conn
                    = DriverManager.getConnection("jdbc:sqlite:"+pos);
       
            Statement stat = conn.createStatement();
         
            //PreparedStatement stat = null;
            List<Movie> list = new ArrayList();

               //stat = conn.prepareStatement("select * from movie");

            ResultSet rs = stat.executeQuery("select * from movie");

            while (rs.next()) {
                MovieImpl m = new MovieImpl();

                m.setId(Integer.parseInt(rs.getString("id")));
                m.setTitle(rs.getString("title"));
                m.setYear(rs.getString("year"));
                m.setDirectorId(rs.getString("directorId"));

                list.add(m);
                Logger.getLogger(WSImpl.class.getName()).log(Level.INFO, "Accessed : " + m);
            }
            rs.close();


            return list;   }

    
   
    public Director getDirector(int id) throws ClassNotFoundException, SQLException{
        String pos = "/home/studente/database" ;
        Connection conn = DriverManager.getConnection("jdbc:sqlite:"+pos);
        
        PreparedStatement stat = null;
        DirectorImpl dr = null;
        stat = conn.prepareStatement("select * from director where id = ?");
        
        stat.setString(1, String.valueOf(id));//the id was a String
        
        ResultSet rs = stat.executeQuery();
        if (rs.next()) {
            dr = new DirectorImpl();
            dr.setId(Integer.parseInt(rs.getString("id")));
            dr.setName(rs.getString("name"));
            dr.setBirth(rs.getString("year"));
            Logger.getLogger(WSImpl.class.getName()).log(Level.INFO, "Accessed : " + dr);
        }
        rs.close();
        
     
        return dr;   
        
    }
    
    public Movie getMovie(int id) throws ClassNotFoundException, SQLException{
        
        String pos = "/home/studente/database" ;
        Connection conn = DriverManager.getConnection("jdbc:sqlite:"+pos);
        
        PreparedStatement stat = null;
        MovieImpl mv = null;
       
            stat = conn.prepareStatement("select * from movie where id = ?");
            stat.setString(1, String.valueOf(id));//the id was a String
        
        ResultSet rs = stat.executeQuery();
        if (rs.next()) {
            mv = new MovieImpl();
            mv.setId(Integer.parseInt(rs.getString("id")));
            mv.setTitle(rs.getString("title"));
            mv.setYear(rs.getString("year"));
            mv.setDirectorId(rs.getString("directorId"));
            Logger.getLogger(WSImpl.class.getName()).log(Level.INFO, "Accessed : " + mv);
        }
        
        rs.close();
        
     
        return mv;   
    
    }
    
}
