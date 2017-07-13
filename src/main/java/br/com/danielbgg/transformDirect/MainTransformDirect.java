package br.com.danielbgg.transformDirect;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class MainTransformDirect {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();

		// Define JMS component with ActiveMQ factory
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");
		connectionFactory.setTrustAllPackages(true);

		context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

		context.addRoutes(new TransformDirectRouteBuilder());
		context.start();

		Order order = new Order();
		order.setDescrption("My purchase");

		ProducerTemplate producerTemplate = context.createProducerTemplate();
		producerTemplate.sendBody("direct:javaobject", order);

		Thread.sleep(5000);

		// See if JMS messages were written
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination queue = session.createQueue("orders");

		MessageConsumer consumer = session.createConsumer(queue);
		Message message = consumer.receive(10);
		while (message != null) {
			if (message instanceof ObjectMessage) {
				Order object = (Order) ((ObjectMessage) message).getObject();
				System.out.println("**********Got message: " + object.getDescription());
			}
			message = consumer.receive(10);
		}

		consumer.close();
		session.close();
		connection.close();

		context.stop();

	}

}
