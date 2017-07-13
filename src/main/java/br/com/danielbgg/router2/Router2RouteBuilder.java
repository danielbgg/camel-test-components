package br.com.danielbgg.router2;

import org.apache.camel.builder.RouteBuilder;

public class Router2RouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:in/router2?noop=true")
		.choice()
			.when(header("CamelFileName").endsWith("txt"))
				.log("Arquivo TXT Encontrado! Movendo para pasta OUT...")
				.to("file:out/router2/txt")
			.when(header("CamelFileName").endsWith("xml"))
				.log("Arquivo XML Encontrado! Movendo para pasta OUT...")
				.to("file:out/router2/xml");
	}

}
