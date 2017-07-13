package br.com.danielbgg.wscodefirst;

import org.apache.camel.builder.RouteBuilder;

public class WSCodeFirstRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

        from("file:in/wscodefirst?noop=true")
        	.log("body contents initial: ${body}")
       	    .to("cxf:http://localhost:9000/order?dataFormat=MESSAGE")
        	.log("body contents final: ${body}");
        
    }

}