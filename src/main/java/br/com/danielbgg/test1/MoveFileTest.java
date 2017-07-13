package br.com.danielbgg.test1;

import java.io.File;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MoveFileTest extends CamelTestSupport {

    @Override
    public void setUp() throws Exception { 
        deleteDirectory("target/inbox"); 
        deleteDirectory("target/outbox"); 
        super.setUp();
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception { 
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file://target/inbox").to("file://target/outbox"); 
            }
        };
    }

    @Test
    public void testMoveFile() throws Exception { 
        template.sendBodyAndHeader("file://target/inbox", "Hello World",Exchange.FILE_NAME, "hello.txt"); 
        Thread.sleep(5000); 
        File target = new File("target/outbox/hello.txt");
        assertTrue("File not moved", target.exists()); 
    }
}