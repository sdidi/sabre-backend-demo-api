package za.co.sabre.converter.service;

public enum MetricUnit
{
	KILOGRAM("kilogram"),
	LITRE("litre"),
	METER("meter"),
	CELSIUS("celsius"),
	HECTARE("hectare");

	public final String label;

	private MetricUnit(String label) {
		this.label = label;
	}
}
