package br.com.danielbgg.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.camel.builder.RouteBuilder;

public class ThreadRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		ExecutorService threadPool = Executors.newFixedThreadPool(20);
		
		from("file:in/orders")
		.log("Starting to process file")
		.split(body().tokenize("\n")).streaming()
		//.parallelProcessing()
		.executorService(threadPool)
		.bean(String.class, "convertCSVToObject")
		.to("direct:update").end()
		.log("Done processing file");
		
		from("direct:update").bean(String.class, "updateDatabase");
				
	}

}