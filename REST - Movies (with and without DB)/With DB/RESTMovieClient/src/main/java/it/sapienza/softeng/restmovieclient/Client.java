/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.restmovieclient;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author studente
 */
public class Client {
    
    private static final String BASE_URL = "http://localhost:8080/movies/";
    private static CloseableHttpClient client;

    public static void main(String[] args) throws IOException {
        client = HttpClients.createDefault();

        // Example GET
        
        //An Object mapper allows to deserialize a JSON
        ObjectMapper mapper = new ObjectMapper();
        
        Boolean exit = false;
        
        while(!exit){
            
            System.out.println("Type 'all' to see the list of all movies.");
            System.out.println("Or select a movie with a number from '1' to '15'.");
            System.out.println("Type 'exit' to exit. \n\n");
            

            Scanner scan = new Scanner(System.in);
            String inserted = scan.next();
            
            if (inserted.equals("exit")) {
                exit = true;
            }
            
            else if(!inserted.equals("all")) {
                URL url = new URL(BASE_URL + inserted);
        
                InputStream input = url.openStream();
        
                Movie mv = (Movie)mapper.readValue(input, Movie.class);
                URL url2 = new URL(BASE_URL + mv.getId() + "/director");

                InputStream input2 = url2.openStream();
        
                Director dir = (Director)mapper.readValue(input2, Director.class);
        
                System.out.println(mv);
                System.out.println(dir +"\n\n");
            }
            else {
                URL url = new URL(BASE_URL +inserted);
        
                InputStream input3 = url.openStream();
                
                List<Movie> list = mapper.readValue(input3, new TypeReference<List<Movie>>(){});
                
                for(Movie m : list){
                    
                    URL urlIn = new URL(BASE_URL + m.getId() + "/director");
                    
                    Director d = (Director)mapper.readValue(urlIn, Director.class);
                    
                    System.out.println(m);
                    System.out.println(d + "\n\n");
                }
                
                
            }
        }
        
        System.out.println("Thanks! Bye. \n\n");
        
        

        
    }
    
}
