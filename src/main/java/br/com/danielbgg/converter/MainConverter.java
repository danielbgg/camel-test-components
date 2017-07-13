package br.com.danielbgg.converter;

import org.apache.camel.main.Main;

public class MainConverter {

	public static void main(String... strings) throws Exception {
		Main main = new Main();
		main.addRouteBuilder(new ConverterRouteBuilder());
		main.run(strings);
	}
}
