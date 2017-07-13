package br.com.danielbgg.converter;

import org.apache.camel.builder.RouteBuilder;

public class ConverterRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:in/converter?noop=true")
		.convertBodyTo(Order.class)
			.to("velocity:br/com/danielbgg/transformTemplate/email.vm")
			.to("file:out/converter");
	}
	
}