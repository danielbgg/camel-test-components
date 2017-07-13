package br.com.danielbgg.jetty;

import org.apache.camel.main.Main;

public class MainJetty {

	/**
	 * A main() so we can easily run these routing rules in our IDE
	 */
	public static void main(String... args) throws Exception {
		Main main = new Main();
		main.addRouteBuilder(new JettyRouteBuilder());
		main.run(args);
	}

}