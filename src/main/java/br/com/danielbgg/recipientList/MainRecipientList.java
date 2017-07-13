package br.com.danielbgg.recipientList;

import org.apache.camel.main.Main;

public class MainRecipientList {

	public static void main(String... strings) throws Exception {
		Main main = new Main();
		main.addRouteBuilder(new RecipientListRouteBuilder());
		main.run(strings);
	}

}
