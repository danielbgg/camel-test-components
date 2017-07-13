package br.com.danielbgg.splitter;

import org.apache.camel.builder.RouteBuilder;

public class SplitterRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:in/splitter/txt?noop=true")
		.choice()
		.when(header("CamelFileName").endsWith("txt"))
		.log("Encontrado arquivo TXT!")
		.split().tokenize("\n")
		//.to("file:out/splitter/txt");
		//.to("jms:queue:orders");
		.to("log:entradaTXT?showBody=true");
		
		from("file:in/splitter/xml?noop=true")
		.choice()
		.when(header("CamelFileName").endsWith("xml"))
		.log("Encontrado arquivo XML!")
		.split().xpath("/Payments/Payment")
		//.to("file:out/splitter/xml");
		//.to("jms:queue:orders");
		.to("log:entradaXML?showBody=true");
		
	}

}
