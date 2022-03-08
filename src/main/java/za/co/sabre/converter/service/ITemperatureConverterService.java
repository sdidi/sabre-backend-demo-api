package za.co.sabre.converter.service;

import org.apache.commons.math3.util.Precision;

public interface ITemperatureConverterService
{
	Double convertToMetric( double fahrenheitValue );
	Double convertToImperial( double celsiusValue );
}
