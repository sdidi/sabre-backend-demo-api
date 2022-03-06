package za.co.sabre.converter.service;

import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

@Service
public class AreaConverterService implements  ConverterService
{
	@Override
	public Double convertToMetric( double acresValue )
	{
		return Precision.round(acresValue / 2.4711, 2  );
	}

	@Override
	public Double convertToImperial( double hectaresValue )
	{
		return Precision.round( hectaresValue * 2.4711,2);
	}
}
