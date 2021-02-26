/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.jmssubscriber;

import java.util.Properties;
import java.util.Scanner;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author studente
 */
public class Professors implements MessageListener {
     
    
        
       private TopicConnection topicConnection;
       private TopicSession topicSession = null;
       private Destination destination = null;
       private MessageProducer producer = null;
        
      
    public Professors(){
        Context jndiContext = null;
                ConnectionFactory topicConnectionFactory = null;
                
                String destinationName = "dynamicTopics/1716809-topics";
                System.out.println("Insert the ID you want");
                Scanner scan = new Scanner(System.in);
                String valore = scan.nextLine();
                //int insertedId = Integer.parseInt(valore);
                        
                //String messageSelector = "Id='"+insertedId+"'";
                String messageSelector = "Id='"+valore+"'";
                
		try {
			
                    Properties props = new Properties();
        
		    props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");//name of apache activemq
		    //Initial program
                    props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");//says that we are working with localhost
                    jndiContext = new InitialContext(props);   //conceptually this is the logical name to which I have to connect
                    
                    
                    		
			
			topicConnectionFactory = (ConnectionFactory)jndiContext.lookup("ConnectionFactory");
                        destination = (Destination)jndiContext.lookup(destinationName);
			topicConnection = (TopicConnection)topicConnectionFactory.createConnection();
                        topicSession = (TopicSession)topicConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                        
                        TopicSubscriber topicSubscriber = null;
                        
                        if (messageSelector != null && messageSelector.length() > 0) {
                            topicSubscriber = topicSession.createSubscriber((Topic)destination, messageSelector, false);
                           
                            }
                        else {
                            topicSubscriber = topicSession.createSubscriber((Topic)destination);
                        }
                             
			topicSubscriber.setMessageListener(this);//you have to tell who
                        //is the listener in charge of receiving messages for this subscriber
                        //in this case the topic subscriber not only receiver but also the one that
                        //provides the message interface
		} catch (JMSException err) {
			err.printStackTrace();
		} catch (NamingException err) {
		    err.printStackTrace();//JNDI exception
                }
    }

	/**
	 * Chiude la ricezione dei messaggi sulla topic quotazioni
	 */
	public void stop() {
		try {
			topicConnection.stop();
		} catch (JMSException err) {
			err.printStackTrace();
		}
	}

	/**
	 * Apre la ricezione dei messaggi sulla topic quotazioni
	 */
	public void start() {
		try {
			topicConnection.start();
		} catch (JMSException err) {
			err.printStackTrace();
		}
	}
        
    @Override    
    public void onMessage(Message msg) {

           try {
               
		String id = msg.getStringProperty("Id");
                //int id = msg.getIntProperty("Id");
                String nome = msg.getStringProperty("Nome");
                TextMessage textMex = (TextMessage) msg;
			
			
                //System.out.println( id + " = " + nome);
                System.out.println(textMex.getText());
                        
		} catch (JMSException err) {
			err.printStackTrace();
		}

    }
    
}

