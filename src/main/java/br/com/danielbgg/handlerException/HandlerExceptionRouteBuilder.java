package br.com.danielbgg.handlerException;

import org.apache.camel.builder.RouteBuilder;

public class HandlerExceptionRouteBuilder  extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		onException(HandlerException.class).maximumRedeliveries(2).to("file:out/handlerException2");

		from("file:in/handlerException?noop=true")
			.errorHandler(deadLetterChannel("file:out/handlerException").useOriginalMessage())
			.process(new LogProcessor())
			.to("file:out/handlerException");
	}

}
