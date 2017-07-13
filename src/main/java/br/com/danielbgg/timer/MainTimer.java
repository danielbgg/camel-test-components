package br.com.danielbgg.timer;

import org.apache.camel.main.Main;

public class MainTimer {

	public static void main(String... args) throws Exception {
		Main main = new Main();
		main.addRouteBuilder(new TimerRouteBuilder());
		main.run(args);
	}

}
