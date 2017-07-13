package br.com.danielbgg.aggregate;

import org.apache.camel.main.Main;

public class MainAggregate {
	
	public static void main(String...strings) throws Exception {
		Main main = new Main();
		main.addRouteBuilder(new AggregateRouteBuilder());
		main.run(strings);
	}

}
