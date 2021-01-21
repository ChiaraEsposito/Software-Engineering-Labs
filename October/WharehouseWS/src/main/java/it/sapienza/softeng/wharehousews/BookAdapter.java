/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.wharehousews;
import javax.xml.bind.annotation.adapters.XmlAdapter;
/**
 *
 * @author studente
 */
public class BookAdapter extends XmlAdapter<BookImpl,BookInterface>{
    
    public BookImpl marshal(BookInterface book) throws Exception {
        if (book instanceof BookImpl)
            return (BookImpl) book;
        return new BookImpl(book.getId(), book.getPrice());
    }

    @Override
    public BookInterface unmarshal(BookImpl b) throws Exception {
        return b;
    }
    
}
