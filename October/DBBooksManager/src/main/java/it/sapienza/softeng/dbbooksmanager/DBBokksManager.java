/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.dbbooksmanager;
import java.sql.*;

/**
 *
 * @author studente
 */
public class DBBokksManager {
    
    public static void main(String[] args) throws Exception {

        Class.forName("org.sqlite.JDBC");
        Connection conn
                = DriverManager.getConnection("jdbc:sqlite:"+args[0]);
        
        Statement stat = conn.createStatement();

        if (args[1].equals("create")) {
            stat.executeUpdate("drop table if exists books;");
            stat.executeUpdate("create table books (id, title, year, author, birth);");
            PreparedStatement prep = conn.prepareStatement(
                    "insert into books values (?, ?, ?, ?, ?);");
            
            prep.setString(1, "1");
            prep.setString(2, "Harry Potter e la pietra filosofale");
            prep.setString(3, "2001");
            prep.setString(4, "Chris Columbus");
            prep.setString(5, "1958");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "2");
            prep.setString(2, "Harry Potter e la camera dei segreti");
            prep.setString(3, "2002");
            prep.setString(4, "Chris Columbus");
            prep.setString(5, "1958");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "3");
            prep.setString(2, "Harry Potter e il prigioniero di Azkaban");
            prep.setString(3, "2003");
            prep.setString(4, "David Yates");
            prep.setString(5, "1968");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "4");
            prep.setString(2, "Harry Potter e il calice di fuoco");
            prep.setString(3, "2004");
            prep.setString(4, "David Yates");
            prep.setString(5, "1968");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "5");
            prep.setString(2, "Il signore degli anelli");
            prep.setString(3, "2001");
            prep.setString(4, "Peter Jackson");
            prep.setString(5, "1953");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "6");
            prep.setString(2, "Ho finito i nomi");
            prep.setString(3, "2002");
            prep.setString(4, "Chiara Esposito");
            prep.setString(5, "1966");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "7");
            prep.setString(2, "Prova");
            prep.setString(3, "2012");
            prep.setString(4, "Chiara Esposito");
            prep.setString(5, "1966");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "8");
            prep.setString(2, "Big Hero 6");
            prep.setString(3, "2016");
            prep.setString(4, "Mario Rossi");
            prep.setString(5, "1958");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "9");
            prep.setString(2, "Hannah");
            prep.setString(3, "2008");
            prep.setString(4, "Paolo Verdi");
            prep.setString(5, "1978");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "10");
            prep.setString(2, "Prova 2");
            prep.setString(3, "2017");
            prep.setString(4, "Chiara Esposito");
            prep.setString(5, "1966");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
                  
            
        } else {
            ResultSet rs = stat.executeQuery("select * from books;");
            //The resultSet is the cursor over the database table
            while (rs.next()) {
                System.out.print("Book = " + rs.getString("id") + " is : ");
                System.out.println(rs.getString("title"));
            }
            rs.close();
        }
        conn.close();
    }
    
}
