package br.com.danielbgg.test2;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class TestWithMock extends CamelTestSupport {

	@Override
	protected RouteBuilder createRouteBuilder() throws Exception {
		return new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from("file:in/test2?noop=true").to("mock:orders");
			}
		};
	}

	@Test
	public void test() throws Exception {
		MockEndpoint mock = getMockEndpoint("mock:orders");
		mock.expectedMessageCount(1);
		//mock.expectedBodiesReceived("JB421 Course");
		mock.assertIsSatisfied();

		List<Exchange> exchanges = mock.getReceivedExchanges();
		String body = exchanges.get(0).getIn().getBody(String.class);
		assertTrue(body.contains("JB421 Course"));
	}
}