/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.bookclient;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Scanner;
import java.util.List;
import java.util.Map;
import soap.*;

/**
 *
 * @author studente
 */
public class Client {
    
    private static final String BASE_URL = "http://localhost:8081/books/";
    private static CloseableHttpClient client;

    public static void main(String[] args) throws IOException {
        client = HttpClients.createDefault();
        
        soap.Book b1 = new soap.Book();
        soap.Book b2 = new soap.Book();
        b1.setId("1");
        b1.setPrice("13");
        b2.setId("2");
        b2.setPrice("12");
        
        addBook(b1);
        addBook(b2);
        

        // Example GET
        
        //An Object mapper allows to deserialize a JSON
        ObjectMapper mapper = new ObjectMapper();
        
        Boolean exit = false;
        
        while(!exit){
            
            System.out.println("Type 'all' to see the list of all books.");
            System.out.println("Or select a book with a number from '1' to '15'.");
            System.out.println("Type 'exit' to exit. \n\n");
            

            Scanner scan = new Scanner(System.in);
            String inserted = scan.next();
            
            if (inserted.equals("exit")) {
                exit = true;
            }
            
            else if(!inserted.equals("all")) {
                URL url = new URL(BASE_URL + inserted);
        
                InputStream input = url.openStream();
        
                Book b = (Book)mapper.readValue(input, Book.class);
                
        
                System.out.println(b +"\n\n");
            }
            
            else {
                URL url = new URL(BASE_URL +inserted);
        
                InputStream input3 = url.openStream();
                
                List<Book> list = mapper.readValue(input3, new TypeReference<List<Book>>(){});
                
                for(Book book : list){
                                       
                    System.out.println(book + "\n\n");
                }
                
                List<BookEntry> books = Client.getBooks().getEntry();
                for (BookEntry book : books) {
                    System.out.println("Price: " + book.getBook().getPrice());
                }
                
                
                
            }
        }
        
        System.out.println("Thanks! Bye. \n\n");
   
    }
    
    private static BookMap getBooks() {
        soap.WSImplService service = new soap.WSImplService();
        soap.WSInterface port = service.getWSImplPort();
        return port.getBooks();
    }
    
    private static void addBook (soap.Book arg0) {
        soap.WSImplService service = new soap.WSImplService();
        soap.WSInterface port = service.getWSImplPort();
        port.addBook(arg0);
    }
    
   

}
