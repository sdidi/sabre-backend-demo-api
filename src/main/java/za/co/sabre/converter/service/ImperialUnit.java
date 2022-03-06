package za.co.sabre.converter.service;

public enum ImperialUnit
{
	POUND("pound"),
	FAHREINHEIT("fahrenheit"),
	YARD("yard"),
	ACRES("acre"),
	PINT("pint");

	public final String label;

	ImperialUnit( String label ) {
		this.label = label;
	}
}
