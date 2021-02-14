/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.warehousews;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;

/**
 *
 * @author studente
 */
@WebService(endpointInterface = "it.sapienza.softeng.warehousews.WSInterface")
public class WSImpl implements WSInterface{
    
    private Map<Integer, Book> books
            = new LinkedHashMap<Integer, Book>();
    
    public Book getBookSoap(int id) {
       for (Map.Entry<Integer, Book> entry : books.entrySet()) {
            if (id == entry.getKey()){
                return entry.getValue();
            }
       }
      return null;
    }
    
    public WSImpl(){

        List<String> s1 = Arrays.asList("Mondadori", "Feltrinelli", "Pippo", "Pluto", "NonLoSo");
        List<String> d1 = Arrays.asList("01/07/2021", "12/03/2021", "15/02/2021", "23/08/2021", "20/02/2021");
        Map<String, String> map = new LinkedHashMap<String, String>();
        map.put("Mondadori", "01/07/2022");
        map.put("Feltrinelli", "12/03/2022");
        map.put("Pippo", "15/02/2022");
        map.put("Pluto", "23/08/2022");
        map.put("Nonloso", "20/02/2022");
        BookImpl b1 = new BookImpl(1, 29.99, s1, d1, map);
        books.put(1, b1);
        
        List<String> s2 = Arrays.asList("Mondadori", "Feltrinelli");
        List<String> d2 = Arrays.asList("01/07/2021", "12/03/2021");
        Map<String, String> map2 = new LinkedHashMap<String, String>();
        map2.put("Mondadori", "01/07/2022");
        map2.put("Feltrinelli", "12/03/2022");
        BookImpl b2 = new BookImpl(2, 12.00, s2, d2, map2);
        books.put(2, b2);
    
    }
    
}
