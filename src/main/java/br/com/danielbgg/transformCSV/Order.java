package br.com.danielbgg.transformCSV;

import java.io.Serializable;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",", crlf = "UNIX")
public class Order implements Serializable {

	@DataField(pos = 1)
	private int id;
	@DataField(pos = 2)
	private String description;
	@DataField(pos = 3)
	private double price;
	@DataField(pos = 4)
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
