package br.com.danielbgg.wscodefirst;

import javax.xml.ws.Endpoint;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class MainWSCodeFirst {

	/**
	 * A main() so we can easily run these routing rules in our IDE
	 */
	public static void main(String... args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		Endpoint endpoint = Endpoint.publish("http://localhost:9000/order", new OrderProcessorImpl());
		context.start();
		context.addRoutes(new WSCodeFirstRouteBuilder());
		Thread.sleep(100000);
		context.stop();
		endpoint.stop();
	}

}
