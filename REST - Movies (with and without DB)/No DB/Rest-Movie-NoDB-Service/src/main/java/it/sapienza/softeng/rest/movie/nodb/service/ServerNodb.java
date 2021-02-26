/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.rest.movie.nodb.service;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

/**
 *
 * @author studente
 */
public class ServerNodb {
    
    public static void main(String args[]) throws Exception {
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(MoviesRepositoryNodb.class);//the class in java in charge of managing the resorces
        //of this servant is the CourseRepository.class
        factoryBean.setResourceProvider(new SingletonResourceProvider(new MoviesRepositoryNodb()));//all instances of request
        //to the classes should be sent to this unique class (SINGLESTON= only one instance in the system)
        factoryBean.setAddress("http://localhost:8080/");
        Server server = factoryBean.create();

        System.out.println("Server ready...");
        //Thread.sleep(60 * 1000);
        //System.out.println("Server exiting");
        //server.destroy();
        //System.exit(0);
        while (true) {
        }
    }
    
}
