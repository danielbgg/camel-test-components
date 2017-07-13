package br.com.danielbgg.transformDirect;

import java.io.Serializable;

public class Order implements Serializable {

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescrption(String description) {
		this.description = description;
	}

}
