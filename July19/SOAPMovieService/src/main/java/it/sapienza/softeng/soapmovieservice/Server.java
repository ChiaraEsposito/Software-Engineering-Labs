/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.soapmovieservice;
import javax.xml.ws.Endpoint;
/**
 *
 * @author studente
 */
public class Server {
    
    public static void main(String args[]) throws InterruptedException {
        WSImpl implementor = new WSImpl();
        String address = "http://localhost:8080/WSInterface";
        //for docker String address = "http://0.0.0.0:7777/WSInterface";
        Endpoint.publish(address, implementor);
        while(true) {}
        //Thread.sleep(60 * 1000);
        //System.exit(0);
    }
    
}
