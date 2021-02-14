/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.warehousews;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author studente
 */
@XmlType(name="Book")
public class BookImpl implements Book{
    
    private int id;
    private double price;
    private List<String> sellers = new ArrayList();
    private List<String> deliveryDates = new ArrayList();
    private Map<String, String> mapSellers = new LinkedHashMap<String, String>();
    
    public int getId(){
    return id;}
    
    public double getPrice(){
    return price;}
    
    public List<String> getSellers(){
    return sellers;}
    
    public List<String> getDates(){
    return deliveryDates;}
    
    public Map<String, String> getMapSellers(){
    return mapSellers;}
    
    public void setId(int id){ this.id = id;}
    
    public void setPrice(double price){ this.price = price;}
    
    public void setSellers(List<String> sellers){ this.sellers = sellers;}
    
    public void setDates(List<String> dates){ this.deliveryDates = dates;}
    
    public void setMapSellers(Map<String, String> mapSellers){ this.mapSellers = mapSellers;}
    
    public BookImpl(int id, double price, List<String> sellers, List<String> dates, Map<String, String> mapSellers) {
        this.id = id;
        this.price = price;
        this.sellers = sellers;
        this.deliveryDates = dates;
        this.mapSellers = mapSellers;
    }
    
    public BookImpl(){}
    
    @Override
    public int hashCode() {
    return id;}
    
    @Override
    public boolean equals(Object obj){
    return (obj instanceof BookImpl) && (id == ((BookImpl) obj).getId());}
    
    @Override
    public String toString(){
    return "Book: " + id + " has price "+ price;}
    
}
