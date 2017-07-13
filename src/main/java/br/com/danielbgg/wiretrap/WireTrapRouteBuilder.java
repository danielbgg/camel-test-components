package br.com.danielbgg.wiretrap;

import org.apache.camel.builder.RouteBuilder;

public class WireTrapRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:in/wiretrap?noop=true")
		.wireTap("file:out/wiretrap/copy")
		.to("file:out/wiretrap/out");
	}
	
	

}
