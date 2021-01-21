/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.bookclient;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 *
 * @author studente
 */
@JacksonXmlRootElement(localName = "Book")
public class Book {
    
    private int id;
    private String title, year, author, birth;

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
    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
  
    @Override
    public int hashCode() {
        return id + title.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Book) && (id == ((Book) obj).getId()) && (title.equals(((Book) obj).getTitle()));
    }
    @Override
    public String toString() {
        return "Book " + id + " is " + title +'(' + year + ')'+ " written by " + author + '(' + birth + ')';
    }
    
}
