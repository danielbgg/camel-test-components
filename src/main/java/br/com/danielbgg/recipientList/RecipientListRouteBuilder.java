package br.com.danielbgg.recipientList;

import org.apache.camel.builder.RouteBuilder;

public class RecipientListRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:in/recipientList?noop=true")
		.process(new RecipientListProcessor())
		.recipientList(header("destinations"));
	}

}
