package br.com.danielbgg.aggregate;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class DestinationProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
		String customer = null;
		String fileName = (String) in.getHeader("CamelFileNameOnly");
		
		if (fileName.startsWith("cars")) {
			customer = "cars";
		} else if (fileName.startsWith("motorcycles")) {
			customer = "motorcycles";
		}
		in.getHeaders().put("customer", customer);
	}

}
