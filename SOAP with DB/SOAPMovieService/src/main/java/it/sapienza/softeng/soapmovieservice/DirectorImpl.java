/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.soapmovieservice;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author studente
 */
@XmlType(name = "Director")
public class DirectorImpl implements Director {
    
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
        return (obj instanceof DirectorImpl) && (id == ((DirectorImpl) obj).getId()) && (name.equals(((DirectorImpl) obj).getName()));
    }
    @Override
    public String toString() {
        return "Director: " + name + " " + yearOfBirth;}
    
    public DirectorImpl(int id, String name, String birth) { 
        this.id = id;
        this.name = name;
        this.yearOfBirth = birth;
    } 
    //Empty constructor
    public DirectorImpl() {}
    
}
