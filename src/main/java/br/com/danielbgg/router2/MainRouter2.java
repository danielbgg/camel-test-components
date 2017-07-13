package br.com.danielbgg.router2;

import org.apache.camel.main.Main;

public class MainRouter2 {

	public static void main(String... args) throws Exception {
		Main main = new Main();
		main.addRouteBuilder(new Router2RouteBuilder());
		main.run(args);
	}

}
