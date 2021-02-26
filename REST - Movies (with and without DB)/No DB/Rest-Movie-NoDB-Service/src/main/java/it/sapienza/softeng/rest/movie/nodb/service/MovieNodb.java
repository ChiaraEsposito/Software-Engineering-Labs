/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.rest.movie.nodb.service;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author studente
 */
@XmlRootElement(name = "Movie")
public class MovieNodb {
    
    private int id;
    private String title, year, directorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    public String getDirectorId() {
        return directorId;
    }

    public void setDirectorId(String directorId) {
        this.directorId = directorId;
    }

    
    @Override
    public int hashCode() {
        return id + title.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof MovieNodb) && (id == ((MovieNodb) obj).getId()) && (title.equals(((MovieNodb) obj).getTitle()));
    }
    @Override
    public String toString() {
        return "movie " + id + " " + title;
    }
    
}
