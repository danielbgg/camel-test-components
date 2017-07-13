package br.com.danielbgg.recipientList;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class RecipientListProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
		String recipientList = "";
		String fileName = (String) in.getHeader("CamelFileNameOnly");
		String[] destination = fileName.split("-");
		if ("toyota".equals(destination[0])){
			recipientList = recipientList.concat("file:out/recipientList/toyota");
		}else if("gmc".equals(destination[0])){
			recipientList = recipientList.concat("file:out/recipientList/gmc");
		}else {
			recipientList = recipientList.concat("file:out/recipientList/gmc,file:out/recipientList/toyota");
		}
		in.getHeaders().put("destinations", recipientList);
	}

}
