/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.dbmoviesmanager;
import java.sql.*;

/**
 *
 * @author studente
 */
public class DBMoviesManager {
    
    public static void main(String[] args) throws Exception {

        Class.forName("org.sqlite.JDBC");
        Connection conn
                = DriverManager.getConnection("jdbc:sqlite:"+args[0]);
        
        Statement stat = conn.createStatement();
        Statement statDir = conn.createStatement();
        

        if (args[1].equals("create")) {
            stat.executeUpdate("drop table if exists movie;");
            stat.executeUpdate("create table movie (id, title, year, directorId);");
            PreparedStatement prep = conn.prepareStatement(
                    "insert into movie values (?, ?, ?, ?);");
            
            prep.setString(1, "1");
            prep.setString(2, "Harry Potter e la pietra filosofale");
            prep.setString(3, "2001");
            prep.setString(4, "1");
            
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "2");
            prep.setString(2, "Harry Potter e la camera dei segreti");
            prep.setString(3, "2002");
            prep.setString(4, "1");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "3");
            prep.setString(2, "Harry Potter e il prigioniero di Azkaban");
            prep.setString(3, "2003");
            prep.setString(4, "2");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "4");
            prep.setString(2, "Harry Potter e il calice di fuoco");
            prep.setString(3, "2004");
            prep.setString(4, "2");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "5");
            prep.setString(2, "Il signore degli anelli");
            prep.setString(3, "2001");
            prep.setString(4, "3");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "6");
            prep.setString(2, "Ho finito i nomi");
            prep.setString(3, "2002");
            prep.setString(4, "4");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "7");
            prep.setString(2, "Prova");
            prep.setString(3, "2012");
            prep.setString(4, "4");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "8");
            prep.setString(2, "Big Hero 6");
            prep.setString(3, "2016");
            prep.setString(4, "5");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "9");
            prep.setString(2, "Hannah");
            prep.setString(3, "2008");
            prep.setString(4, "6");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "10");
            prep.setString(2, "Prova 2");
            prep.setString(3, "2017");
            prep.setString(4, "4");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "11");
            prep.setString(2, "Speriamo che passo");
            prep.setString(3, "2020");
            prep.setString(4, "4");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "12");
            prep.setString(2, "Non so il nome");
            prep.setString(3, "2018");
            prep.setString(4, "5");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "13");
            prep.setString(2, "Harry Potter e il principe mezzo sangue");
            prep.setString(3, "2006");
            prep.setString(4, "3");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "14");
            prep.setString(2, "Hello");
            prep.setString(3, "2019");
            prep.setString(4, "6");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "15");
            prep.setString(2, "Addio per sempre");
            prep.setString(3, "1982");
            prep.setString(4, "7");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            statDir.executeUpdate("drop table if exists director;");
            statDir.executeUpdate("create table director (id, name, year);");
            PreparedStatement prepDir = conn.prepareStatement(
                    "insert into director values (?, ?, ?);");
            
            prepDir.setString(1, "1");
            prepDir.setString(2, "Chris Columbus");
            prepDir.setString(3, "1958");
            
            prepDir.addBatch();
            conn.setAutoCommit(false);
            prepDir.executeBatch();
            conn.setAutoCommit(true);
            
            prepDir.setString(1, "2");
            prepDir.setString(2, "David Yates");
            prepDir.setString(3, "1963");
            
            prepDir.addBatch();
            conn.setAutoCommit(false);
            prepDir.executeBatch();
            conn.setAutoCommit(true);
            
            prepDir.setString(1, "3");
            prepDir.setString(2, "Peter Jackson");
            prepDir.setString(3, "1946");
            
            prepDir.addBatch();
            conn.setAutoCommit(false);
            prepDir.executeBatch();
            conn.setAutoCommit(true);
            
            prepDir.setString(1, "4");
            prepDir.setString(2, "Chiara Esposito");
            prepDir.setString(3, "1976");
            
            prepDir.addBatch();
            conn.setAutoCommit(false);
            prepDir.executeBatch();
            conn.setAutoCommit(true);
            
            prepDir.setString(1, "5");
            prepDir.setString(2, "Matteo Lucantonio");
            prepDir.setString(3, "1976");
            
            prepDir.addBatch();
            conn.setAutoCommit(false);
            prepDir.executeBatch();
            conn.setAutoCommit(true);
            
            prepDir.setString(1, "6");
            prepDir.setString(2, "Ciao ciao");
            prepDir.setString(3, "1959");
            
            prepDir.addBatch();
            conn.setAutoCommit(false);
            prepDir.executeBatch();
            conn.setAutoCommit(true);
            
            prepDir.setString(1, "7");
            prepDir.setString(2, "Prova");
            prepDir.setString(3, "1933");
            
            prepDir.addBatch();
            conn.setAutoCommit(false);
            prepDir.executeBatch();
            conn.setAutoCommit(true);
            
           
            
            
        } else {
            ResultSet rs = stat.executeQuery("select * from movie;");
            //The resultSet is the cursor over the database table
            while (rs.next()) {
                System.out.print("Movie = " + rs.getString("id") + " is : ");
                System.out.println(rs.getString("title"));
            }
            rs.close();
        }
        conn.close();
    }
    
}
