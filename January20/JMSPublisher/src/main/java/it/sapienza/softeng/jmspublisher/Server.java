/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.jmspublisher;

import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author studente
 */
public class Server {
    public static void main(String args[]) throws Exception {
                    
            //check if ActimeMQ is up and running
            /*
            boolean serverReady = false;
            while(!serverReady) {
            Socket socket = new Socket();
            try {
                socket.connect(new InetSocketAddress("broker", 8161), 5000);
                socket.close();
                serverReady = true;
                System.out.println("... broker is finally ready");
            } catch (Exception ex) {
                serverReady = false;
                System.out.println("... broker NOT yet ready");
            }
            
            }*/

	Professors p = new Professors();
                p.start();	
                        
	}
    
}
