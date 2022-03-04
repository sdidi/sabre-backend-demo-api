package za.co.sabre.converter.service;

import org.apache.commons.math3.util.Precision;

public class VolumeConverterService implements  MetricConverter
{
	@Override
	public double convertToMetric( double pintValue )
	{
		return Precision.round(pintValue / 1.76,2  );
	}

	@Override
	public double convertToImperial( double litreValue )
	{
		return Precision.round(litreValue * 1.76,2  );
	}
}
