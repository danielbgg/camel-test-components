package br.com.danielbgg.transaction;

import org.apache.camel.builder.RouteBuilder;

public class TransactionRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:input")
		.beanRef("nonTransactedProcessor", "doWork")
		.transacted("PROPAGATION_REQUIRED")
		.beanRef("firstTransactedProcessor", "doWork")
		.beanRef("secondTransactedProcessor", "doWork")
		.to("direct:output");
		
		
		
		
		from("file:in?noop=true")
	    .transacted()
	    .beanRef("accountService","credit")
	    .choice().when(xpath("/transaction/transfer[amount > 100]"))
        	.markRollbackOnly()
	    .otherwise()
	        .to("direct:txsmall");

		from("direct:txsmall")
		    .beanRef("accountService","debit")
		    .beanRef("accountService","dumpTable")
		    .to("file:target/messages/small"); 
		
		
		
		
        from("file:in?noop=true")
        .doTry()
            .to("direct:split")
        .doCatch(IllegalArgumentException.class)
            .to("file:target/messages?fileName=deadLetters.xml&fileExist=Append")
        .end();
    
	    from("direct:split")
	        .transacted()
	        .beanRef("accountService","credit")
	        .beanRef("accountService","debit")
	        .beanRef("accountService","dumpTable")
	        .to("file:target/messages");
	}		
		
}