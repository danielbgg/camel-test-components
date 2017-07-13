package br.com.danielbgg.transformTemplate;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;

public class TransformTemplateRouteBuilder  extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:in/transformTemplate?noop=true")
		.unmarshal()
		.bindy(BindyType.Csv, br.com.danielbgg.transformTemplate.Order.class)
		.to("velocity:br/com/danielbgg/transformTemplate/email.vm")
		.to("file:out/transformTemplate");
	}
}
