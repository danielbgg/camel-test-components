package br.com.danielbgg.aggregate;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class BodyAggregate implements AggregationStrategy {

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		if (oldExchange == null) {
			System.out.println("Old Exchange null. Retorno: " + newExchange.getIn().getBody(String.class));
			return newExchange;
		}
		String newBody = newExchange.getIn().getBody(String.class);
		String oldBody = oldExchange.getIn().getBody(String.class);
		newBody = newBody.concat(oldBody);
		newExchange.getIn().setBody(newBody);
		System.out.println("Exchange. Retorno: " + newBody);
		return newExchange;
	}

}
