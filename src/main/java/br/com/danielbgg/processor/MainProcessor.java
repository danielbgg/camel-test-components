package br.com.danielbgg.processor;

import org.apache.camel.main.Main;

public class MainProcessor {

	public static void main(String... args) throws Exception {
		Main main = new Main();
		main.addRouteBuilder(new ProcessorRouteBuilder());
		main.run(args);
	}
}
