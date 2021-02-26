/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.flightsjmsserver;

/**
 *
 * @author studente
 */

import java.net.InetSocketAddress;
import java.net.Socket;
import javax.jms.JMSException;
import javax.naming.NamingException;


public class Server{
    
 public static void main(String args[]) throws NamingException, JMSException {
            
            //If you use DOCKER add this, to verify Activemq is running
            boolean serverReady = false;
            while(!serverReady) {
                Socket socket = new Socket();
                try {
                    //socket.connect(new InetSocketAddress("broker",8161), 5000); //for DOCKER
                    socket.connect(new InetSocketAddress("localhost",61616), 5000); //5000 is a timeout
                    //NOTE: the port (61616) should be the same defined in the FlightProvider
                    socket.close();
                    serverReady = true;
                    System.out.println("..Broker is finally ready");
                } catch (Exception ex) { serverReady=false;  
                System.out.println("Broker not yet ready...");}
            } //end while
            
            
        //This must be inserted anyway
        FlightsProvider f = new FlightsProvider();
	f.start();
    }

}
