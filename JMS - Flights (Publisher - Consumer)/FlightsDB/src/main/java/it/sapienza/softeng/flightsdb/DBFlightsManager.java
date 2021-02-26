/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.flightsdb;
import java.sql.*;
/**
 *
 * @author studente
 */
public class DBFlightsManager {
    public static void main(String[] args) throws ClassNotFoundException {
        if (args.length < 1) {
            System.out.println("Pass 'create' to initialize the database, 'run' to print the content of the database");
            System.exit(1);
        }

        Class.forName("org.sqlite.JDBC");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/home/studente/se-2019_09.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            if (args[1].equals("create")) { //nell'originale era args[0] ma dava problemi
                //Create the database
                //IMPORTANT ... to run:
                // Set configuration < Customize < Run < Arguments:
                // home/studente/se-2019_09.db create
                statement.executeUpdate("DROP TABLE IF EXISTS flights;");
                statement.executeUpdate("CREATE TABLE flights (flight STRING, status STRING);");
                statement.executeUpdate("INSERT INTO flights VALUES('AA123', 'landed');");
                System.out.println("Database successfully created!");
            } else{
                System.out.println("Reading the database...");
                //Read the database
                //IMPORTANT ... to run:
                // Set configuration < Customize < Run < Arguments:
                // home/studente/se-2019_09.db read
                ResultSet rs1 = statement.executeQuery("SELECT * FROM flights");
                while (rs1.next()) {
                    System.out.println(String.format("%s : %s", rs1.getString("flight"), rs1.getString("status")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
