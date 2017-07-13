package br.com.danielbgg.converter;

import java.io.Serializable;

public class Order implements Serializable {

	private int id;
	private String description;
	private double price;
	private double tax;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", description=" + description + ", price=" + price + ", tax=" + tax + "]";
	}

}
