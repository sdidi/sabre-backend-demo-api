package za.co.sabre.converter.service;

import org.apache.commons.math3.util.Precision;

public class TemperatureConverterService implements MetricConverter {

	@Override
	public double convertToMetric( double fahrenheitValue )
	{
		return Precision.round((fahrenheitValue -32 )* 5 / 9,2  );
	}

	@Override
	public double convertToImperial( double celsiusValue )
	{
		return Precision.round((celsiusValue * 9 / 5 ) + 32,2  );
	}
}
