/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soapmovieclient;

import java.util.List;
import java.util.Scanner;
import soapclient.*;

/**
 *
 * @author studente
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException_Exception, SQLException_Exception {
        // TODO code application logic here
        
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
                
                Movie mv = getMovie(Integer.parseInt(inserted));
                Director dir = getDirector(Integer.parseInt(mv.getDirectorId()));
                
                System.out.println(mv);
                System.out.println(dir +"\n\n");
            }
            else {
                
                List<Movie> list = getAll();
        
                    for(Movie m : list){
                        Director d = getDirector(Integer.parseInt(m.getDirectorId()));
                    
                        System.out.println(m);
                        System.out.println(d + "\n\n");
                }
                
                
            }
        }
        
        System.out.println("Thanks! Bye. \n\n");
        
        
    }
      
    private static List<Movie> getAll() throws ClassNotFoundException_Exception, SQLException_Exception{
        soapclient.WSImplService service = new soapclient.WSImplService();
        soapclient.WSInterface port = service.getWSImplPort();
        List<Movie> results = port.getAll();
        return results;
    }
    
    private static Director getDirector(int id) throws ClassNotFoundException_Exception, SQLException_Exception{
        soapclient.WSImplService service = new soapclient.WSImplService();
        soapclient.WSInterface port = service.getWSImplPort();
        return port.getDirector(id);
    }

    private static Movie getMovie(int id) throws ClassNotFoundException_Exception, SQLException_Exception{
        soapclient.WSImplService service = new soapclient.WSImplService();
        soapclient.WSInterface port = service.getWSImplPort();
        return port.getMovie(id);
    }
    
    
}
