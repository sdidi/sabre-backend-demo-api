package za.co.sabre.converter.enums;

public enum MetricUnit
{
	KILOGRAM("kilogram"),
	LITRE("litre"),
	METER("meter"),
	CELSIUS("celsius"),
	HECTARE("hectare"),
	POUND("pound"),
	FAHREINHEIT("fahrenheit"),
	YARD("yard"),
	ACRES("acre"),
	PINT("pint");

	public final String label;

	private MetricUnit(String label) {
		this.label = label;
	}
}
