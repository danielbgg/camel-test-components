package br.com.danielbgg.wiretrap;

import org.apache.camel.main.Main;

public class MainWireTrap {

	public static void main(String...strings) throws Exception {
		Main main = new Main();
		main.addRouteBuilder(new WireTrapRouteBuilder());
		main.run(strings);
	}
	
}
