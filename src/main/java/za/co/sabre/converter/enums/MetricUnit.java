package za.co.sabre.converter.enums;

public enum MetricUnit
{
	KILOGRAM(2.2046),
	OUNCE(0.02835),
	TONNNE(1000.0),
	LITRE(1.76),
	METER(1.0936),
	FEET(0.3048),
	INCH(0.0254),
	CELSIUS(33.80),
	HECTARE(2.4711),
	GALLON(4.5460),
	POUND(0.4536),
	FAHREINHEIT(-17.21),
	YARD(0.9144 ),
	ACRE(0.4046),
	PINT(0.5683);

	public final Double factor;
	MetricUnit(Double factor) {
		this.factor = factor;
	}
}
