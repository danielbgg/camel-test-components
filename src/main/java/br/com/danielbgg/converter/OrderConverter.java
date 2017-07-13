package br.com.danielbgg.converter;

import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.apache.camel.TypeConverter;
import org.apache.camel.component.file.GenericFile;

@Converter
public class OrderConverter {

	@Converter
	public static <T> Order toOrder(GenericFile<T> data, Exchange exchange) {
		TypeConverter converter = exchange.getContext().getTypeConverter();
		String s = converter.convertTo(String.class, data);
		if (s == null) {
			throw new IllegalArgumentException("data is invalid");
		}
		String[] split = s.split(",");
		String idAsString = split[0];
		String description = split[1];
		String priceAsString = split[2];
		String taxAsString = split[3];
		Integer id = converter.convertTo(Integer.class, idAsString);
		Double price = converter.convertTo(Double.class, priceAsString);
		Double tax = converter.convertTo(Double.class, taxAsString);
		Order o = new Order();
		o.setId(id);
		o.setDescription(description);
		o.setPrice(price);
		o.setTax(tax);
		return o;
	}

}
