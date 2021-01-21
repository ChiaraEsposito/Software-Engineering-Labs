/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.rest.movie.nodb.service;

/**
 *
 * @author studente
 */
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Director")
public class DirectorNodb {
    
    private int id;
    private String name, yearOfBirth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getBirth() {
        return yearOfBirth;
    }

    public void setBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public int hashCode() {
        return id + name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof DirectorNodb) && (id == ((DirectorNodb) obj).getId()) && (name.equals(((DirectorNodb) obj).getName()));
    }
    
    @Override
    public String toString() {
        return "Director: " + name + " " + yearOfBirth;
    }
    
    
}
