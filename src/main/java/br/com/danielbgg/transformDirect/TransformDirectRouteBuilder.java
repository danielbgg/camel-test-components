package br.com.danielbgg.transformDirect;

import org.apache.camel.builder.RouteBuilder;

public class TransformDirectRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:javaobject")
		.to("jms:queue:orders");
	}

}
