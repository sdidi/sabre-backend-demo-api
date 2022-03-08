package za.co.sabre.converter.service;

import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;
import za.co.sabre.converter.enums.MetricUnit;

@Service
public class GeneralConverterService implements  ConverterService
{
	@Override
	public Double convert( Double unitValue, MetricUnit fromUnit, MetricUnit toUnit )
	{
		return Precision.round( unitValue * fromUnit.factor,2);
	}
}
