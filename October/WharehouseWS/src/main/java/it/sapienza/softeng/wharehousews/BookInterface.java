/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.wharehousews;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
/**
 *
 * @author studente
 */
@XmlJavaTypeAdapter(BookAdapter.class)
public interface BookInterface {
    
    public String getId();
    
    public String getPrice();

}
