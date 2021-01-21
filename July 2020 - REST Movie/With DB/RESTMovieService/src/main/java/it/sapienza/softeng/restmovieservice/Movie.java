/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.restmovieservice;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 *
 * @author studente
 */
@JacksonXmlRootElement(localName = "Movie")
public class Movie {
    
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

    /*@GET
    @Path("{directorId}")
    public Director getDirector(@PathParam("directorId") int directorId) {
        return findById(directorId);
    }

    @POST
    public Response createDirector (Director dir) {
        for (Director element : directors) {
            if (element.getId() == student.getId()) {
                return Response.status(Response.Status.CONFLICT).build();
            }
        }
        students.add(student);
        return Response.ok(student).build();
    }

    @DELETE
    @Path("{studentId}")
    public Response deleteStudent(@PathParam("studentId") int studentId) {
        Student student = findById(studentId);
        if (student == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        students.remove(student);
        return Response.ok().build();
    }

    private Director findById(int id) {
        for (Director director : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }*/

    
    @Override
    public int hashCode() {
        return id + title.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Movie) && (id == ((Movie) obj).getId()) && (title.equals(((Movie) obj).getTitle()));
    }
    @Override
    public String toString() {
        return "movie " + id + " " + title;
    }
    
}
