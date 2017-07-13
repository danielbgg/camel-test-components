package br.com.danielbgg.transformXML;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;

public class TransformXMLRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		JaxbDataFormat dataFormat = new JaxbDataFormat();
		dataFormat.setContextPath("br.com.danielbgg.transformXML");
		from("file:in/transformXML?noop=true")
		.unmarshal(dataFormat)
		.to("jms:queue:orders");
	}

}