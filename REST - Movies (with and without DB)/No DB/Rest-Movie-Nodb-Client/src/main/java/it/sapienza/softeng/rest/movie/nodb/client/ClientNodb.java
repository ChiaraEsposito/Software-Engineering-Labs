/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.rest.movie.nodb.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import javax.xml.bind.JAXB;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author studente
 */
public class ClientNodb {
    
    private static final String BASE_URL = "http://localhost:8080/movies/";
    private static CloseableHttpClient client;//class that can act like a minibrowser. able to perform http operations

    public static void main(String[] args) throws IOException{
    client = HttpClients.createDefault();
    
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
                // Example GET
                MovieNodb movie = getMovie(Integer.parseInt(inserted));
                DirectorNodb dir = getDirector(Integer.parseInt(movie.getDirectorId()));
                
                System.out.println(movie);
                System.out.println(dir + "\n\n");
                
            }
            else {
       
                MovieList list = getAll();
                
                for (MovieNodb movie : list.getMovies()) {
                    
                    DirectorNodb d = getDirector(Integer.parseInt(movie.getDirectorId()));
                    System.out.println(movie);
                    System.out.println(d);
                }
            }
        
        }
    System.out.println("Thanks! Bye. \n\n");
    client.close();
    
        
    }

      private static DirectorNodb getDirector(int movieOrder) throws IOException {
        final URL url = new URL(BASE_URL + movieOrder + "/director");
        final InputStream input = url.openStream();//This starts a getting through the web service
        return JAXB.unmarshal(new InputStreamReader(input), DirectorNodb.class);//you take what is coming
        //from input and tell to JAXB that he has to undesrtand what is arriving as an instance of
        //the student class
    }

      private static MovieNodb getMovie(int movieOrder) throws IOException {
        final URL url = new URL(BASE_URL + movieOrder);
        final InputStream input = url.openStream();
        return JAXB.unmarshal(new InputStreamReader(input), MovieNodb.class);
    }
      
      private static MovieList getAll() throws IOException {
        final URL url = new URL(BASE_URL + "all");
        final InputStream input = url.openStream();
        return JAXB.unmarshal(new InputStreamReader(input), MovieList.class);
    }

    
}
