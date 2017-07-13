package br.com.danielbgg.transformCSV;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;

public class TransformCSVRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		BindyCsvDataFormat bindy = new BindyCsvDataFormat(br.com.danielbgg.transformCSV.Order.class);
		from("file:in/transformCSV?noop=true")
		.unmarshal(bindy)
		.to("jms:queue:orders");
	}

}
