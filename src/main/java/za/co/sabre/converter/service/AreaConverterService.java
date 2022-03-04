package za.co.sabre.converter.service;

import org.apache.commons.math3.util.Precision;

public class AreaConverterService implements  MetricConverter
{
	@Override
	public double convertToMetric( double acresValue )
	{
		return Precision.round(acresValue / 2.4711, 2  );
	}

	@Override
	public double convertToImperial( double hectaresValue )
	{
		return Precision.round( hectaresValue * 2.4711,2);
	}
}
