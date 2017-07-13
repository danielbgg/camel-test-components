package br.com.danielbgg.handlerException;

import org.apache.camel.main.Main;

public class MainHandlerException {

	public static void main(String... args) throws Exception {
		Main main = new Main();
		main.addRouteBuilder(new HandlerExceptionRouteBuilder());
		main.run(args);
	}
	
}
