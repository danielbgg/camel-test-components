package br.com.danielbgg.wscodefirst;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "br.com.danielbgg.wscodefirst.OrderProcessor", serviceName = "orderProcessor")
public class OrderProcessorImpl implements OrderProcessor {
	
	@WebMethod
	public int getAvailableItems(String itemName) {
		System.out.println("!!!AQUI!!!");
		if ("PENCIL".equals(itemName)) {
			return 0;
		} else {
			return 100;
		}
	}

}
