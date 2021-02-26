/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.flightsjmsclient;

/**
 *
 * @author studente
 */

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class Client {
    public static void main(String[] args) throws InterruptedException, NamingException, JMSException, ClassNotFoundException {
        
        //Set up connections for jms (same things as ProfessorProvider)
        Context jndiContext = null;
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session = null;
        Destination destination = null;
        String destinationName = "dynamicTopics/flights"; //change this
        
        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616"); //check if is the right port
        jndiContext = new InitialContext(props);
        
        connectionFactory = (ConnectionFactory)jndiContext.lookup("ConnectionFactory");
        connection = connectionFactory.createConnection();
        session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        destination = (Topic) jndiContext.lookup(destinationName);
        MessageConsumer consumer = session.createConsumer(destination);
        
        //Start the connection and Get the message
        connection.start();
        Message m;
        String code; //flight code
        String status; 
        while(true){
            m = consumer.receive(); //receive the message
            code = m.getStringProperty("flight");
            int i = m.getIntProperty("number");
            status = m.getStringProperty("status");
            //Print the received message
            System.out.println("\nItem " + i + " >> flight "+ code + 
                    " has landed : "+ status);
            //Add the received message to the database
           addFlight(code,status);
        }
    }
    
    //Add flights to the database 
    private static void addFlight(String f_code, String f_status) throws ClassNotFoundException{
        Class.forName("org.sqlite.JDBC");
        java.sql.Connection conn = null;
        String status;

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:/home/studente/se-2019_09.db");
            PreparedStatement prep = conn.prepareStatement(
                    "insert into flights (flight, status) values (?, ?);");
            if("true".equals(f_status)) {
                status = "landed";
            }
            else {
                status = "not landed";
            }
          
            prep.setString(1, f_code);
            prep.setString(2,status);
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);

            System.out.println("Added: " + f_code + " " + status);
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
