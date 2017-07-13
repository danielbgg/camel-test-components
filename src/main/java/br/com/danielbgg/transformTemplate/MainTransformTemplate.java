package br.com.danielbgg.transformTemplate;

import org.apache.camel.main.Main;

public class MainTransformTemplate {
	
	public static void main(String...strings) throws Exception {
		Main main = new Main();
		main.addRouteBuilder(new TransformTemplateRouteBuilder());
		main.run(strings);
	}

}
