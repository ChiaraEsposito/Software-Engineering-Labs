/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.jmspublisher;

import java.util.Properties;
import java.util.Random;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author studente
 */
public class Professors {
    final String professori[] = { "Mecella", "Catarci", "Beraldi",
			"Leonardi", "Patrizi", "Bonomi", "D'Amore", "De Giacomo" };

	private int scegliProfessore() {
		int whichMsg;
		Random randomGen = new Random();

		whichMsg = randomGen.nextInt(this.professori.length);
		return whichMsg+1;
	}
    
        

        private static final Logger LOG = LoggerFactory.getLogger(Professors.class);
        
	public void start() throws NamingException, JMSException {
                
                Context jndiContext = null;
                ConnectionFactory connectionFactory = null;
                Connection connection = null;
                Session session = null;
                Destination destination = null;
                MessageProducer producer = null;
                String destinationName = "dynamicTopics/1716809-topics";
        
                /*
         * Create a JNDI API InitialContext object
         */
        
        try {
            
            Properties props = new Properties();
        
props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
//for initial Lab
props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");

//for Docker
//props.setProperty(Context.PROVIDER_URL,"tcp://broker:61616");
jndiContext = new InitialContext(props);        
                
        } catch (NamingException e) {
            LOG.info("ERROR in JNDI: " + e.toString());
            System.exit(1);
        }

        /*
         * Look up connection factory and destination.
         */
        try {
            connectionFactory = (ConnectionFactory)jndiContext.lookup("ConnectionFactory");
            destination = (Destination)jndiContext.lookup(destinationName);
        } catch (NamingException e) {
            LOG.info("JNDI API lookup failed: " + e);
            System.exit(1);
        }

        /*
         * Create connection. Create session from connection; false means
         * session is not transacted. Create sender and text message. Send
         * messages, varying text slightly. Send end-of-messages message.
         * Finally, close connection.
         */
        try {
            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            producer = session.createProducer(destination);
            
              
                
                TextMessage message = null;
                String messageType = null;
		//int id = 0;
		
                message = session.createTextMessage();

		int i = 0;
		while (true) {
			i++;
			int id = scegliProfessore();
                        messageType = this.professori[id-1];
			message.setStringProperty("Nome", messageType);
			//message.setIntProperty("Id", id);
                        message.setStringProperty("Id", Integer.toString(id));
			message.setText(
					"Item: " + i + " >> " + " Id: " + id + " = " + messageType);

			    LOG.info(
					this.getClass().getName() + 
				        "Invio professore: " + message.getText());

			producer.send(message);

			try {
				Thread.sleep(5000);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
        
        catch (JMSException e) {
            LOG.info("Exception occurred: " + e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                }
            }
        }
}
    
}
