package br.com.danielbgg.jetty;

import org.apache.camel.builder.RouteBuilder;

public class JettyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

        from("timer:ping?fixedRate=true&delay=0&period=6000")
        	.log("Gravando pagina...")
        	.to("jetty:http://www.apache.org")    
            .to("file:out/apache/?fileName=home.html");
        
    }

}