package br.com.danielbgg.aggregate;

import org.apache.camel.builder.RouteBuilder;

public class AggregateRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:in/aggregate?noop=true")
		.process(new DestinationProcessor())
		.aggregate(header("customer"), new BodyAggregate()).completionSize(5)
		.to("file:out/aggregate");
	}

}
