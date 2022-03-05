package za.co.sabre.converter.service;

public enum Imperial
{
	POUND("pound"),
	FAHREINHEIT("fahrenheit"),
	YARD("yard"),
	ACRES("acre"),
	PINT("pint");

	public final String label;

	Imperial( String label ) {
		this.label = label;
	}
}
