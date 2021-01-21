/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.wharehousews;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author studente
 */
@XmlType(name = "BookMap")
public class BookMap {
    
    private List<BookEntry> entries = new ArrayList<BookEntry>();

    @XmlElement(nillable = false, name = "entry")
    public List<BookEntry> getEntries() {
        return entries;
    }

    @XmlType(name = "BookEntry")//is defined as an inner class in the main class
    public static class BookEntry {

        private int id;
        private BookInterface book;

        public int getId() { return id; }
        public BookInterface getBook () { return book; }
     
        public void setId(int id) { id = id; }
        public void setBook(BookInterface book) { book = book; }
        
    }
    
}
