package br.com.danielbgg.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class LogProcessor implements Processor {

	@Override
	public void process(Exchange arg0) throws Exception {
		String body = arg0.getIn().getBody(String.class);
		System.out.println("Conteudo do arquivo: " + body);
	}

}
