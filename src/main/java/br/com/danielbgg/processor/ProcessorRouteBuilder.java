package br.com.danielbgg.processor;

import org.apache.camel.builder.RouteBuilder;

public class ProcessorRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:in/processor?noop=true")
			.process(new LogProcessor())
			.to("file:out/processor");
	}

	
	
}
