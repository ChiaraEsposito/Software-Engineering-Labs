/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.warehousews;

import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author studente
 */
@XmlJavaTypeAdapter(BookAdapter.class)
public interface Book {
    public int getId();
    public double getPrice();
    public List<String> getSellers();
    public List<String> getDates();
    public Map<String, String> getMapSellers();
    public String toString();
}
