/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.wharehousews;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.xml.bind.annotation.XmlType;
import java.util.Map;
/**
 *
 * @author studente
 */
@XmlType(name = "Book")
public class BookImpl implements BookInterface {
    
    private String id, price;
    //private Map<String, String > sellersWithDate = new LinkedHashMap<String, String>();
    
    public String getId() {return id;}
    public void setId(String id) {id = id;}
    
    public String getPrice() { return price; }
    public void setPrice(String p) { price = p; }
    
       
    public BookImpl(String id, String price) { 
        this.id = id; 
        this.price = price;} 
    public BookImpl() {}
    
}
