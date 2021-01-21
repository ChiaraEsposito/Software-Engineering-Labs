/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.soapmovieservice;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author studente
 */
@XmlJavaTypeAdapter(MovieAdapter.class)
public interface Movie {
    
    public int getId();
    public String getTitle();
    public String getYear();
    public String getDirectorId();
    
    public String toString();
}
