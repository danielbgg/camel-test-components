package br.com.danielbgg.splitter;

import org.apache.camel.main.Main;

public class MainSplitter extends Main{

	public static void main(String... args) throws Exception {
		Main main = new Main();
		main.addRouteBuilder(new SplitterRouteBuilder());
		main.run(args);
	}
	
}
