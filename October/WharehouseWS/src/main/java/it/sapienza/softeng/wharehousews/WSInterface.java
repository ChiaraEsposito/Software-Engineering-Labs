/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.wharehousews;


import java.util.Map;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@WebService
public interface WSInterface {
   
    @XmlJavaTypeAdapter(BookMapAdapter.class)
    public Map<Integer, BookInterface> getBooks();
    
    public void addBook(BookInterface book);
    
    
    
    
}
