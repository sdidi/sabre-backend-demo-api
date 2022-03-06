package za.co.sabre.converter.service;

import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

@Service
public class WeightConverterService implements ConverterService
{
	@Override
	public Double convertToMetric( double poundValue )
	{
		return Precision.round(poundValue / 2.2046,2  );
	}

	@Override
	public Double convertToImperial( double kilogramValue )
	{
		return Precision.round(kilogramValue * 2.2046,2  );
	}
}
