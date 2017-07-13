package br.com.danielbgg.transform;

import org.apache.camel.main.Main;

public class MainTransform {

	public static void main(String... strings) throws Exception {
		Main main = new Main();
		main.addRouteBuilder(new TransformRouteBuilder());
		main.run(strings);
	}

}
