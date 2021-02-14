/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.warehousews;

/**
 *
 * @author studente
 */
import java.sql.SQLException;
import java.util.Map;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@WebService
public interface WSInterface {

   //Functions seen by client
   
    public Book getBookSoap(int id) throws ClassNotFoundException, SQLException;
    
}

