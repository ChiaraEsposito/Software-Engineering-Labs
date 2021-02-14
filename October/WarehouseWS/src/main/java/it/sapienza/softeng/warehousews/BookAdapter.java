/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.warehousews;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author studente
 */
public class BookAdapter extends XmlAdapter<BookImpl, Book>{
    
public BookImpl marshal(Book b) throws Exception {
        if (b instanceof BookImpl)
            return (BookImpl) b;
        return new BookImpl(b.getId(), b.getPrice(), b.getSellers(), b.getDates(), b.getMapSellers()); // da cambiare
    }

    @Override
    public Book unmarshal(BookImpl v) throws Exception {
        return v;
    }
    
}
