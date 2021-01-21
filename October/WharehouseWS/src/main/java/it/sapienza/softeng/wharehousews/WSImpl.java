/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.wharehousews;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.jws.WebService;

@WebService(endpointInterface = "it.sapienza.softeng.wharehousews.WSInterface")
public class WSImpl {
    
    private Map<Integer, BookInterface > books
            = new LinkedHashMap<Integer, BookInterface>();
    
    public Map<Integer, BookInterface> getBooks() {
        for(BookInterface b : books.values()){
            System.out.println("price: "+b.getPrice());
        }
        return books;
    }
    
    public void addBook(BookInterface book) {
        books.put(books.size() +1, book);
        
        
        
        return;
    }
    
    
    
    
}
