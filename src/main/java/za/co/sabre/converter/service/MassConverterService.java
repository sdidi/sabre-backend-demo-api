package za.co.sabre.converter.service;

import org.apache.commons.math3.util.Precision;

public class MassConverterService implements MetricConverter
{
	@Override
	public double convertToMetric( double poundValue )
	{
		return Precision.round(poundValue / 2.2046,2  );
	}

	@Override
	public double convertToImperial( double kilogramValue )
	{
		return Precision.round(kilogramValue * 2.2046,2  );
	}
}
