package br.com.danielbgg.timer;

import org.apache.camel.builder.RouteBuilder;

public class TimerRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("timer:generateFile?period=5000")
		.setBody(simple("Hora atual: ${header.firedTime}"))
		.to("file:out/timer");
	}

	
	
}
