package za.co.sabre.converter.service;

public enum Metric
{
	KILOGRAM("kilogram"),
	LITRE("litre"),
	METER("meter"),
	CELSIUS("celsius"),
	HECTARE("hectare");

	public final String label;

	private Metric(String label) {
		this.label = label;
	}
}
