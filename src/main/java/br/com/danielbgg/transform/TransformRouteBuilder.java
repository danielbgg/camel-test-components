package br.com.danielbgg.transform;

import org.apache.camel.builder.RouteBuilder;

public class TransformRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:in/transform?noop=true")
		.transform(body().regexReplaceAll(",", ";"))
		.to("file:out/transform");
	}
	
	

}
