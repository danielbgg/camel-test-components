package br.com.danielbgg.wscodefirst;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface OrderProcessor {

	@WebMethod
	public int getAvailableItems(@WebParam(name = "itemName") String itemName);
}
