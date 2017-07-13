package br.com.danielbgg.splitter;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class MainSplitterWithMQ {
	
		public static void main(String[] args) throws Exception {

			CamelContext context = new DefaultCamelContext();

			// Define JMS component with ActiveMQ factory
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory
			("vm://localhost");
			context.addComponent
			("jms",JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

			context.addRoutes(new SplitterRouteBuilder());
			context.start();
			Thread.sleep(5000);

			// See if JMS messages were written
			Connection connection = connectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			Destination queue = session.createQueue("orders");
			MessageConsumer consumer = session.createConsumer(queue);
			Message message = consumer.receive(10);
			while (message != null) {
				if (message instanceof BytesMessage) {
					byte[] bytes = new byte[20];
					((BytesMessage) message).readBytes(bytes);
					System.out.println("**********Got message: "
							+ new String(bytes));
				}
				message = consumer.receive(10);
			}
			consumer.close();
			session.close();
			connection.close();
			
			context.stop();
	}	

}
