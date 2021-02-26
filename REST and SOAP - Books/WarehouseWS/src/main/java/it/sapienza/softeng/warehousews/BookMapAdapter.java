/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.warehousews;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author studente
 */
public class BookMapAdapter extends XmlAdapter<BookMap, Map<Integer,Book>>{

    @Override
    public Map<Integer,Book> unmarshal(BookMap v) throws Exception {
        Map<Integer,Book> boundMap = new LinkedHashMap<Integer, Book>();
        for (BookMap.BookEntry bookEntry : v.getEntries()) {
            boundMap.put(bookEntry.getId(), bookEntry.getBook());
        }
        return boundMap;
    }

    @Override
    public BookMap marshal(Map<Integer, Book> boundMap) throws Exception {
        BookMap valueMap = new BookMap();
        for (Map.Entry<Integer, Book> boundEntry : boundMap.entrySet()) {
            BookMap.BookEntry valueEntry = new BookMap.BookEntry();
            valueEntry.setBook(boundEntry.getValue());
            valueEntry.setId(boundEntry.getKey());
            valueMap.getEntries().add(valueEntry);
        }
        return valueMap;
    }
    
}
