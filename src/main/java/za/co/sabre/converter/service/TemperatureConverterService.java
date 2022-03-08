package za.co.sabre.converter.service;

import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

@Service
public class TemperatureConverterService implements ITemperatureConverterService
{
	@Override
	public Double convertToMetric( double fahrenheitValue )
	{
		return Precision.round((fahrenheitValue -32 )* 5 / 9,2  );
	}
	@Override
	public Double convertToImperial( double celsiusValue )
	{
		return Precision.round((celsiusValue * 9 / 5 ) + 32,2  );
	}
}
