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
import soap.ClassNotFoundException_Exception;
import soap.SQLException_Exception;

/**
 *
 * @author studente
 */
public class Client {
    
    private static final String BASE_URL = "http://localhost:8081/books/";
    private static CloseableHttpClient client;

    public static void main(String[] args) throws IOException, ClassNotFoundException_Exception, SQLException_Exception {
        client = HttpClients.createDefault();
        
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
                
                //SOAP
                soap.Book b1 = getBookSoap(Integer.parseInt(inserted));
        
                System.out.println(b);
                System.out.println("Price: " + b1.getPrice());
                
                /*System.out.println("Sellers and dates: ");
                for (int j=0; j< b1.getSellers().size(); j++) {
                    System.out.println(b1.getSellers().get(j) + " " + b1.getDates().get(j));
                  
                }*/
                
                System.out.println("Sellers: ");
                for (String s : b1.getSellers()) {
                    System.out.print(s + "; ");
                }
                
                System.out.println("\n\nTo see the delivery date, enter the name of a seller.\n Otherwise enter 'no'");
                String answer = scan.next();
                
                if(!answer.equals("no")) {
                    for (int j=0; j< b1.getSellers().size(); j++) {
                        if (b1.getSellers().get(j).equals(answer)) {
                            System.out.println(b1.getDates().get(j)+"\n\n");
                            break;
                        }
                            
                        }
                }
                
                

            }
            
            else {
                URL url = new URL(BASE_URL +inserted);
        
                InputStream input3 = url.openStream();
                
                List<Book> list = mapper.readValue(input3, new TypeReference<List<Book>>(){});
                
                for(Book book : list){
                                       
                    System.out.println(book + "\n\n");
                }
               
                
            }
        }
        
        System.out.println("Thanks! Bye. \n\n");
   
    }   
       
    private static soap.Book getBookSoap(int i) throws ClassNotFoundException_Exception, SQLException_Exception{
    soap.WSImplService service = new soap.WSImplService();
    soap.WSInterface port = service.getWSImplPort();
    
    // TODO process result here
    soap.Book result = port.getBookSoap(i);
        return result;
    }


}
