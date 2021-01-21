/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.wharehousews;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;
/**
 *
 * @author studente
 */
public class BookMapAdapter extends XmlAdapter<BookMap, Map<Integer,BookInterface>>{
    
    @Override
    public Map<Integer, BookInterface> unmarshal(BookMap b) throws Exception {
        Map<Integer,BookInterface> boundMap = new LinkedHashMap<Integer, BookInterface>();
        for (BookMap.BookEntry bookEntry : b.getEntries()) {
            boundMap.put(bookEntry.getId(), bookEntry.getBook());
        }
        return boundMap;
    }

    @Override
    public BookMap marshal(Map<Integer, BookInterface> boundMap) throws Exception {
        BookMap valueMap = new BookMap();
        for (Map.Entry<Integer, BookInterface> boundEntry : boundMap.entrySet()) {
            BookMap.BookEntry valueEntry = new BookMap.BookEntry();
            valueEntry.setBook(boundEntry.getValue());
            valueEntry.setId(boundEntry.getKey());
            valueMap.getEntries().add(valueEntry);
        }
        return valueMap;
    }
    
}
